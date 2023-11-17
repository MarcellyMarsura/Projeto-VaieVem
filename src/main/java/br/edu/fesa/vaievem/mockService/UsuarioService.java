/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.mockService;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.interfaces.IUsuarioService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.molinari.marsura
 */
public class UsuarioService implements IUsuarioService {

    public static List<Usuario> usuarios = new ArrayList<Usuario>();
    public static long proximoId = 0L;
    public static Usuario usuarioAtual = new Usuario("Teste", "Teste", "Teste");
    
    @Override
    public boolean autenticaUsuario(Usuario usuario) throws PersistenciaException, LogicalException {
        return true;
    }

    @Override
    public void inserir(Usuario usuario) throws PersistenciaException, LogicalException {
        usuario.setIdUsuario(proximoId++);
        usuarios.add(usuario);
    }

    @Override
    public void alterarDados(Usuario usuario) throws PersistenciaException, LogicalException {
        if (usuario == null) {
            throw new IllegalArgumentException("O usuário fornecido é nulo.");
        }

        if (usuario.getIdUsuario() < 0) {
            throw new LogicalException("ID do usuário inválido.");
        }

        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == usuario.getIdUsuario()) {
                u.setNome(usuario.getNome());
                u.setEmail(usuario.getEmail());

                return;
            }
        }

        throw new PersistenciaException("Usuário com ID " + usuario.getIdUsuario() + " não encontrado na lista.");
    }

    @Override
    public void alterarSenha(String senhaAntiga, String senhaNova) throws PersistenciaException, LogicalException {
        
    }

    @Override
    public void inativar() throws PersistenciaException, LogicalException {
        
    }

    @Override
    public Usuario listarPorEmail(Usuario usuario) throws PersistenciaException, LogicalException {
        return new Usuario();
    }
    
}
