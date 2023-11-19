/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.mockService;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.LancamentoConta;
import br.edu.fesa.vaievem.services.interfaces.ILancamentoContaService;
import br.edu.fesa.vaievem.viewmodels.LancamentoViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author m.molinari.marsura
 */
public class LancamentoContaService implements ILancamentoContaService {

    @Override
    public ObservableList<LancamentoViewModel> listarDadosTabelaPorConta(long idContaBancaria) throws PersistenciaException, LogicalException {
        return FXCollections.observableArrayList(new LancamentoViewModel("1", "Despesa", "05/11/2002", "1000,00", "Primeira compra"));
    }

    @Override
    public double somaTotalDespesas() throws PersistenciaException, LogicalException {
        return 350;
    }

    @Override
    public double somaTotalReceitas() throws PersistenciaException, LogicalException {
        return 652.23;
    }

    @Override
    public double retornaSaldoTotal() throws PersistenciaException, LogicalException {
        return 0;
    }

    @Override
    public double retornaSaldoPorConta(long idContaBancaria) throws PersistenciaException, LogicalException {
        return 0;
    }

    @Override
    public void inserir(LancamentoConta lancamentoConta) throws PersistenciaException, LogicalException {

    }

    @Override
    public ObservableList<LancamentoViewModel> listarDadosTabela(String pesquisa) throws PersistenciaException, LogicalException {
        return FXCollections.observableArrayList();
    }
    
}
