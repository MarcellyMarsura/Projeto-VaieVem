
package br.edu.fesa.vaievem.dao.interfaces;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Cartao;
import java.util.List;

public interface ICartaoDAO extends IGenericoDAO<Cartao> {
    
    // Parâmetro descrição é opcional, pode vir null
    List<Cartao> listarPorUsuario(long idUsuario, String descricao) throws PersistenciaException;
    
    List<Cartao> listarPorConta(long idContaBancaria) throws PersistenciaException;
}