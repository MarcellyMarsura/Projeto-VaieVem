
package br.edu.fesa.vaievem.dao.interfaces;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Usuario;
import java.util.List;

public interface IUsuarioDAO extends IGenericoDAO<Usuario> {
    
    Usuario listarPorEmail(Usuario usuario) throws PersistenciaException;
    
    List<Usuario> listarAtivos() throws PersistenciaException;
}