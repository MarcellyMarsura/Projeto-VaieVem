
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.BancoDAO;
import br.edu.fesa.vaievem.dao.ContaBancariaDAO;
import br.edu.fesa.vaievem.dao.interfaces.IBancoDAO;
import br.edu.fesa.vaievem.dao.interfaces.IContaBancariaDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.interfaces.IContaBancariaService;
import br.edu.fesa.vaievem.utils.Session;
import br.edu.fesa.vaievem.viewmodels.ContaViewModel;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ContaBancariaService implements IContaBancariaService {

    private final IContaBancariaDAO _contaBancariaDAO = new ContaBancariaDAO();
    private final IBancoDAO _bancoDAO = new BancoDAO();

    // Métodos privados auxiliares
    
    private Usuario retornaUsuarioSession() throws LogicalException { 
        Usuario retorno = Session.getUsuarioLogado();
        
        if(retorno == null){
            throw new LogicalException("Nenhum usuário logado na Session");
        }
        
        return retorno;
    }
    
    private void realizaValidacoesConta(ContaBancaria conta) throws PersistenciaException, LogicalException {
        validaCampos(conta); 
        
        if(bancoInvalido(conta)){
            throw new LogicalException("Banco inválido");
        }
    }
    
    private void validaCampos(ContaBancaria conta) throws LogicalException{
        if(conta.getDescricao() == null || conta.getDescricao().isBlank()){
            throw new LogicalException("Descrição não pode ser vazia");
        }
        
        if(conta.getMeta() < 0){
            throw new LogicalException("Meta não deve ser menor que zero");
        }
        
        if(conta.getNumeroAgencia() != null && conta.getNumeroAgencia().length() != 4){
            throw new LogicalException("Número da agência deve conter 4 números");
        }
        
        if(conta.getNumeroConta() != null){
            if(conta.getNumeroConta().length() != 6){
                throw new LogicalException("Número da conta deve conter 6 números");
            }
            conta.setNumeroConta(conta.getNumeroConta().substring(0, 5) + "-" + conta.getNumeroConta().substring(5));
        }
    }
    
    private boolean metaInvalida(ContaBancaria conta) throws LogicalException{
        return conta.getMeta() < 0;
    }
    
    private boolean bancoInvalido(ContaBancaria conta)  throws PersistenciaException, LogicalException {
        return conta.getBanco() == null || _bancoDAO.listarPorId(conta.getBanco().getIdBanco()) == null;
    }

    // Métodos especilizados do Service

    @Override
    public List<ContaBancaria> listarPorUsuario() throws PersistenciaException, LogicalException {
        Usuario usuario = retornaUsuarioSession();
        
        List<ContaBancaria> contas = _contaBancariaDAO.listarPorUsuario(usuario.getIdUsuario(), null);
        
        for(ContaBancaria conta : contas){
            conta.setUsuario(usuario);
            conta.setBanco(_bancoDAO.listarPorId(conta.getBanco().getIdBanco()));
        }
        
        return contas;
    }

    @Override
    public ContaBancaria listarPorId(long idContaBancaria) throws PersistenciaException, LogicalException {
        
        ContaBancaria retorno = _contaBancariaDAO.listarPorId(idContaBancaria);
        
        retorno.setUsuario(retornaUsuarioSession());
        retorno.setBanco(_bancoDAO.listarPorId(retorno.getBanco().getIdBanco()));

        return retorno;
    }

    @Override
    public void inserir(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        
        contaBancaria.setUsuario(retornaUsuarioSession());
        realizaValidacoesConta(contaBancaria);
        
        _contaBancariaDAO.inserir(contaBancaria);
    }

    @Override
    public void alterar(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        contaBancaria.setUsuario(retornaUsuarioSession());
        realizaValidacoesConta(contaBancaria);
        
        _contaBancariaDAO.alterar(contaBancaria);    
    }

    @Override
    public void remover(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        _contaBancariaDAO.remover(contaBancaria.getIdContaBancaria());    
    }

    @Override
    public ObservableList<ContaViewModel> listarDadosTabela(String pesquisa) throws PersistenciaException, LogicalException {
        List<ContaViewModel> retorno = new ArrayList<>();
        
        Usuario usuario = retornaUsuarioSession();
        
        List<ContaBancaria> contasModel = _contaBancariaDAO.listarPorUsuario(usuario.getIdUsuario(), pesquisa);
        
        for(ContaBancaria contaModel : contasModel){
            contaModel.setUsuario(usuario);
            contaModel.setBanco(_bancoDAO.listarPorId(contaModel.getBanco().getIdBanco()));
            
            retorno.add(new ContaViewModel(contaModel));
        }
        
        return FXCollections.observableArrayList(retorno);
    }

    @Override
    public ObservableList<ContaBancaria> listarComboBox() throws PersistenciaException, LogicalException {
        return FXCollections.observableArrayList(listarPorUsuario());
    }
    
}
