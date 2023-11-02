
package br.edu.fesa.vaievem.dao.utils;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;


public class Conexao {
    
    private final ResourceBundle DAO = ResourceBundle.getBundle("dao", new Locale("pt", "BR"));
    
    private static final DbProjetoDAO dbProjetoDAO = new DbProjetoDAO();
    private static Conexao conexao;
    
    
    private Conexao() throws PersistenciaException{
    }
    
    public static Conexao getInstance() throws PersistenciaException{
        if(conexao == null){
            conexao = new Conexao();
            
            dbProjetoDAO.validaDbProjeto();
        }
        return conexao;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DAO.getString("driver"));
        Connection connection = DriverManager.getConnection(DAO.getString("url"), DAO.getString("usuario"), DAO.getString("senha"));
        return connection;
    }
}
