/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.mockService;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.models.Mensagem;
import br.edu.fesa.vaievem.services.interfaces.IMensagemService;

/**
 *
 * @author m.molinari.marsura
 */
public class MensagemService implements IMensagemService {

    @Override
    public Mensagem retornaMensagemMeta() throws PersistenciaException, LogicalException {
        return new Mensagem("Titulo", "Mensagem");
    }
    
}
