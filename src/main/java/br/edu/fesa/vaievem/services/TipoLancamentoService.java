
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.TipoLancamentoDAO;
import br.edu.fesa.vaievem.dao.interfaces.ITipoLancamentoDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.TipoLancamento;
import br.edu.fesa.vaievem.services.interfaces.ITipoLancamentoService;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class TipoLancamentoService implements ITipoLancamentoService {

    private final ITipoLancamentoDAO _tipoLancamentoDAO = new TipoLancamentoDAO();

    @Override
    public List<TipoLancamento> listar() throws PersistenciaException, LogicalException {
        return _tipoLancamentoDAO.listar();
    }

    @Override
    public ObservableList<TipoLancamento> listarComboBox() throws PersistenciaException, LogicalException {
        return FXCollections.observableArrayList(_tipoLancamentoDAO.listar());
    }
}
