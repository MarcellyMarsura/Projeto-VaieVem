package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class PerfilController implements Initializable {

    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtSenhaAntiga;
    
    @FXML
    private TextField txtNovaSenha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Preencher campos de dados da conta
    }    
    
    @FXML
    private void onMouseClicked_btnSalvarDados() throws IOException {
        try {
            // TODO: Alterar do service
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
    
    @FXML
    private void onMouseClicked_btnSalvarSenha() throws IOException {
        try {
            // TODO: Alterar do service
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
    @FXML
    private void onMouseClicked_btnInativarConta() throws IOException {
        try {
            // TODO: Limpar session, chamar metodo inativar do service
            ViewConfiguration.mudaTela(Tela.LOGIN.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
}
