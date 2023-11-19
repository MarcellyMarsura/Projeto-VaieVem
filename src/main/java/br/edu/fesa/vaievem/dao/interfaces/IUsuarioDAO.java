
package br.edu.fesa.vaievem.dao.interfaces;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Usuario;


public interface IUsuarioDAO extends IGenericoDAO<Usuario> {
    
    Usuario listarPorEmail(String email) throws PersistenciaException;
}