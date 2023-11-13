
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Cartao;
import br.edu.fesa.vaievem.viewmodels.CartaoViewModel;
import javafx.collections.ObservableList;

public interface ICartaoService extends IGenericoTabela<Cartao, CartaoViewModel> {
    
    // Tabela full - Listagem Cartao
    // Descrição limite Conta
    // Retorna em ViewModel por Usuario
    // Pesquisar por descrição
    
    
    // Tabela - Detalhes conta
    // Descrição limite
    // Retorna em ViewModel por conta
    ObservableList<CartaoViewModel> listarDadosTabelaPorConta(long idContaBancaria) throws PersistenciaException, LogicalException; 
    
    void inserir(Cartao cartao) throws PersistenciaException, LogicalException; 
    
    void alterar(Cartao cartao) throws PersistenciaException, LogicalException; 
    
    void remover(Cartao cartao) throws PersistenciaException, LogicalException; 
}
