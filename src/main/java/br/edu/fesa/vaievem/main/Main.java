
package br.edu.fesa.vaievem.main;

import br.edu.fesa.vaievem.dao.utils.Conexao;
import br.edu.fesa.vaievem.dao.utils.DbProjetoDAO;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = Conexao.getInstance().getConnection();
            System.out.println("Conexão bem sucedida");  
        } catch(ClassNotFoundException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não foi possível carregar o driver de conexão com a base de dados");
        } catch(SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao enviar o comando para a base de dados");
        } catch(PersistenciaException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de persistência de dados");
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
    
}
