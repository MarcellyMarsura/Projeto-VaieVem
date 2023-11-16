/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.dao;

import br.edu.fesa.vaievem.dao.interfaces.ILancamentoCartaoDAO;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.LancamentoCartao;
import br.edu.fesa.vaievem.dao.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Analuz
 */
public class LancamentoCartaoDAO implements ILancamentoCartaoDAO {

    private LancamentoCartao ConverteResultParaModel(ResultSet result) throws SQLException{
        return new LancamentoCartao (
                result.getLong("ID_LANCAMENTO_CARTAO"),
                result.getLong("CARTAO_ID"),
                result.getDate("DATA_LANCAMENTO"),
                result.getFloat("VALOR"),
                result.getString("COMENTARIO")
        );
    }
    
    @Override
    public List<LancamentoCartao> listar() throws PersistenciaException {
        List<LancamentoCartao> retorno = new ArrayList<>();
        String sql = "SELECT * FROM LANCAMENTO.TB_LANCAMENTO_CARTAO";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                retorno.add(ConverteResultParaModel(result));
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
    public LancamentoCartao listarPorId(Long id) throws PersistenciaException {
        LancamentoCartao retorno = null;
        String sql = "SELECT * FROM LANCAMENTO.TB_LANCAMENTO_CARTAO WHERE ID_LANCAMENTO_CARTAO = ?";
        Connection connection = null;
        
        try{
            
            if(id == null){    
                throw new PersistenciaException("Id do Usuario informado está null");
            }
            
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, id);
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
    public void inserir(LancamentoCartao e) throws PersistenciaException {
        String sql = "INSERT INTO LANCAMENTO.TB_LANCAMENTO_CARTAO (CARTAO_ID, DATA_LANCAMENTO, VALOR, COMENTARIO) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, e.getCartao().getIdCartao());
            pStatement.setDate(2, new java.sql.Date(e.getDataLancamento().getTime()));
            pStatement.setFloat(3, e.getValor());
            pStatement.setString(4, e.getComentario());
            
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
    public void alterar(LancamentoCartao e) throws PersistenciaException {
        String sql = "UPDATE LANCAMENTO.TB_LANCAMENTO_CARTAO SET CARTAO_ID = ?, DATA_LANCAMENTO = ?, VALOR = ?, COMENTARIO = ? WHERE ID_LANCAMENTO_CARTAO = ?";
        Connection connection = null;
        
        try{
            if(e.getIdLancamentoCartao() == null){    
                throw new PersistenciaException("Id do Lançamento informado está null");
            }
            
            if(listarPorId(e.getIdLancamentoCartao()) == null){
                throw new PersistenciaException("Usuário não localizado");
            }
            
            connection = Conexao.getInstance().getConnection();
                        
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, e.getCartao().getIdCartao());
            pStatement.setDate(2, new java.sql.Date(e.getDataLancamento().getTime()));
            pStatement.setFloat(3, e.getValor());
            pStatement.setString(4, e.getComentario());
            pStatement.setLong(5, e.getIdLancamentoCartao());

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
    public void remover(Long id) throws PersistenciaException {
        String sql = "DELETE FROM LANCAMENTO.TB_LANCAMENTO_CARTAO WHERE ID_LANCAMENTO_CARTAO = ?";
        Connection connection = null;
        
        try{
            if(id == null){    
                throw new PersistenciaException("Id do Lançamento informado está null");
            }
            
            if(listarPorId(id) == null){
                return;
            }
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, id);

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
