/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.dao;

import br.edu.fesa.vaievem.dao.interfaces.ILancamentoContaDAO;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.LancamentoConta;
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
public class LancamentoContaDAO implements ILancamentoContaDAO{

    private LancamentoConta ConverteResultParaModel(ResultSet result) throws SQLException{
        return new LancamentoConta (
                result.getLong("ID_LANCAMENTO_CONTA"),
                result.getLong("TIPO_LANCAMENTO_ID"),
                result.getLong("CONTA_BANCARIA_ID"),
                result.getDate("DATA_LANCAMENTO"),
                result.getFloat("VALOR"),
                result.getString("COMENTARIO")
        );
    }
    
    @Override
    public List<LancamentoConta> listarPorUsuario (long idUsuario) throws PersistenciaException {
        
        List<LancamentoConta> retorno = new ArrayList<>();
        String sql = "SELECT ID_LANCAMENTO_CONTA, TIPO_LANCAMENTO_ID, CONTA_BANCARIA_ID, DATA_LANCAMENTO, VALOR, COMENTARIO " +
                     "FROM LANCAMENTO.TB_LANCAMENTO_CONTA JOIN CONTA.TB_CONTA_BANCARIA " +
                     "ON LANCAMENTO.TB_LANCAMENTO_CONTA.CONTA_BANCARIA_ID = CONTA.TB_CONTA_BANCARIA.ID_CONTA_BANCARIA " +
                     "WHERE CONTA.TB_CONTA_BANCARIA.USUARIO_ID = ?";
        
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idUsuario);
         
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                retorno.add(ConverteResultParaModel(result));
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
    public List<LancamentoConta> listarPorConta(long idContaBancaria) throws PersistenciaException{
        List<LancamentoConta> retorno = new ArrayList<>();
        String sql = "SELECT * FROM LANCAMENTO.TB_LANCAMENTO_CONTA WHERE CONTA_BANCARIA_ID = ?";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idContaBancaria);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                retorno.add(ConverteResultParaModel(result));
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
    public List<LancamentoConta> listarDespesas(long idUsuario) throws PersistenciaException{
        List<LancamentoConta> retorno = new ArrayList<>();
        String sql = "SELECT ID_LANCAMENTO_CONTA, TIPO_LANCAMENTO_ID, CONTA_BANCARIA_ID, DATA_LANCAMENTO, VALOR, COMENTARIO " +
                     "FROM LANCAMENTO.TB_LANCAMENTO_CONTA JOIN CONTA.TB_CONTA_BANCARIA " +
                     "ON LANCAMENTO.TB_LANCAMENTO_CONTA.CONTA_BANCARIA_ID = CONTA.TB_CONTA_BANCARIA.ID_CONTA_BANCARIA " +
                     "WHERE CONTA.TB_CONTA_BANCARIA.USUARIO_ID = ? AND LANCAMENTO.TB_LANCAMENTO_CONTA.TIPO_LANCAMENTO_ID = 1";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idUsuario);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                retorno.add(ConverteResultParaModel(result));
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
    public List<LancamentoConta> listarReceitas(long idUsuario) throws PersistenciaException{
        List<LancamentoConta> retorno = new ArrayList<>();
        String sql = "SELECT ID_LANCAMENTO_CONTA, TIPO_LANCAMENTO_ID, CONTA_BANCARIA_ID, DATA_LANCAMENTO, VALOR, COMENTARIO " +
                     "FROM LANCAMENTO.TB_LANCAMENTO_CONTA JOIN CONTA.TB_CONTA_BANCARIA " +
                     "ON LANCAMENTO.TB_LANCAMENTO_CONTA.CONTA_BANCARIA_ID = CONTA.TB_CONTA_BANCARIA.ID_CONTA_BANCARIA " +
                     "WHERE CONTA.TB_CONTA_BANCARIA.USUARIO_ID = ? AND LANCAMENTO.TB_LANCAMENTO_CONTA.TIPO_LANCAMENTO_ID = 2";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idUsuario);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                retorno.add(ConverteResultParaModel(result));
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
    public List<LancamentoConta> listarDespesasPorConta(long idContaBancaria) throws PersistenciaException{
        List<LancamentoConta> retorno = new ArrayList<>();
        String sql = "SELECT * FROM LANCAMENTO.TB_LANCAMENTO_CONTA WHERE TIPO_LANCAMENTO_ID = 1 AND CONTA_BANCARIA_ID = ?";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idContaBancaria);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                retorno.add(ConverteResultParaModel(result));
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
    public List<LancamentoConta> listarReceitasPorConta(long idContaBancaria) throws PersistenciaException{
        List<LancamentoConta> retorno = new ArrayList<>();
        String sql = "SELECT * FROM LANCAMENTO.TB_LANCAMENTO_CONTA WHERE TIPO_LANCAMENTO_ID = 2 AND CONTA_BANCARIA_ID = ?";
        Connection connection = null;
        
        try {
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, idContaBancaria);
            ResultSet result = pStatement.executeQuery();
            
            while (result.next()) {
                retorno.add(ConverteResultParaModel(result));
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
    public List<LancamentoConta> listar() throws PersistenciaException {
        List<LancamentoConta> retorno = new ArrayList<>();
        String sql = "SELECT * FROM LANCAMENTO.TB_LANCAMENTO_CONTA";
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
    public LancamentoConta listarPorId(Long id) throws PersistenciaException {
        LancamentoConta retorno = null;
        String sql = "SELECT * FROM LANCAMENTO.TB_LANCAMENTO_CONTA WHERE ID_LANCAMENTO_CONTA = ?";
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
    public void inserir(LancamentoConta e) throws PersistenciaException {
        String sql = "INSERT INTO LANCAMENTO.TB_LANCAMENTO_CONTA (TIPO_LANCAMENTO_ID, CONTA_BANCARIA_ID, DATA_LANCAMENTO, VALOR, COMENTARIO) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        
        try{
            connection = Conexao.getInstance().getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, e.getTipoLancamento().getIdTipoLancamento());
            pStatement.setLong(2, e.getContaBancaria().getIdContaBancaria());
            pStatement.setDate(3, new java.sql.Date(e.getDataLancamento().getTime()));
            pStatement.setFloat(4, e.getValor());
            pStatement.setString(5, e.getComentario());
            
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
    public void alterar(LancamentoConta e) throws PersistenciaException {
        String sql = "UPDATE LANCAMENTO.TB_LANCAMENTO_CONTA SET TIPO_LANCAMENTO_ID = ?, CONTA_BANCARIA_ID = ?, DATA_LANCAMENTO = ?, VALOR = ?, COMENTARIO = ? WHERE ID_LANCAMENTO_CONTA = ?";
        Connection connection = null;
        
        try{
            if(e.getIdLancamentoConta() == null){    
                throw new PersistenciaException("Id do Lançamento informado está null");
            }
            
            if(listarPorId(e.getIdLancamentoConta()) == null){
                throw new PersistenciaException("Usuário não localizado");
            }
            
            connection = Conexao.getInstance().getConnection();
                        
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, e.getTipoLancamento().getIdTipoLancamento());
            pStatement.setLong(2, e.getContaBancaria().getIdContaBancaria());
            pStatement.setDate(3, new java.sql.Date(e.getDataLancamento().getTime()));
            pStatement.setFloat(4, e.getValor());
            pStatement.setString(5, e.getComentario());
            pStatement.setLong(6, e.getIdLancamentoConta());

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
        String sql = "DELETE FROM LANCAMENTO.TB_LANCAMENTO_CONTA WHERE ID_LANCAMENTO_CONTA = ?";
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
