
package br.edu.fesa.vaievem.dao;

import br.edu.fesa.vaievem.dao.interfaces.IContaBancariaDAO;
import br.edu.fesa.vaievem.dao.utils.Conexao;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ContaBancariaDAO implements IContaBancariaDAO {
 
    private ContaBancaria ConverteResultParaModel(ResultSet result) throws SQLException{
        return new ContaBancaria(
                result.getLong("ID_CONTA_BANCARIA"),
                result.getString("DESCRICAO"),
                result.getString("NUMERO_AGENCIA"),
                result.getString("NUMERO_CONTA"),
                result.getFloat("META_CONTA")
        );
    }
        
    private void validaRelacionamentos(ContaBancaria contaBancaria) throws PersistenciaException{
        
        Usuario usuario = contaBancaria.getUsuario();
        
        if(usuario == null || usuario.getIdUsuario() == null){
            throw new PersistenciaException("Usuário inválido");
        }
        
        Banco banco = contaBancaria.getBanco();

        if(banco == null || banco.getIdBanco() == null){
            throw new PersistenciaException("Banco inválido");
        }
    }
    
    @Override
    public List<ContaBancaria> listar() throws PersistenciaException {
        List<ContaBancaria> contasBancarias = new ArrayList<>();
        String sql = "SELECT * FROM CONTA.TB_CONTA_BANCARIA";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                contasBancarias.add(ConverteResultParaModel(result));
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
        
        return contasBancarias;
    }

    @Override
    public ContaBancaria listarPorId(ContaBancaria contaBancaria) throws PersistenciaException {

        ContaBancaria retorno = null;
        String sql = "SELECT * FROM CONTA.TB_CONTA_BANCARIA WHERE ID_CONTA_BANCARIA = ?";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, contaBancaria.getIdContaBancaria());
            ResultSet result = pStatement.executeQuery();
            
            if(result.next()) {
                retorno = ConverteResultParaModel(result);
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
        
        return retorno;
    }

    @Override
    public void inserir(ContaBancaria contaBancaria) throws PersistenciaException {
        
        validaRelacionamentos(contaBancaria);
        
        String sql = "INSERT INTO CONTA.TB_CONTA_BANCARIA (USUARIO_ID, BANCO_ID, DESCRICAO, NUMERO_AGENCIA, NUMERO_CONTA, META_CONTA ) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, contaBancaria.getUsuario().getIdUsuario());
            pStatement.setLong(2, contaBancaria.getBanco().getIdBanco());
            pStatement.setString(3, contaBancaria.getDescricao());
            pStatement.setString(4, contaBancaria.getNumeroAgencia());
            pStatement.setString(5, contaBancaria.getNumeroConta());
            pStatement.setFloat(6, contaBancaria.getMeta());
            pStatement.execute();
            
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
    }

    @Override
    public void alterar(ContaBancaria contaBancaria) throws PersistenciaException {
        
        validaRelacionamentos(contaBancaria);
        
        String sql = "UPDATE CONTA.TB_CONTA_BANCARIA SET USUARIO_ID = ?, BANCO_ID = ?, DESCRICAO = ?, NUMERO_AGENCIA = ?, NUMERO_CONTA = ?, META_CONTA = ? WHERE ID_CONTA_BANCARIA = ?";
        Connection connection = null;
        
        try {
            if(contaBancaria.getIdContaBancaria() == null){    
                throw new PersistenciaException("Id da Conta Bancária informada está null");
            }
            
            if(listarPorId(contaBancaria) == null){
                throw new PersistenciaException("Conta Bancária não localizada");
            }
            
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, contaBancaria.getUsuario().getIdUsuario());
            pStatement.setLong(2, contaBancaria.getBanco().getIdBanco());
            pStatement.setString(3, contaBancaria.getDescricao());
            pStatement.setString(4, contaBancaria.getNumeroAgencia());
            pStatement.setString(5, contaBancaria.getNumeroConta());
            pStatement.setFloat(6, contaBancaria.getMeta());
            pStatement.setLong(7, contaBancaria.getIdContaBancaria());
            pStatement.execute();
            
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
    }

    @Override
    public void remover(ContaBancaria contaBancaria) throws PersistenciaException {
        validaRelacionamentos(contaBancaria);
        
        String sql = "DELETE FROM CONTA.TB_CONTA_BANCARIA WHERE ID_CONTA_BANCARIA = ?";
        Connection connection = null;
        
        try {
            if(contaBancaria.getIdContaBancaria() == null){    
                throw new PersistenciaException("Id da Conta Bancária informada está null");
            }
            
            if(listarPorId(contaBancaria) == null){
                return;
            }
            
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, contaBancaria.getIdContaBancaria());
            pStatement.execute();
            
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
    }
    
}
