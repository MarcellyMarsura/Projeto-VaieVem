
package br.edu.fesa.vaievem.main;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.UsuarioService;


public class Main {
    
    private static final UsuarioService usuarioService = new UsuarioService();
    
    public static void main(String[] args) {
        
        try{ 
            TesteUsuario();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private static void TesteUsuario() throws PersistenciaException, LogicalException {
        usuarioService.inserir(new Usuario("b@email.com", "123"));
        
        System.out.println(usuarioService.autenticaUsuario(new Usuario("b@email.com", "123")));
    }
}