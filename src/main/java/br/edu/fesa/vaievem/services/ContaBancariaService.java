
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.ContaBancariaDAO;
import br.edu.fesa.vaievem.dao.interfaces.IContaBancariaDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.interfaces.IContaBancariaService;
import br.edu.fesa.vaievem.utils.Session;
import br.edu.fesa.vaievem.viewmodels.ContaViewModel;
import java.util.List;
import javafx.collections.ObservableList;


public class ContaBancariaService implements IContaBancariaService {

    private final IContaBancariaDAO _contaBancariaDAO = new ContaBancariaDAO();

    // Métodos privados auxiliares
    
    private Usuario retornaUsuarioSession() throws LogicalException { 
        Usuario retorno = Session.getUsuarioLogado();
        
        if(retorno == null){
            throw new LogicalException("Nenhum usuário logado na Session");
        }
        
        return retorno;
    }
    
    
    // Métodos especilizados do Service

    @Override
    public List<ContaBancaria> listarPorUsuario() throws PersistenciaException, LogicalException {
        Usuario usuario = retornaUsuarioSession();
        
        return _contaBancariaDAO.listarPorUsuario(usuario.getIdUsuario(), null);
    }

    @Override
    public ContaBancaria listarPorId(long idContaBancaria) throws PersistenciaException, LogicalException {
        return _contaBancariaDAO.listarPorId(idContaBancaria);
    }

    @Override
    public void inserir(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void alterar(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<ContaViewModel> listarDadosTabela(String pesquisa) throws PersistenciaException, LogicalException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<ContaBancaria> listarComboBox() throws PersistenciaException, LogicalException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
