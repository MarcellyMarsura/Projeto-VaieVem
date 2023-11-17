/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.mockService;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.services.interfaces.IBancoService;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author m.molinari.marsura
 */
public class BancoService implements IBancoService {

    @Override
    public ObservableList<Banco> listar() throws PersistenciaException, LogicalException {

        return FXCollections.observableArrayList(new Banco(0L, "Santander"), new Banco(1L, "Bradesco"),  new Banco(2L, "Nubank"), new Banco(3L, "Banco do Brasil"));
    }
    
}
