
package br.edu.fesa.vaievem.dao;

import br.edu.fesa.vaievem.dao.interfaces.IBancoDAO;
import br.edu.fesa.vaievem.dao.utils.Conexao;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDAO implements IBancoDAO {
    
    private Banco ConverteResultParaModel(ResultSet result) throws SQLException{
        return new Banco(
                result.getLong("ID_BANCO"),
                result.getString("DESCRICAO")
        );
    }
    
    @Override
    public List<Banco> listar() throws PersistenciaException {
        List<Banco> bancos = new ArrayList<>();
        String sql = "SELECT * FROM CONTA.TB_BANCO";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                bancos.add(ConverteResultParaModel(result));
            }
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return bancos;    
    }

    @Override
    public Banco listarPorId(Banco banco) throws PersistenciaException {
        Banco retorno = null;
        String sql = "SELECT * FROM CONTA.TB_BANCO WHERE ID_BANCO = ?";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, banco.getIdBanco());
            ResultSet result = pStatement.executeQuery();
            
            if (result.next()) {
                retorno = ConverteResultParaModel(result);
            }
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retorno;     
    }

    @Override
    public void inserir(Banco banco) throws PersistenciaException {
        String sql = "INSERT INTO CONTA.TB_BANCO (DESCRICAO) VALUES (?)";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, banco.getDescricao());
            pStatement.execute();
            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void alterar(Banco banco) throws PersistenciaException {
        String sql = "UPDATE CONTA.TB_BANCO SET DESCRICAO = ? WHERE ID_BANCO = ?";
        Connection connection = null;
        
        try {
            if(banco.getIdBanco() == null){    
                throw new PersistenciaException("Id do Banco informado está null");
            }
            
            if(listarPorId(banco) == null){
                throw new PersistenciaException("Banco não localizado");
            }
            
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, banco.getDescricao());
            pStatement.setLong(2, banco.getIdBanco());
            pStatement.execute();
            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(Banco banco) throws PersistenciaException {
        String sql = "DELETE FROM CONTA.TB_BANCO WHERE ID_BANCO = ?";
        Connection connection = null;
        
        try {
            if(banco.getIdBanco() == null){    
                throw new PersistenciaException("Id do Banco informado está null");
            }
            
            if(listarPorId(banco) == null){
                return;
            }
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, banco.getIdBanco());
            pStatement.execute();
            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");

        } catch(SQLException ex) {
            Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando para a base de dados");

        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BancoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
