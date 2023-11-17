/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.mockService;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.TipoLancamento;
import br.edu.fesa.vaievem.services.interfaces.ITipoLancamentoService;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author m.molinari.marsura
 */
public class TipoLancamentoService implements ITipoLancamentoService {

    @Override
    public List<TipoLancamento> listar() throws PersistenciaException, LogicalException {
        List<TipoLancamento> lista = new ArrayList<TipoLancamento>();
        lista.add(new TipoLancamento(0L, "Receita"));
        lista.add(new TipoLancamento(1L, "Despesa"));
        return lista;
    }

    @Override
    public ObservableList<TipoLancamento> listarComboBox() throws PersistenciaException, LogicalException {
        return FXCollections.observableArrayList(new TipoLancamento(0L, "Receita"), new TipoLancamento(1L, "Despesa"));
                
    }
    
    
    
}
