
package br.edu.fesa.vaievem.dao.interfaces;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import java.util.List;


public interface IGenericoDAO<E> {
    List<E> listar() throws PersistenciaException;
    
    E listarPorId(Long id) throws PersistenciaException;

    void inserir(E e) throws PersistenciaException;
    
    void alterar(E e) throws PersistenciaException;
    
    void remover(Long id) throws PersistenciaException;

}