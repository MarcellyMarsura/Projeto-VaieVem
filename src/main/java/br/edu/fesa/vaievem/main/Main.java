
package br.edu.fesa.vaievem.main;

import br.edu.fesa.vaievem.dao.UsuarioDAO;
import br.edu.fesa.vaievem.models.Usuario;

public class Main {
    
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        try{
            var usuarios = usuarioDAO.listar();   
            
            for(Usuario u : usuarios){
                System.out.println("Id: " + u.getIdUsuario() + " - Nome: " + u.getNome() + " - Email: " + u.getEmail() + " - Senha: " + u.getSenha() + " - Ativo: " + u.isAtivo() + " - Administrador: " + u.isAdministrador());
            }
            
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
