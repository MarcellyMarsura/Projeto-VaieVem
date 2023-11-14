
package br.edu.fesa.vaievem.services;

import br.edu.fesa.vaievem.dao.interfaces.ITipoLancamentoDAO;
import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.TipoLancamento;
import br.edu.fesa.vaievem.services.interfaces.ITipoLancamentoService;
import java.util.List;


public class TipoLancamentoService implements ITipoLancamentoService {

    private final ITipoLancamentoDAO _tipoLancamentoDAO;
    
    public TipoLancamentoService(ITipoLancamentoDAO tipoLancamentoDAO) {
        this._tipoLancamentoDAO = tipoLancamentoDAO;
    }
        
    
    @Override
    public List<TipoLancamento> listar() throws PersistenciaException, LogicalException {
        return _tipoLancamentoDAO.listar();
    }
    
}
