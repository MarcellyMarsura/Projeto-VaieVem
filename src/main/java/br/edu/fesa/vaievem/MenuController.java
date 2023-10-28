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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author m.molinari.marsura
 */
public class MenuController implements Initializable {

    @FXML
    private Text txtNome;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String nomeUsuario = "Marcelly"; //TODO: Obter nome do usuário BD
        txtNome.setText(nomeUsuario);
    }
    
    @FXML
    private void onMouseClicked_btnHome() throws IOException {
        try {
            App.setRoot("HomeUsuario");
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnPerfil() throws IOException {
        try {
            App.setRoot("CrudUsuario");
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnContas() throws IOException {
        try {
            App.setRoot("Contas");
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnCartoes() throws IOException {
        try {
            App.setRoot("Cartoes");
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnSobre() throws IOException {
        try {
            App.setRoot("Sobre");
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnSair() throws IOException {
        try {
            App.setRoot("Login");
        }
        catch (Exception erro){
            //TODO
        }
    }
    
}
