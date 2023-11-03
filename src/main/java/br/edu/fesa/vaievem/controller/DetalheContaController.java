package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.apagar.ContaModel;
import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.CartaoViewModel;
import br.edu.fesa.vaievem.viewmodels.LancamentoViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    private static ContaModel conta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO: Preencher campos text
        preencheTela();
        configurarTabelaLancamento();
        configurarTabelaCartao();
    }

    private void preencheTela() {
        if (conta != null) {
            txtBanco.setText(conta.getBanco());
            txtAgencia.setText(conta.getAgencia());
            txtConta.setText(conta.getConta());
            txtMeta.setText(conta.getMeta().toString());
            txtDescricao.setText(conta.getDescricao());
            txtSaldo.setText("1000,00");
        }
    }

    public static void setConta(ContaModel conta) {
        DetalheContaController.conta = conta;
    }

    private void configurarTabelaLancamento() {
        dadosLancamento = FXCollections.observableArrayList(new LancamentoViewModel("1", "Despesa", "05/11/2002", "1000,00", "Primeira compra"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        colComentario.setCellValueFactory(new PropertyValueFactory<>("Comentario"));

        tbLancamento.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbLancamento.setItems(dadosLancamento);

        HelperTable.criaHyperLink(colExcluir, "Excluir", (LancamentoViewModel lancamento, ActionEvent event) -> {
            //TODO
        });

        HelperTable.criaHyperLink(colEditar, "Editar", (LancamentoViewModel lancamento, ActionEvent event) -> {
            //TODO
        });
    }

    private void configurarTabelaCartao() {
        dadosCartao = FXCollections.observableArrayList(new CartaoViewModel("1", "Despesa", "05/11/2002", "1000,00", "Primeira compra", ""));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        colLimite.setCellValueFactory(new PropertyValueFactory<>("Limite"));

        tbCartao.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbCartao.setItems(dadosCartao);

        HelperTable.criaHyperLink(colExcluirCartao, "Excluir", (CartaoViewModel cartao, ActionEvent event) -> {
            //TODO
        });

        HelperTable.criaHyperLink(colEditarCartao, "Editar", (CartaoViewModel cartao, ActionEvent event) -> {
            //TODO
        });
    }

    @FXML
    private void onMouseClicked_btnVoltar() throws IOException {
        try {
            //TODO: MessageBox para cancelar cadastro
            ViewConfiguration.mudaTela(Tela.CONTAS.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

}
