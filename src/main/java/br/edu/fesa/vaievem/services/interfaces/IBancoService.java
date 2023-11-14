
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import java.util.List;


public interface IBancoService {
    
    List<Banco> listar() throws PersistenciaException, LogicalException; 

}
