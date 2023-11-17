package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.mockService.BancoService;
import br.edu.fesa.vaievem.mockService.ContaBancariaService;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.services.interfaces.IBancoService;
import br.edu.fesa.vaievem.services.interfaces.IContaBancariaService;
import br.edu.fesa.vaievem.utils.FormatString;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.TipoCadastro;
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
    private ComboBox<Banco> cbBanco;

    @FXML
    private TextField txtConta;

    private static ContaBancaria conta;
    private static TipoCadastro tipoCadastro;

    IBancoService _bancoService;
    IContaBancariaService _contaBancariaService;

    public static void setConta(ContaBancaria conta) {
        CadastroContaController.conta = conta;
    }

    public static void setTipoCadastro(TipoCadastro tipoCadastro) {
        CadastroContaController.tipoCadastro = tipoCadastro;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            _bancoService = new BancoService();
            _contaBancariaService = new ContaBancariaService();
            configurarTela();
            preencheTela();
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void configurarTela() {
        try {
            cbBanco.setItems(_bancoService.listar());
            txtMeta.setTextFormatter(FormatString.formataInputDouble());
            txtConta.setTextFormatter(FormatString.formataInputInteger());
            txtAgencia.setTextFormatter(FormatString.formataInputInteger());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void preencheTela() {
        try {

            if (conta != null) {
                cbBanco.setValue(conta.getBanco());
                txtAgencia.setText(conta.getNumeroAgencia());
                txtConta.setText(conta.getNumeroConta());
                txtMeta.setText(conta.getMeta().toString());
                txtDescricao.setText(conta.getDescricao());
            }

        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CONTAS.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnSalvar() throws IOException {
        try {
            ContaBancaria novaConta = SalvarConta();

            if (novaConta == null) {
                throw new LogicalException("Erro ao salvar.");
            }
            
            switch (tipoCadastro.getTipo()) {
                    case 0:
                        _contaBancariaService.inserir(novaConta);
                        break;
                    case 1:
                        _contaBancariaService.alterar(novaConta);
                        break;
                    default:
                        throw new LogicalException("Erro ao salvar.");
                }
            
            ViewConfiguration.mudaTela(Tela.CONTAS.getNome());

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private ContaBancaria SalvarConta() {
        try {
            Banco banco = cbBanco.getValue();
            String descricao = txtDescricao.getText().trim();
            String agencia = txtDescricao.getText().trim();
            String conta = txtDescricao.getText().trim();
            Float meta = txtMeta.getText().trim().isEmpty() ? 0F : Float.valueOf(txtMeta.getText().trim());

            if (banco == null || descricao.isEmpty() || agencia.isEmpty() || conta.isEmpty()) {
                throw new LogicalException("Preencha todos os campos obrigatórios.");
            }

            ContaBancaria novaConta = new ContaBancaria();
            novaConta.setBanco(banco);
            novaConta.setDescricao(descricao);
            novaConta.setNumeroAgencia(agencia);
            novaConta.setNumeroConta(conta);
            novaConta.setMeta(meta);

            return novaConta;
        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
        return null;
    }

}
