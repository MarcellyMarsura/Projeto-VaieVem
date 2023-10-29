/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.App;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author m.molinari.marsura
 */
public class CadastroUsuarioController implements Initializable {

    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtSenha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ViewConfiguration.setPossuiMenu(false);
    }
    
    @FXML
    private void onMouseClicked_lnkEntrar() throws IOException{
        try {
            ViewConfiguration.setRoot(Tela.LOGIN.getNome());
        }
        catch (Exception erro){
            //TODO
        }
        
    }
    
    @FXML
    private void onMouseClicked_btnCadastrar() throws IOException{
        try {
            String nome = txtEmail.getText();
            String email = txtEmail.getText();
            String senha = txtSenha.getText();
            
            ViewConfiguration.setRoot(Tela.HOME.getNome());
            //TODO
        }
        catch (Exception erro){
            //TODO
        }
        
    }    
    
}
