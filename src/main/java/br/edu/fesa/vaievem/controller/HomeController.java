package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.exception.PersistenciaException;
import br.edu.fesa.vaievem.mockService.LancamentoContaService;
import br.edu.fesa.vaievem.mockService.MensagemService;
import br.edu.fesa.vaievem.models.Mensagem;
import br.edu.fesa.vaievem.services.interfaces.ILancamentoContaService;
import br.edu.fesa.vaievem.services.interfaces.IMensagemService;
import br.edu.fesa.vaievem.utils.FormatString;
import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.LancamentoViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class HomeController implements Initializable {

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
    private Text txtTituloMensagem;

    @FXML
    private Text txtMensagem;

    @FXML
    private Text txtSaldoTotal;

    @FXML
    private BarChart<String, Number> grafico;

    private ObservableList<LancamentoViewModel> dados;

    IMensagemService _mensagemService;
    ILancamentoContaService _lancamentoContaService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            _mensagemService = new MensagemService();
            _lancamentoContaService = new LancamentoContaService();

            configurarTela();
            configurarTabela();
            configurarGrafico();

        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }

    }

    private void configurarTela() {
        try {
            Mensagem mensagem = _mensagemService.retornaMensagemMeta();
            txtTituloMensagem.setText(mensagem.getTitulo());
            txtMensagem.setText(mensagem.getCorpo());

            txtSaldoTotal.setText(FormatString.formataDecimal(_lancamentoContaService.retornaSaldoTotal()));

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void configurarGrafico() {
        try {

            XYChart.Series<String, Number> receita = new XYChart.Series<>();
            receita.setName("Receita");
            receita.getData().add(new XYChart.Data<>("", _lancamentoContaService.somaTotalReceitas()));

            XYChart.Series<String, Number> despesa = new XYChart.Series<>();
            despesa.setName("Despesa");
            despesa.getData().add(new XYChart.Data<>("", _lancamentoContaService.somaTotalDespesas()));

            grafico.getData().addAll(receita, despesa);

        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }

    }

    private void configurarTabela() {
        try {
            dados = _lancamentoContaService.listarDadosTabela("");
            colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
            colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
            colValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
            colComentario.setCellValueFactory(new PropertyValueFactory<>("Comentario"));

            tbLancamento.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            tbLancamento.setItems(dados);

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

        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }

    }

    @FXML
    private void onMouseClicked_btnLancamentoConta() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_LANCAMENTO_CONTA.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnLancamentoCartao() throws IOException {
        try {
            throw new UnsupportedOperationException("Funcionalidade não implementada ainda.");
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

}
