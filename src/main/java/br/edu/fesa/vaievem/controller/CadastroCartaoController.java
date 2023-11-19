package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.models.Cartao;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.services.CartaoService;
import br.edu.fesa.vaievem.services.ContaBancariaService;
import br.edu.fesa.vaievem.services.interfaces.ICartaoService;
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

public class CadastroCartaoController implements Initializable {

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtDiaFechamento;

    @FXML
    private TextField txtDiaVencimento;

    @FXML
    private ComboBox<ContaBancaria> cbConta;

    @FXML
    private TextField txtLimite;

    private static TipoCadastro tipoCadastro;
    private static Cartao cartao;

    IContaBancariaService _contaBancariaService;
    ICartaoService _cartaoService;

    public static void setCartao(Cartao cartao) {
        CadastroCartaoController.cartao = cartao;
    }

    public static void setTipoCadastro(TipoCadastro tipoCadastro) {
        CadastroCartaoController.tipoCadastro = tipoCadastro;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            _contaBancariaService = new ContaBancariaService();
            _cartaoService = new CartaoService();
            configurarTela();
            preencheTela();
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void configurarTela() {
        try {
            cbConta.setItems(_contaBancariaService.listarComboBox());
            txtLimite.setTextFormatter(FormatString.formataInputDouble());
            txtDiaFechamento.setTextFormatter(FormatString.formataInputDay());
            txtDiaVencimento.setTextFormatter(FormatString.formataInputDay());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void preencheTela() {
        try {

            if (cartao != null) {
                cbConta.setValue(cartao.getContaBancaria());
                txtDiaFechamento.setText(String.valueOf(cartao.getDiaFechamento()));
                txtDiaVencimento.setText(String.valueOf(cartao.getDiaVencimento()));
                txtLimite.setText(String.valueOf(cartao.getLimiteEstipulado()));
                txtDescricao.setText(cartao.getDescricao());
            }

        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CARTOES.getNome());
        } catch (UnsupportedOperationException erro) {
            MessageBox.exibeAlerta("Erro", erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnSalvar() throws IOException {

        try {
            Cartao novoCartao = SalvarCartao();

            if (novoCartao != null) {
                switch (tipoCadastro.getTipo()) {
                    case 0:
                        _cartaoService.inserir(novoCartao);
                        break;
                    case 1:
                        novoCartao.setIdCartao(cartao.getIdCartao());
                        _cartaoService.alterar(novoCartao);
                        break;
                    default:
                        throw new LogicalException("Erro ao salvar.");
                }
                ViewConfiguration.mudaTela(Tela.CARTOES.getNome());
            }

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }

    }

    private Cartao SalvarCartao() {
        try {
            ContaBancaria conta = cbConta.getValue();
            String descricao = txtDescricao.getText().trim();
            Integer diaFechamento = txtDiaFechamento.getText().trim().isEmpty() ? 0 : Integer.valueOf(txtDiaFechamento.getText().trim());
            Integer diaVencimento = txtDiaVencimento.getText().trim().isEmpty() ? 0 : Integer.valueOf(txtDiaVencimento.getText().trim());
            Float limite = txtLimite.getText().trim().isEmpty() ? 0F : Float.valueOf(txtLimite.getText().trim());

            if (conta == null || descricao.isEmpty()) {
                throw new LogicalException("Preencha todos os campos obrigatórios.");
            }

            if (diaFechamento == 0 || diaFechamento > 31 || diaVencimento == 0 || diaVencimento > 31) {
                throw new LogicalException("Dias inválidos.");
            }

            Cartao novoCartao = new Cartao();
            novoCartao.setContaBancaria(conta);
            novoCartao.setDescricao(descricao);
            novoCartao.setDiaFechamento(diaFechamento);
            novoCartao.setDiaVencimento(diaVencimento);
            novoCartao.setLimiteEstipulado(limite);

            return novoCartao;

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
        return null;
    }

}
