package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class CadastroContaController implements Initializable {
    
    @FXML
    private TextField txtDescricao;
    
    @FXML
    private TextField txtAgencia;
    
    @FXML
    private TextField txtMeta;
    
    @FXML
    private ComboBox cbBanco;
    
    @FXML
    private TextField txtConta;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void onMouseClicked_btnAdicionarCartao() throws IOException {
        try {
            ViewConfiguration.criaModal(Tela.CADASTRO_CARTAO.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            //TODO: MessageBox para cancelar cadastro
            ViewConfiguration.mudaTela(Tela.CONTAS.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
    @FXML
    private void onMouseClicked_btnSalvar() throws IOException {
        try {
            //TODO: Chamar service para salvar no banco
            //TODO: Criar maskedbox para o valor
            ViewConfiguration.mudaTela(Tela.CONTAS.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
}
