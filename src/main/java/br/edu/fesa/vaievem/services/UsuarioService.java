
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.UsuarioDAO;
import br.edu.fesa.vaievem.dao.interfaces.IUsuarioDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.interfaces.IUsuarioService;
import br.edu.fesa.vaievem.utils.Security;
import br.edu.fesa.vaievem.utils.Session;
import java.util.regex.Pattern;

public class UsuarioService implements IUsuarioService {

    private final IUsuarioDAO _usuarioDAO = new UsuarioDAO();
    private String _emailRegex;
    private Pattern _pattern;
    
    public UsuarioService(){        
        iniciaRegex();
    }
    
    private void iniciaRegex(){
        _emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9]+(.[A-Za-z0-9]+)+$";
        _pattern = Pattern.compile(_emailRegex);
    }
    
    // Métodos privados auxiliares
     private void realizaValidacoesUsuario(Usuario usuario) throws PersistenciaException, LogicalException {
        
        // Valida se o e-mail está no padrão do Regex
        if(emailInvalido(usuario)){
            throw new LogicalException("E-mail inválido");
        }
        
        // Valida se o e-mail já está cadastrado
        if(emailJaCadastrado(usuario)){
            throw new LogicalException("E-mail já cadastrado");
        }   
        
        if(senhaInvalida(usuario)){
            throw new LogicalException("A senha deve ter no mínimo 3 caracteres!");
        }    
    }    
    
    private boolean emailInvalido(Usuario usuario) throws PersistenciaException {
        return !_pattern.matcher(usuario.getEmail()).matches();
    }
    
    private boolean emailJaCadastrado(Usuario usuario) throws PersistenciaException {
        
        Usuario usuarioBD = _usuarioDAO.listarPorEmail(usuario.getEmail());        
        
        return usuarioBD != null && !usuarioBD.getIdUsuario().equals(usuario.getIdUsuario());
    }
    
    private boolean senhaInvalida(Usuario usuario){
        return usuario.getSenha().length() < 3;
    }

    private void encriptaSenha(Usuario usuario) throws PersistenciaException {
        usuario.setSenha(Security.EncriptaString(usuario.getSenha()));
    }

    private Usuario retornaUsuarioSession() throws LogicalException { 
        Usuario retorno = Session.getUsuarioLogado();
        
        if(retorno == null){
            throw new LogicalException("Nenhum usuário logado na Session");
        }
        
        return retorno;
    }
    
    // Métodos especilizados do Service
    
    @Override
    public boolean autenticaUsuario(Usuario usuarioForm) throws PersistenciaException, LogicalException {
        Session.RemoveUsuarioLogado();
        
        Usuario usuarioDB = _usuarioDAO.listarPorEmail(usuarioForm.getEmail());
        
        if(usuarioDB == null || !usuarioDB.isAtivo()){
            return false;
        }
        
        boolean senhaValida = Security.ComparaSenha(usuarioDB.getSenha(), usuarioForm.getSenha());
        
        if(senhaValida){
            Session.setUsuarioLogado(usuarioDB);
        }
        
        return senhaValida;
    }

    @Override
    public void inserir(Usuario novoUsuario) throws PersistenciaException, LogicalException {
        
        Session.RemoveUsuarioLogado();
        
        realizaValidacoesUsuario(novoUsuario);
        
        encriptaSenha(novoUsuario);
        _usuarioDAO.inserir(novoUsuario);
        
        Session.setUsuarioLogado(_usuarioDAO.listarPorEmail(novoUsuario.getEmail()));
    }
        
    @Override
    public void alterarDados(Usuario usuarioAlterado) throws PersistenciaException, LogicalException {
        Usuario usuarioLogado = retornaUsuarioSession();

        usuarioAlterado.setIdUsuario(usuarioLogado.getIdUsuario());
        usuarioAlterado.setSenha(usuarioLogado.getSenha());
        usuarioAlterado.setAtivo(usuarioLogado.isAtivo());
        
        realizaValidacoesUsuario(usuarioAlterado);

        _usuarioDAO.alterar(usuarioAlterado);    

        Session.setUsuarioLogado(_usuarioDAO.listarPorId(usuarioAlterado.getIdUsuario()));    
    }

    @Override
    public void alterarSenha(String senhaAntiga, String senhaNova) throws PersistenciaException, LogicalException {
        Usuario usuarioLogado = retornaUsuarioSession();
        Usuario usuarioAlterado = new Usuario(usuarioLogado.getIdUsuario(), usuarioLogado.getNome(), usuarioLogado.getEmail(), senhaNova);
        
        if(!Security.EncriptaString(senhaAntiga).equals(usuarioLogado.getSenha())){
            throw new LogicalException("Senha antiga está incorreta.");
        }
        
        realizaValidacoesUsuario(usuarioAlterado); 
        encriptaSenha(usuarioAlterado);
        
        _usuarioDAO.alterar(usuarioAlterado); 
        
        Session.setUsuarioLogado(_usuarioDAO.listarPorId(usuarioAlterado.getIdUsuario()));    
    }

    @Override
    public void inativar() throws PersistenciaException, LogicalException {
        Usuario usuarioLogado = retornaUsuarioSession();
        
        usuarioLogado.setAtivo(false);

        _usuarioDAO.alterar(usuarioLogado);    
        
        Session.RemoveUsuarioLogado();
    }

    @Override
    public Usuario listarPorEmail(Usuario usuario) throws PersistenciaException, LogicalException {
        return _usuarioDAO.listarPorEmail(usuario.getEmail());
    }
    
}
