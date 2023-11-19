
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.TipoLancamento;
import java.util.List;
import javafx.collections.ObservableList;


public interface ITipoLancamentoService {
    
    List<TipoLancamento> listar() throws PersistenciaException, LogicalException; 

    ObservableList<TipoLancamento> listarComboBox() throws PersistenciaException, LogicalException; 
}
