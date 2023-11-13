
package br.edu.fesa.vaievem.dao.interfaces;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Usuario;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> develop

public interface IUsuarioDAO extends IGenericoDAO<Usuario> {
    
    Usuario listarPorEmail(Usuario usuario) throws PersistenciaException;
<<<<<<< HEAD
    
    List<Usuario> listarAtivos() throws PersistenciaException;
}
=======
}
>>>>>>> develop
