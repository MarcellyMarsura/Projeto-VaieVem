package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class HomeController implements Initializable {

    @FXML
    private Text txtTituloMensagem;
    
    @FXML
    private Text txtMensagem;
    
    @FXML
    private Text txtSaldoTotal;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTituloMensagem.setText("Parabéns!"); //TODO: Obter título da model Mensagem (regra no service)
        txtMensagem.setText("Tudo certo com as suas finanças."); //TODO: Obter conteúdo da model Mensagem (regra no service)
        txtSaldoTotal.setText("100,00"); //TODO: Obter saldo total pelo service
    }
    
    @FXML
    private void onMouseClicked_btnLancamentoConta() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_LANCAMENTO_CONTA.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
    
    @FXML
    private void onMouseClicked_btnLancamentoCartao() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_LANCAMENTO_CARTAO.getNome());
        }
        catch (Exception erro){
            ViewConfiguration.exibeMensagemErro(erro.getMessage());
        }
    }
    
}
