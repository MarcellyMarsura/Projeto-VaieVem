
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.BancoDAO;
import br.edu.fesa.vaievem.dao.interfaces.IBancoDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.services.interfaces.IBancoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BancoService implements IBancoService {

    private final IBancoDAO _bancoDAO = new BancoDAO();
    
    @Override
    public ObservableList<Banco> listar() throws PersistenciaException, LogicalException {
        return FXCollections.observableArrayList(_bancoDAO.listar());
    }
    
}
