
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import javafx.collections.ObservableList;


public interface IBancoService {
    
    ObservableList<Banco> listar() throws PersistenciaException, LogicalException; 

}
