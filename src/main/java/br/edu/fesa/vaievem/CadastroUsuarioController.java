/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.fesa.vaievem;

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
        App.possuiMenu = false;
    }
    
    @FXML
    private void onMouseClicked_lnkEntrar() throws IOException{
        try {
            App.setRoot("Login");
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
            //TODO
        }
        catch (Exception erro){
            //TODO
        }
        
    }    
    
}
