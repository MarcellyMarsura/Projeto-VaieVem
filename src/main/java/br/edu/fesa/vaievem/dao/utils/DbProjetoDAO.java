
package br.edu.fesa.vaievem.dao.utils;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbProjetoDAO {
    
    private final ResourceBundle DB_PROJETO = ResourceBundle.getBundle("db_projeto", new Locale("pt", "BR"));
    private final ResourceBundle DAO = ResourceBundle.getBundle("dao", new Locale("pt", "BR"));

    public void validaDbProjeto() throws PersistenciaException {
        validaSchemas();
        validaTabelas();
    }
    
    private void executaResourceBundle(String key) throws PersistenciaException {
        
        String sql = DB_PROJETO.getString(key);
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            
            pStatement.execute();
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");
        } catch(SQLException ex) {
            Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando de criação " + key + " para a base de dados");
        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean verificaExistenciaSchema(String nomeSchema) throws PersistenciaException {
        
        String sql = "SELECT COUNT(*) FROM SYS.SYSSCHEMAS WHERE SCHEMANAME = ?";
        Connection connection = null;
        boolean retorno = false;
        
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, nomeSchema);
            
            ResultSet result = pStatement.executeQuery();
            retorno = (result.next() && result.getInt(1) == 1);
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");
        } catch(SQLException ex) {
            Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando de criação para a base de dados");
        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retorno;
    }
    
    private boolean verificaExistenciaTabela(String nomeTabela) throws PersistenciaException {
        
        String sql = "SELECT COUNT(*) FROM SYS.SYSTABLES WHERE TABLENAME = ?";
        Connection connection = null;
        boolean retorno = false;
        
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, nomeTabela);
            
            ResultSet result = pStatement.executeQuery();
            retorno = (result.next() && result.getInt(1) == 1);
        
        } catch(ClassNotFoundException ex){
            Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível carregar o driver de conexão com a base de dados");
        } catch(SQLException ex) {
            Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Erro ao enviar o comando de criação para a base de dados");
        } finally {
            try {
                if(connection != null && ! connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DbProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retorno;
    }
    
    
    private void validaSchemas() throws PersistenciaException {
        String[] schemas = DAO.getString("schemas").split(",");
        
        for (String schema : schemas) {
            if(!verificaExistenciaSchema(schema.toUpperCase())){
                executaResourceBundle(schema);
            }
        }
    }
    
    private void validaTabelas() throws PersistenciaException {
        String[] tabelas = DAO.getString("tabelas").split(",");
        
        for (String tabela : tabelas) {
            if(!verificaExistenciaTabela(tabela.toUpperCase())){
                executaResourceBundle(tabela);
            }
        }
    }
    
}
