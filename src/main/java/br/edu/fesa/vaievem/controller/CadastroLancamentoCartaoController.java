package br.edu.fesa.vaievem.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroLancamentoCartaoController implements Initializable {

    @FXML
    private ComboBox<String> cbCartao;
    
    @FXML
    private DatePicker txtData;
    
    @FXML
    private TextField txtValor;
    
    @FXML
    private TextArea txtComentario;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    
    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        //TODO
    }
    
    @FXML
    private void onMouseClicked_btnSalvar() throws IOException {
        //TODO
    }
    
}
