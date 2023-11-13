
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import javafx.collections.ObservableList;

public interface IGenericoTabela<Model, ViewModel> {
        
    ObservableList<ViewModel> listarDadosTabela(String pesquisa) throws PersistenciaException, LogicalException; 
}
