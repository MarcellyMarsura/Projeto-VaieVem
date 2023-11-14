
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.viewmodels.ContaViewModel;
import java.util.List;


public interface IContaBancariaService extends IGenericoTabela<ContaBancaria, ContaViewModel> {
    
    // Tabela - Listagem Contas
    // Tipo Data valor Comentario
    // Descrição, agencia, numero da conta, Banco
    // Pode pesquisar por descrição
    
    
    // Listagem full por usuário
    List<ContaBancaria> listarPorUsuario() throws PersistenciaException, LogicalException;   
    
    ContaBancaria listarPorId(long idContaBancaria) throws PersistenciaException, LogicalException; 
    
    void inserir(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException; 
    
    void alterar(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException; 
    
    void remover(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException; 
}
