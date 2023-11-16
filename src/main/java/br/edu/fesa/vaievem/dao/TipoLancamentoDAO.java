/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.dao;

import br.edu.fesa.vaievem.dao.interfaces.ITipoLancamentoDAO;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.dao.utils.Conexao;
import br.edu.fesa.vaievem.models.TipoLancamento;
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
public class TipoLancamentoDAO implements ITipoLancamentoDAO {

    private TipoLancamento ConverteResultParaModel(ResultSet result) throws SQLException{
        return new TipoLancamento (
                result.getLong("ID_TIPO_LANCAMENTO"),
                result.getString("DESCRICAO")
        );
    }
    
    @Override
    public List<TipoLancamento> listar() throws PersistenciaException {
        List<TipoLancamento> retorno = new ArrayList<>();
        String sql = "SELECT * FROM LANCAMENTO.TB_TIPO_LANCAMENTO";
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
    public TipoLancamento listarPorId(Long id) throws PersistenciaException {
        TipoLancamento retorno = null;
        String sql = "SELECT * FROM LANCAMENTO.TB_TIPO_LANCAMENTO WHERE ID_TIPO_LANCAMENTO = ?";
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
    public void inserir(TipoLancamento e) throws PersistenciaException {
        String sql = "INSERT INTO LANCAMENTO.TB_TIPO_LANCAMENTO (DESCRICAO) VALUES (?)";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getDescricao());
            
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
    public void alterar(TipoLancamento e) throws PersistenciaException {
        String sql = "UPDATE LANCAMENTO.TB_TIPO_LANCAMENTO SET DESCRICAO = ? WHERE ID_TIPO_LANCAMENTO = ?";
        Connection connection = null;
        
        try{
            if(e.getIdTipoLancamento() == null){    
                throw new PersistenciaException("Id do Tipo de Lançamento informado está null");
            }
            
            if(listarPorId(e.getIdTipoLancamento()) == null){
                throw new PersistenciaException("Tipo não localizado");
            }
            
            connection = Conexao.getInstance().getConnection();
                        
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, e.getDescricao());
            pStatement.setLong(2, e.getIdTipoLancamento());

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
        String sql = "DELETE FROM LANCAMENTO.TB_TIPO_LANCAMENTO WHERE ID_TIPO_LANCAMENTO = ?";
        Connection connection = null;
        
        try{
            if(id == null){    
                throw new PersistenciaException("Id do Tipo de Lançamento informado está null");
            }
            
            if(listarPorId(id) == null){
                throw new PersistenciaException("Tipo não localizado");
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
