package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;


public class DetalheContaController implements Initializable {
    
    @FXML
    private Text txtBanco;
    
    @FXML
    private Text txtAgencia;
    
    @FXML
    private Text txtConta;
    
    @FXML
    private Text txtMeta;
    
    @FXML
    private Text txtDescricao;
    
    @FXML
    private Text txtSaldo;
    
    @FXML
    private Text txtFatura;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO: Preencher campos text
    }
    
    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            //TODO: MessageBox para cancelar cadastro
            ViewConfiguration.mudaTela(Tela.CONTAS.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
    
    
}
