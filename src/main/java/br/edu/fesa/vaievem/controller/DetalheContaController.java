package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.models.Cartao;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.services.CartaoService;
import br.edu.fesa.vaievem.services.LancamentoContaService;
import br.edu.fesa.vaievem.services.interfaces.ICartaoService;
import br.edu.fesa.vaievem.services.interfaces.ILancamentoContaService;
import br.edu.fesa.vaievem.utils.FormatString;
import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.TipoCadastro;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.CartaoViewModel;
import br.edu.fesa.vaievem.viewmodels.LancamentoViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class DetalheContaController implements Initializable {

    @FXML
    private TableView<LancamentoViewModel> tbLancamento;

    @FXML
    private TableColumn<LancamentoViewModel, String> colTipo;

    @FXML
    private TableColumn<LancamentoViewModel, String> colData;

    @FXML
    private TableColumn<LancamentoViewModel, String> colValor;

    @FXML
    private TableColumn<LancamentoViewModel, String> colComentario;

    @FXML
    private TableColumn<LancamentoViewModel, LancamentoViewModel> colEditar;

    @FXML
    private TableColumn<LancamentoViewModel, LancamentoViewModel> colExcluir;

    @FXML
    private TableView<CartaoViewModel> tbCartao;

    @FXML
    private TableColumn<CartaoViewModel, String> colDescricao;

    @FXML
    private TableColumn<CartaoViewModel, String> colLimite;

    @FXML
    private TableColumn<CartaoViewModel, CartaoViewModel> colEditarCartao;

    @FXML
    private TableColumn<CartaoViewModel, CartaoViewModel> colExcluirCartao;

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

    private ObservableList<LancamentoViewModel> dadosLancamento;

    private ObservableList<CartaoViewModel> dadosCartao;

    private static ContaBancaria conta;

    ILancamentoContaService _lancamentoContaService;
    ICartaoService _cartaoService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _lancamentoContaService = new LancamentoContaService();
        _cartaoService = new CartaoService();

        preencheTela();
        configurarTabelaLancamento();
        configurarTabelaCartao();
    }

    public static void setConta(ContaBancaria conta) {
        DetalheContaController.conta = conta;
    }

    private void preencheTela() {
        try {

            if (conta != null) {
                txtBanco.setText(conta.getBanco().getDescricao());
                txtAgencia.setText(conta.getNumeroAgencia());
                txtConta.setText(conta.getNumeroConta());
                txtMeta.setText(FormatString.formataDecimal(conta.getMeta()));
                txtDescricao.setText(conta.getDescricao());
                txtSaldo.setText(FormatString.formataDecimal(_lancamentoContaService.retornaSaldoPorConta(conta.getIdContaBancaria())));
            }

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void configurarTabelaLancamento() {
        try {
            colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
            colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
            colValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
            colComentario.setCellValueFactory(new PropertyValueFactory<>("Comentario"));

            dadosLancamento = _lancamentoContaService.listarDadosTabelaPorConta(conta.getIdContaBancaria());
            tbLancamento.setItems(dadosLancamento);

            HelperTable.criaHyperLink(colExcluir, "Excluir", (LancamentoViewModel lancamento, ActionEvent event) -> {
                try {
                    throw new UnsupportedOperationException("Funcionalidade não implementada ainda.");
                } catch (Exception erro) {
                    MessageBox.exibeMensagemErro(erro);
                }
            });

            HelperTable.criaHyperLink(colEditar, "Editar", (LancamentoViewModel lancamento, ActionEvent event) -> {
                try {
                    throw new UnsupportedOperationException("Funcionalidade não implementada ainda.");
                } catch (Exception erro) {
                    MessageBox.exibeMensagemErro(erro);
                }
            });

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void configurarTabelaCartao() {
        try {
            colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
            colLimite.setCellValueFactory(new PropertyValueFactory<>("Limite"));

            dadosCartao = _cartaoService.listarDadosTabelaPorConta(conta.getIdContaBancaria());
            tbCartao.setItems(dadosCartao);

            HelperTable.criaHyperLink(colEditarCartao, "Editar", (CartaoViewModel cartao, ActionEvent event) -> {
                configuraEditarCartao(cartao);
            });

            HelperTable.criaHyperLink(colExcluirCartao, "Excluir", (CartaoViewModel cartao, ActionEvent event) -> {
                configuraExcluirCartao(cartao);
            });

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }

    }

    private void configuraEditarCartao(CartaoViewModel cartao) {
        try {
            CadastroCartaoController.setCartao(montaModelCartao(cartao));
            CadastroCartaoController.setTipoCadastro(TipoCadastro.UPDATE);
            ViewConfiguration.mudaTela(Tela.CADASTRO_CARTAO.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void configuraExcluirCartao(CartaoViewModel cartao) {
        try {
            var resultado = MessageBox.exibeConfirmacao("Confirmar exclusão",
                    String.format("Deseja excluir o cartão %s?", cartao.getDescricao()));

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                _cartaoService.remover(new Cartao(Long.valueOf(cartao.getId())));
                tbCartao.setItems(_cartaoService.listarDadosTabelaPorConta(conta.getIdContaBancaria()));
            }
        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private Cartao montaModelCartao(CartaoViewModel cartao) {
        Cartao c = new Cartao(
                Long.valueOf(cartao.getId()),
                cartao.getDescricao(),
                Integer.parseInt(cartao.getDiaFechamento()),
                Integer.parseInt(cartao.getDiaVencimento()),
                Float.valueOf(cartao.getLimite()));
        c.setContaBancaria(conta);
        return c;
    }

    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CONTAS.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

}
