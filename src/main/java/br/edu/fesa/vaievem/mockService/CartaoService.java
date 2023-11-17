/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.mockService;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Cartao;
import br.edu.fesa.vaievem.services.interfaces.ICartaoService;
import br.edu.fesa.vaievem.viewmodels.CartaoViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author m.molinari.marsura
 */
public class CartaoService implements ICartaoService {

    
    @Override
    public ObservableList<CartaoViewModel> listarDadosTabelaPorConta(long idContaBancaria) throws PersistenciaException, LogicalException {
        ObservableList<CartaoViewModel> listaCartaoViewModel = FXCollections.observableArrayList();
        return listaCartaoViewModel;
    }

    @Override
    public void inserir(Cartao cartao) throws PersistenciaException, LogicalException {

    }

    @Override
    public void alterar(Cartao cartao) throws PersistenciaException, LogicalException {
    }

    @Override
    public void remover(Cartao cartao) throws PersistenciaException, LogicalException {
       
    }

    @Override
    public ObservableList<CartaoViewModel> listarDadosTabela(String pesquisa) throws PersistenciaException, LogicalException {
        ObservableList<CartaoViewModel> listaCartaoViewModel = FXCollections.observableArrayList();
        return listaCartaoViewModel;
    }
    
}
