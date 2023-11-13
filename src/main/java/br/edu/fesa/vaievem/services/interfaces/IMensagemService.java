
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Mensagem;


public interface IMensagemService {
    
    // Meta conta
    Mensagem retornaMensagemMeta() throws PersistenciaException, LogicalException; 
}
