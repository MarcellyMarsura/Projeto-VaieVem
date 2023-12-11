
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.CartaoDAO;
import br.edu.fesa.vaievem.dao.interfaces.ICartaoDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Cartao;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.interfaces.ICartaoService;
import br.edu.fesa.vaievem.services.interfaces.IContaBancariaService;
import br.edu.fesa.vaievem.utils.Session;
import br.edu.fesa.vaievem.viewmodels.CartaoViewModel;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CartaoService implements ICartaoService {

    private final ICartaoDAO _cartaoDAO = new CartaoDAO();
    private final IContaBancariaService _contaBancariaService = new ContaBancariaService();
    
    // Métodos privados auxiliares

    private Usuario retornaUsuarioSession() throws LogicalException { 
        Usuario retorno = Session.getUsuarioLogado();
        
        if(retorno == null){
            throw new LogicalException("Nenhum usuário logado na Session");
        }
        
        return retorno;
    }
    
    private void realizaValidacoesCartao(Cartao cartao) throws PersistenciaException, LogicalException {
        validaCampos(cartao);
        
        if(contaBancariaInvalida(cartao)){
            throw new LogicalException("Conta Bancária inválida");
        }
    }
    
    private void validaCampos(Cartao cartao) throws LogicalException {
        
        if(cartao.getDescricao() == null || cartao.getDescricao().isBlank()){
            throw new LogicalException("Descrição não pode estar vazia");
        }
        
        if(cartao.getDiaFechamento() < 1 || cartao.getDiaFechamento() > 31){
            throw new LogicalException("Dia de Fechamento deve set entre 1 e 31");
        }
        
        if(cartao.getDiaVencimento() < 1 || cartao.getDiaVencimento() > 31){
            throw new LogicalException("Dia de Vencimento deve ser entre 1 e 31");
        }
        
        if(cartao.getLimiteEstipulado() < 0) {
            throw new LogicalException("Limite deve ser maior que zero");
        }
    }
    
    private boolean contaBancariaInvalida(Cartao cartao)  throws PersistenciaException, LogicalException {
        return cartao.getContaBancaria() == null || _contaBancariaService.listarPorId(cartao.getContaBancaria().getIdContaBancaria()) == null;
    }
    
    // Métodos especilizados do Service

    @Override
    public void inserir(Cartao cartao) throws PersistenciaException, LogicalException {
        realizaValidacoesCartao(cartao);
        
        _cartaoDAO.inserir(cartao);
        
    }

    @Override
    public void alterar(Cartao cartao) throws PersistenciaException, LogicalException {
        realizaValidacoesCartao(cartao);
        
        _cartaoDAO.alterar(cartao);    
    }

    @Override
    public void remover(Cartao cartao) throws PersistenciaException, LogicalException {
        _cartaoDAO.remover(cartao.getIdCartao());    
    }
    
    @Override
    public ObservableList<CartaoViewModel> listarDadosTabela(String pesquisa) throws PersistenciaException, LogicalException {
        List<CartaoViewModel> retorno = new ArrayList<>();

        Usuario usuario = retornaUsuarioSession();
        List<Cartao> cartoesModel =  _cartaoDAO.listarPorUsuario(usuario.getIdUsuario(), pesquisa);
        
        for(Cartao cartaoModel : cartoesModel){
            cartaoModel.setContaBancaria(_contaBancariaService.listarPorId(cartaoModel.getContaBancaria().getIdContaBancaria()));
            
            retorno.add(new CartaoViewModel(cartaoModel));
        }
        
        return FXCollections.observableArrayList(retorno);
    }
    
    @Override
    public ObservableList<CartaoViewModel> listarDadosTabelaPorConta(long idContaBancaria) throws PersistenciaException, LogicalException {
        
        List<CartaoViewModel> retorno = new ArrayList<>();
        
        ContaBancaria conta = _contaBancariaService.listarPorId(idContaBancaria);
        conta.setUsuario(retornaUsuarioSession());
        
        List<Cartao> cartoesModel =  _cartaoDAO.listarPorConta(idContaBancaria);
        
        for(Cartao cartaoModel : cartoesModel){
            cartaoModel.setContaBancaria(conta);
            
            retorno.add(new CartaoViewModel(cartaoModel));
        }
        
        return FXCollections.observableArrayList(retorno);
    }
}
