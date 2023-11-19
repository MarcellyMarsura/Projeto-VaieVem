
package br.edu.fesa.vaievem.dao;

import br.edu.fesa.vaievem.dao.interfaces.ICartaoDAO;
import br.edu.fesa.vaievem.dao.utils.Conexao;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Cartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartaoDAO implements ICartaoDAO {

    private Cartao ConverteResultParaModel(ResultSet result) throws SQLException{
        return new Cartao (
                result.getLong("ID_CARTAO"),
                result.getLong("CONTA_BANCARIA_ID"),
                result.getString("DESCRICAO"),
                result.getInt("DIA_FECHAMENTO"),
                result.getInt("DIA_VENCIMENTO"),
                result.getFloat("LIMITE_ESTIPULADO")
        );
    }
    
    @Override
    public List<Cartao> listarPorUsuario(long idUsuario, String descricao) throws PersistenciaException {
        List<Cartao> cartoes = new ArrayList<>();
        
        String sql;
        if(descricao == null){
            sql = "SELECT ID_CARTAO, CONTA_BANCARIA_ID, CARTAO.TB_CARTAO.DESCRICAO, DIA_FECHAMENTO, DIA_VENCIMENTO, LIMITE_ESTIPULADO FROM CARTAO.TB_CARTAO "
                    + "JOIN CONTA.TB_CONTA_BANCARIA ON CARTAO.TB_CARTAO.CONTA_BANCARIA_ID = CONTA.TB_CONTA_BANCARIA.ID_CONTA_BANCARIA "
                    + "WHERE CONTA.TB_CONTA_BANCARIA.USUARIO_ID = ?";
        }else{         
            sql = "SELECT ID_CARTAO, CONTA_BANCARIA_ID, CARTAO.TB_CARTAO.DESCRICAO, DIA_FECHAMENTO, DIA_VENCIMENTO, LIMITE_ESTIPULADO FROM CARTAO.TB_CARTAO "
                    + "JOIN CONTA.TB_CONTA_BANCARIA ON CARTAO.TB_CARTAO.CONTA_BANCARIA_ID = CONTA.TB_CONTA_BANCARIA.ID_CONTA_BANCARIA "
                    + "WHERE CONTA.TB_CONTA_BANCARIA.USUARIO_ID = ? "
                    + "AND CARTAO.TB_CARTAO.DESCRICAO LIKE ?";
        }       
        
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();           
            PreparedStatement pStatement = connection.prepareStatement(sql);
            
            pStatement.setLong(1, idUsuario);
            if(descricao != null){
                descricao = '%' + descricao + '%';
                pStatement.setString(2, descricao);
            }   
            
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                cartoes.add(ConverteResultParaModel(result));
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
        
        return cartoes;
    }

    @Override
    public List<Cartao> listarPorConta(long idContaBancaria) throws PersistenciaException {
        List<Cartao> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM CARTAO.TB_CARTAO WHERE CONTA_BANCARIA_ID = ?";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idContaBancaria);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                cartoes.add(ConverteResultParaModel(result));
            }
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(ContaBancariaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(ContaBancariaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContaBancariaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return cartoes;
    }

    @Override
    public List<Cartao> listar() throws PersistenciaException {
        List<Cartao> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM CARTAO.TB_CARTAO";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                cartoes.add(ConverteResultParaModel(result));
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
        
        return cartoes;
    }

    @Override
    public Cartao listarPorId(Long idCartao) throws PersistenciaException {
        Cartao retorno = null;
        String sql = "SELECT * FROM CARTAO.TB_CARTAO WHERE ID_CARTAO = ?";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idCartao);
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
    public void inserir(Cartao e) throws PersistenciaException {
        String sql = "INSERT INTO CARTAO.TB_CARTAO (CONTA_BANCARIA_ID, DESCRICAO, DIA_FECHAMENTO, DIA_VENCIMENTO, LIMITE_ESTIPULADO) "
                    + "VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, e.getContaBancaria().getIdContaBancaria());
            pStatement.setString(2, e.getDescricao());
            pStatement.setInt(3, e.getDiaFechamento());
            pStatement.setInt(4,e.getDiaVencimento());
            pStatement.setDouble(5, e.getLimiteEstipulado());
            
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
    public void alterar(Cartao e) throws PersistenciaException {
        
        String sql = "UPDATE CARTAO.TB_CARTAO SET CONTA_BANCARIA_ID = ?, DESCRICAO = ?, DIA_FECHAMENTO = ?, DIA_VENCIMENTO = ?, LIMITE_ESTIPULADO = ? WHERE ID_CARTAO = ?";
        Connection connection = null;
        
        try{
            if(e.getIdCartao() == null){    
                throw new PersistenciaException("Id do Cartão informado está null");
            }
            
            if(listarPorId(e.getIdCartao()) == null){
                throw new PersistenciaException("Cartao não localizado");
            }
            
            connection = Conexao.getInstance().getConnection();
                        
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, e.getContaBancaria().getIdContaBancaria());
            pStatement.setString(2, e.getDescricao());
            pStatement.setInt(3, e.getDiaFechamento());
            pStatement.setInt(4,e.getDiaVencimento());
            pStatement.setDouble(5, e.getLimiteEstipulado());
            pStatement.setDouble(6, e.getIdCartao());

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
    public void remover(Long idCartao) throws PersistenciaException {
        String sql = "DELETE FROM CARTAO.TB_CARTAO WHERE ID_CARTAO = ?";
        Connection connection = null;
        
        try{
            if(idCartao == null){    
                throw new PersistenciaException("Id do Usuario informado está null");
            }
            
            if(listarPorId(idCartao) == null){
                return;
            }
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idCartao);

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
