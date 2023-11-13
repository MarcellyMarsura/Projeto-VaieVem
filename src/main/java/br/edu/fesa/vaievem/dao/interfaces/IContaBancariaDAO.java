
package br.edu.fesa.vaievem.dao.interfaces;

import br.edu.fesa.vaievem.models.ContaBancaria;
import java.util.List;

public interface IContaBancariaDAO extends IGenericoDAO<ContaBancaria> {
    
    // Parâmetro descrição é opcional, pode vir null
    List<ContaBancaria> listarPorUsuario(long idUsuario, String descricao);
}
