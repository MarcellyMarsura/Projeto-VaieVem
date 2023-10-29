/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author m.molinari.marsura
 */
public class CartoesController implements Initializable {

    @FXML
    private ComboBox<String> cbConta;
    
    @FXML
    private TextField txtPesquisar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO: Obter dados pelo service
    }    
    
    @FXML
    private void onMouseClicked_btnAdicionarCartao() throws IOException {
        try {
            ViewConfiguration.criaModal(Tela.CADASTRO_CARTAO.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
    
    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException {
        try {
            //TODO: Atualizar tabela com os dados retornados do service
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
}
