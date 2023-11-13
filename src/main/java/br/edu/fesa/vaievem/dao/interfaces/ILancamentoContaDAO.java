
package br.edu.fesa.vaievem.dao.interfaces;

import br.edu.fesa.vaievem.models.LancamentoConta;
import java.util.List;

public interface ILancamentoContaDAO extends IGenericoDAO<LancamentoConta> {
    
    List<LancamentoConta> listarPorUsuario(long idUsuario);
    
    List<LancamentoConta> listarPorConta(long idContaBancaria);
    
    
    List<LancamentoConta> listarDespesas(long idUsuario);
    
    List<LancamentoConta> listarReceitas(long idUsuario);
    
    
    List<LancamentoConta> listarDespesasPorConta(long idContaBancaria);
    
    List<LancamentoConta> listarReceitasPorConta(long idContaBancaria);
}