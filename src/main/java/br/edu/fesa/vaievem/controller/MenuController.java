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
            ViewConfiguration.mudaTela(Tela.HOME.getNome());
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnPerfil() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.PERFIL.getNome());
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnContas() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CONTAS.getNome());
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnCartoes() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CARTOES.getNome());
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnSobre() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.SOBRE.getNome());
        }
        catch (Exception erro){
            //TODO
        }
    }
    
    @FXML
    private void onMouseClicked_btnSair() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.LOGIN.getNome());
        }
        catch (Exception erro){
            //TODO
        }
    }
    
}
