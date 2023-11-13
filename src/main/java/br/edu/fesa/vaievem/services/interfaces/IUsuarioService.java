
package br.edu.fesa.vaievem.services.interfaces;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Usuario;

public interface IUsuarioService {
    
    boolean autenticaUsuario(Usuario usuario) throws PersistenciaException, LogicalException; 

    void inserir(Usuario usuario) throws PersistenciaException, LogicalException; 
    
    void alterarDados(Usuario usuario) throws PersistenciaException, LogicalException; 
    
    void alterarSenha(String senhaAntiga, String senhaNova) throws PersistenciaException, LogicalException; 

    void inativar() throws PersistenciaException, LogicalException; 
    
    Usuario listarPorEmail(Usuario usuario) throws PersistenciaException, LogicalException; 
}
