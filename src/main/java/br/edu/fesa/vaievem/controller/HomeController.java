package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.LancamentoViewModel;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTituloMensagem.setText("Parabéns!"); //TODO: Obter título da model Mensagem (regra no service)
        txtMensagem.setText("Tudo certo com as suas finanças."); //TODO: Obter conteúdo da model Mensagem (regra no service)
        txtSaldoTotal.setText("100,00"); //TODO: Obter saldo total pelo service
        
        configurarTabela();
        configurarGrafico();

    }
    
    private void configurarGrafico(){
        String mesEAnoFormatado = (new SimpleDateFormat("MMM/yyyy")).format(Calendar.getInstance().getTime());
        
        XYChart.Series<String, Number> receita = new XYChart.Series<>();
        receita.setName("Receita");
        receita.getData().add(new XYChart.Data<>(mesEAnoFormatado, 1000)); // Substitua 1000 pelo valor da receita

        XYChart.Series<String, Number> despesa = new XYChart.Series<>();
        despesa.setName("Despesa");
        despesa.getData().add(new XYChart.Data<>(mesEAnoFormatado, 800)); // Substitua 800 pelo valor da despesa
        
        grafico.getData().addAll(receita, despesa); 
    }
    
    private void configurarTabela(){
        dados = FXCollections.observableArrayList(new LancamentoViewModel("1", "Despesa","05/11/2002", "1000,00", "Primeira compra"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        colComentario.setCellValueFactory(new PropertyValueFactory<>("Comentario"));
        
        tbLancamento.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbLancamento.setItems(dados);
        
        
        HelperTable.criaHyperLink(colExcluir, "Excluir", (LancamentoViewModel lancamento, ActionEvent event) -> {
            try {
                //TODO
                throw new Exception();
            } catch (Exception ex) {
                MessageBox.exibeMensagemErro(ex);
            }
        });
        
        HelperTable.criaHyperLink(colEditar, "Editar", (LancamentoViewModel lancamento, ActionEvent event) -> {
            //TODO

        });
    }
    
    @FXML
    private void onMouseClicked_btnLancamentoConta() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_LANCAMENTO_CONTA.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
    @FXML
    private void onMouseClicked_btnLancamentoCartao() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_LANCAMENTO_CARTAO.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
}
