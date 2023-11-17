/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.mockService;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.services.interfaces.IContaBancariaService;
import br.edu.fesa.vaievem.viewmodels.ContaViewModel;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author m.molinari.marsura
 */
public class ContaBancariaService implements IContaBancariaService {

    @Override
    public List<ContaBancaria> listarPorUsuario() throws PersistenciaException, LogicalException {
        List<ContaBancaria> contas = new ArrayList<ContaBancaria>();
        return contas;
    }

    @Override
    public ContaBancaria listarPorId(long idContaBancaria) throws PersistenciaException, LogicalException {
        return new ContaBancaria();
    }

    @Override
    public void inserir(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        
    }

    @Override
    public void alterar(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        
    }

    @Override
    public void remover(ContaBancaria contaBancaria) throws PersistenciaException, LogicalException {
        
    }

    @Override
    public ObservableList<ContaViewModel> listarDadosTabela(String pesquisa) throws PersistenciaException, LogicalException {
        /*
            private SimpleStringProperty Id;
    private SimpleStringProperty Descricao;
    private SimpleStringProperty Agencia;
    private SimpleStringProperty Conta;
    private SimpleStringProperty Banco;
    private SimpleStringProperty Meta;
        */
        
        Banco b = new Banco(0L, "Santander");
        
        
        ContaBancaria c1 = new ContaBancaria();
        c1.setIdContaBancaria(0L);
        c1.setDescricao("C1");
        c1.setNumeroAgencia("2221");
        c1.setNumeroConta("22266321521");
        c1.setBanco(b);
        c1.setMeta(200.36F);
        
        ContaBancaria c2 = new ContaBancaria();
        c2.setIdContaBancaria(1L);
        c2.setDescricao("C2");
        c2.setNumeroAgencia("2221");
        c2.setNumeroConta("22266321521");
        c2.setBanco(b);
        c2.setMeta(204.36F);
        
        
        return FXCollections.observableArrayList(new ContaViewModel(c1), new ContaViewModel(c2));
    }
    
    @Override
    public ObservableList<ContaBancaria> listarComboBox() throws PersistenciaException, LogicalException {
        return FXCollections.observableArrayList(new ContaBancaria(0L, "Conta 0"), new ContaBancaria(1L, "Conta 1"));
    }
    
}
