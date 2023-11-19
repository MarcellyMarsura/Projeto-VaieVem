
package br.edu.fesa.vaievem.dao.interfaces;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.LancamentoConta;
import java.util.List;

public interface ILancamentoContaDAO extends IGenericoDAO<LancamentoConta> {
    
    List<LancamentoConta> listarPorUsuario(long idUsuario) throws PersistenciaException;
    
    List<LancamentoConta> listarPorConta(long idContaBancaria) throws PersistenciaException;
    
    
    List<LancamentoConta> listarDespesas(long idUsuario) throws PersistenciaException;
    
    List<LancamentoConta> listarReceitas(long idUsuario) throws PersistenciaException;
    
    
    List<LancamentoConta> listarDespesasPorConta(long idContaBancaria)throws PersistenciaException;
    
    List<LancamentoConta> listarReceitasPorConta(long idContaBancaria)throws PersistenciaException;
}