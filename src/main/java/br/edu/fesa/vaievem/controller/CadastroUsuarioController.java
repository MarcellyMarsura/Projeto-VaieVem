package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
            ViewConfiguration.mudaTela(Tela.LOGIN.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
        
    }
    
    @FXML
    private void onMouseClicked_btnCadastrar() throws IOException{
        try {
            String nome = txtNome.getText();
            String email = txtEmail.getText();
            String senha = txtSenha.getText();
            
            //TODO: Preencher model Usuario e chamar inserir do service
            //TODO: Em caso de erro, manter dados na tela
            
            ViewConfiguration.mudaTela(Tela.HOME.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
        
    }    
    
}
