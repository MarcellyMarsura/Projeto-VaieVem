package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.models.Mensagem;
import br.edu.fesa.vaievem.services.ContaBancariaService;
import br.edu.fesa.vaievem.services.LancamentoContaService;
import br.edu.fesa.vaievem.services.MensagemService;
import br.edu.fesa.vaievem.services.interfaces.IContaBancariaService;
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
    IContaBancariaService _contaBancariaService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            _mensagemService = new MensagemService();
            _lancamentoContaService = new LancamentoContaService();
            _contaBancariaService = new ContaBancariaService();

            configurarTela();
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
            configurarGrafico();
            configurarTabela();
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

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    private void configurarTabela() {
        try {
            colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
            colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
            colValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
            colComentario.setCellValueFactory(new PropertyValueFactory<>("Comentario"));

            dados = _lancamentoContaService.listarDadosTabela("");
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

        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }

    }

    @FXML
    private void onMouseClicked_btnLancamentoConta() throws IOException {
        try {
            if (_contaBancariaService.listarPorUsuario().isEmpty()) {
                throw new LogicalException("Cadastre uma conta primeiro.");
            }

            ViewConfiguration.mudaTela(Tela.CADASTRO_LANCAMENTO_CONTA.getNome());
        } catch (LogicalException erro) {
            MessageBox.exibeAlerta(erro.getMessage());
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
