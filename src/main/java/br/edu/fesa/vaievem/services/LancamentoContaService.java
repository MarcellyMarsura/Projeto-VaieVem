
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.ContaBancariaDAO;
import br.edu.fesa.vaievem.dao.LancamentoContaDAO;
import br.edu.fesa.vaievem.dao.TipoLancamentoDAO;
import br.edu.fesa.vaievem.dao.interfaces.IContaBancariaDAO;
import br.edu.fesa.vaievem.dao.interfaces.ILancamentoContaDAO;
import br.edu.fesa.vaievem.dao.interfaces.ITipoLancamentoDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.LancamentoConta;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.interfaces.ILancamentoContaService;
import br.edu.fesa.vaievem.utils.Session;
import br.edu.fesa.vaievem.viewmodels.LancamentoViewModel;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class LancamentoContaService implements ILancamentoContaService {
    
    private final ILancamentoContaDAO _lancamentoContaDAO = new LancamentoContaDAO();
    private final IContaBancariaDAO _contaBancariaDAO = new ContaBancariaDAO();
    private final ITipoLancamentoDAO _tipoLancamentoDAO = new TipoLancamentoDAO();
    
    // Métodos privados auxiliares

    private Usuario retornaUsuarioSession() throws LogicalException { 
        Usuario retorno = Session.getUsuarioLogado();
        
        if(retorno == null){
            throw new LogicalException("Nenhum usuário logado na Session");
        }
        
        return retorno;
    }
    
    private void realizaValidacoesLancamento(LancamentoConta lancamento) throws PersistenciaException, LogicalException {
        validaCampos(lancamento);
        
        if(tipoLancamentoInvalido(lancamento)){
            throw new LogicalException("Tipo de Lancamento inválido");
        }
        
        if(contaBancariaInvalida(lancamento)){
            throw new LogicalException("Conta Bancária inválida");
        }
    }
    
    private void validaCampos(LancamentoConta lancamento) throws LogicalException {
        if(lancamento.getDataLancamento() == null){
            throw new LogicalException("Data de Lançamento não pode estar vazia");
        }
        if(lancamento.getValor() <= 0){
            throw new LogicalException("Valor do Lançamento deve ser maior que zero");
        }
    }
    
    private boolean contaBancariaInvalida(LancamentoConta lancamento)  throws PersistenciaException, LogicalException {
        return lancamento.getContaBancaria() == null || _contaBancariaDAO.listarPorId(lancamento.getContaBancaria().getIdContaBancaria()) == null;
    }
    
    private boolean tipoLancamentoInvalido(LancamentoConta lancamento)  throws PersistenciaException, LogicalException {
        return lancamento.getTipoLancamento() == null || _tipoLancamentoDAO.listarPorId(lancamento.getTipoLancamento().getIdTipoLancamento()) == null;
    }
    
    
    // Métodos especilizados do Service
    
    @Override
    public void inserir(LancamentoConta lancamentoConta) throws PersistenciaException, LogicalException {
        realizaValidacoesLancamento(lancamentoConta);
        
        _lancamentoContaDAO.inserir(lancamentoConta);
    }

    @Override
    public double somaTotalDespesas() throws PersistenciaException, LogicalException {

        double retorno = 0;
        
        Usuario usuario = retornaUsuarioSession();
        List<LancamentoConta> despesas = _lancamentoContaDAO.listarDespesas(usuario.getIdUsuario());
        
        for(LancamentoConta despesa : despesas){
            retorno += despesa.getValor();
        }
        
        return retorno;        
    }

    @Override
    public double somaTotalReceitas() throws PersistenciaException, LogicalException {
        double retorno = 0;
        
        Usuario usuario = retornaUsuarioSession();
        List<LancamentoConta> receitas = _lancamentoContaDAO.listarReceitas(usuario.getIdUsuario());
        
        for(LancamentoConta receita : receitas){
            retorno += receita.getValor();
        }
        
        return retorno;  
    }

    @Override
    public double retornaSaldoTotal() throws PersistenciaException, LogicalException {
        return somaTotalReceitas() - somaTotalDespesas();
    }

    @Override
    public double retornaSaldoPorConta(long idContaBancaria) throws PersistenciaException, LogicalException {
        double retorno = 0;
        
        if(_contaBancariaDAO.listarPorId(idContaBancaria) == null){
            throw new LogicalException("Conta Bancária inválida");
        }
        
        List<LancamentoConta> receitas = _lancamentoContaDAO.listarReceitasPorConta(idContaBancaria);
        List<LancamentoConta> despesas = _lancamentoContaDAO.listarDespesasPorConta(idContaBancaria);
        
        for(LancamentoConta receita : receitas){
            retorno += receita.getValor();
        }
        for(LancamentoConta despesa : despesas){
            retorno -= despesa.getValor();
        }
        
        return retorno;  
    }

    @Override
    public ObservableList<LancamentoViewModel> listarDadosTabelaPorConta(long idContaBancaria) throws PersistenciaException, LogicalException {
        
        ContaBancaria conta = _contaBancariaDAO.listarPorId(idContaBancaria);
        
        if(conta == null){
            throw new LogicalException("Conta Bancária inválida");
        }
        
        List<LancamentoViewModel> retorno = new ArrayList<>();
        List<LancamentoConta> lancamentosModel =  _lancamentoContaDAO.listarPorConta(idContaBancaria);
        
        for(LancamentoConta lancamentoModel : lancamentosModel){
            lancamentoModel.setContaBancaria(conta);
            lancamentoModel.setTipoLancamento(_tipoLancamentoDAO.listarPorId(lancamentoModel.getTipoLancamento().getIdTipoLancamento()));
            retorno.add(new LancamentoViewModel(lancamentoModel));
        }
        
        return FXCollections.observableArrayList(retorno);
    }
    
    @Override
    public ObservableList<LancamentoViewModel> listarDadosTabela(String pesquisa) throws PersistenciaException, LogicalException {

        Usuario usuario = retornaUsuarioSession();
        
        List<LancamentoViewModel> retorno = new ArrayList<>();
        List<LancamentoConta> lancamentosModel =  _lancamentoContaDAO.listarPorUsuario(usuario.getIdUsuario(), pesquisa);
        
        for(LancamentoConta lancamentoModel : lancamentosModel){
            lancamentoModel.setContaBancaria(_contaBancariaDAO.listarPorId(lancamentoModel.getContaBancaria().getIdContaBancaria()));
            lancamentoModel.setTipoLancamento(_tipoLancamentoDAO.listarPorId(lancamentoModel.getTipoLancamento().getIdTipoLancamento()));
            retorno.add(new LancamentoViewModel(lancamentoModel));
        }
        
        return FXCollections.observableArrayList(retorno);
    }
}
