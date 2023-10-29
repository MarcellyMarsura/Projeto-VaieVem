package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ContasController implements Initializable {
    
    @FXML
    private TextField txtPesquisar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO: Obter dados pelo service
    }    
    
    @FXML
    private void onMouseClicked_btnAdicionarConta() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_CONTA.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
    
    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException {
        try {
            //TODO: Atualizar tabela com os dados retornados do service
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
}
