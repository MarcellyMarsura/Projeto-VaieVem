
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.interfaces.IBancoDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.services.interfaces.IBancoService;
import java.util.List;


public class BancoService implements IBancoService {

    private final IBancoDAO _bancoDAO;
    
    public BancoService(IBancoDAO bancoDAO) {
        this._bancoDAO = bancoDAO;
    }
        
    
    @Override
    public List<Banco> listar() throws PersistenciaException, LogicalException {
        return _bancoDAO.listar();
    }
    
}
