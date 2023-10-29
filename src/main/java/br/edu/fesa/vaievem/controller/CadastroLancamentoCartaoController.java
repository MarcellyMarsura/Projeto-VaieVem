package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
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
        //TODO: Preencher ComboBox cbConta
        //TODO: Método para preencher quando selecionar editar
    }
    
    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            //TODO: MessageBox para cancelar cadastro
            ViewConfiguration.mudaTela(Tela.HOME.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
    
    @FXML
    private void onMouseClicked_btnSalvar() throws IOException {
        try {
            //TODO: Chamar service para salvar no banco
            //TODO: Criar maskedbox para o valor
            //TODO: MessageBox quando Salvar
            ViewConfiguration.mudaTela(Tela.HOME.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
    
}
