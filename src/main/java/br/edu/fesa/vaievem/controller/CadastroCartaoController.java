/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author m.molinari.marsura
 */
public class CadastroCartaoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            //TODO: MessageBox para cancelar cadastro
            ViewConfiguration.mudaTela(Tela.CARTOES.getNome());
        } catch (UnsupportedOperationException erro) {
            MessageBox.exibeAlerta("Erro",erro.getMessage());
        }
        catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }
}
