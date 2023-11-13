
package br.edu.fesa.vaievem.dao;

import br.edu.fesa.vaievem.dao.interfaces.IUsuarioDAO;
import br.edu.fesa.vaievem.dao.utils.Conexao;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements IUsuarioDAO {

    private Usuario ConverteResultParaModel(ResultSet result) throws SQLException{
        return new Usuario(
                result.getLong("ID_USUARIO"),
                result.getString("NOME"),
                result.getString("EMAIL"),
                result.getString("SENHA"),
                result.getBoolean("ATIVO"),
                result.getBoolean("ADMINISTRADOR")
        );
    }
    
    @Override
    public List<Usuario> listar() throws PersistenciaException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO.TB_USUARIO";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                usuarios.add(ConverteResultParaModel(result));
            }
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return usuarios;
    }
        
    @Override
    public Usuario listarPorId(Usuario usuario) throws PersistenciaException {
        Usuario retorno = null;
        String sql = "SELECT * FROM USUARIO.TB_USUARIO WHERE ID_USUARIO = ?";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, usuario.getIdUsuario());
            ResultSet result = pStatement.executeQuery();
            
            if(result.next()) {
                retorno = ConverteResultParaModel(result);
            }
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retorno;
    }
    
    @Override
    public Usuario listarPorEmail(Usuario usuario) throws PersistenciaException {
        Usuario retorno = null;
        String sql = "SELECT * FROM USUARIO.TB_USUARIO WHERE EMAIL = ?";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, usuario.getEmail());
            ResultSet result = pStatement.executeQuery();
            
            if(result.next()) {
                retorno = ConverteResultParaModel(result);
            }
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retorno;
    }

    
    @Override
    public void inserir(Usuario usuario) throws PersistenciaException {
        String sql = "INSERT INTO USUARIO.TB_USUARIO (NOME, EMAIL, SENHA, ATIVO, ADMINISTRADOR) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, usuario.getNome());
            pStatement.setString(2, usuario.getEmail());
            pStatement.setString(3, usuario.getSenha());
            pStatement.setBoolean(4, usuario.isAtivo());
            pStatement.setBoolean(5, usuario.isAdministrador());
            
            pStatement.execute();
            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }

    @Override
    public void alterar(Usuario usuario) throws PersistenciaException {
        String sql = "UPDATE USUARIO.TB_USUARIO SET NOME = ?, EMAIL = ?, SENHA = ?, ATIVO = ?, ADMINISTRADOR = ? WHERE ID_USUARIO = ?";
        Connection connection = null;
        
        try{
            if(usuario.getIdUsuario() == null){    
                throw new PersistenciaException("Id do Usuario informado está null");
            }
            
            if(listarPorId(usuario) == null){
                throw new PersistenciaException("Usuário não localizado");
            }
            
            connection = Conexao.getInstance().getConnection();
                        
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, usuario.getNome());
            pStatement.setString(2, usuario.getEmail());
            pStatement.setString(3, usuario.getSenha());
            pStatement.setBoolean(4, usuario.isAtivo());
            pStatement.setBoolean(5, usuario.isAdministrador());
            pStatement.setLong(6, usuario.getIdUsuario());

            pStatement.execute();
            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }

    @Override
    public void remover(Usuario usuario) throws PersistenciaException {
        String sql = "DELETE FROM USUARIO.TB_USUARIO WHERE ID_USUARIO = ?";
        Connection connection = null;
        
        try{
            if(usuario.getIdUsuario() == null){    
                throw new PersistenciaException("Id do Usuario informado está null");
            }
            
            if(listarPorId(usuario) == null){
                return;
            }
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, usuario.getIdUsuario());

            pStatement.execute();
            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }
}
