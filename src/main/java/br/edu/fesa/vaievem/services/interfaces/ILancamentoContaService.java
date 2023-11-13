
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.LancamentoConta;
import br.edu.fesa.vaievem.viewmodels.LancamentoViewModel;
import javafx.collections.ObservableList;


public interface ILancamentoContaService extends IGenericoTabela<LancamentoConta, LancamentoViewModel>  {
    
    // Tabela - Home
    // Tipo Data valor Comentario
    // Retorna em ViewModel por usuário
    
    
    // Tabela - Detalhes conta
    // Tipo Data valor Comentario
    // Retorna em ViewModel por conta
    ObservableList<LancamentoViewModel> listarDadosTabelaPorConta(long idContaBancaria) throws PersistenciaException, LogicalException; 
    
    
    // Soma despesa : double
    double somaTotalDespesas() throws PersistenciaException, LogicalException; 
    
    // Soma receita : double
    double somaTotalReceitas() throws PersistenciaException, LogicalException; 
    
    // Consolidar saldo total : float
    double retornaSaldoTotal() throws PersistenciaException, LogicalException; 
    
    // Soma saldo por conta
    double retornaSaldoPorConta(long idContaBancaria) throws PersistenciaException, LogicalException; 
    
    // Salvar
    // Recebe Id usuario, Id Conta e Id Tipo Lançamento
    void inserir(LancamentoConta lancamentoConta) throws PersistenciaException, LogicalException; 
}
