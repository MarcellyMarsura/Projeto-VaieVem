package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.apagar.ContaModel;
import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.ContaViewModel;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContasController implements Initializable {

    @FXML
    private TableView<ContaViewModel> tbConta;

    @FXML
    private TableColumn<ContaViewModel, String> colDescricao;

    @FXML
    private TableColumn<ContaViewModel, String> colAgencia;

    @FXML
    private TableColumn<ContaViewModel, String> colConta;

    @FXML
    private TableColumn<ContaViewModel, String> colBanco;

    @FXML
    private TableColumn<ContaViewModel, String> colMeta;

    @FXML
    private TableColumn<ContaViewModel, ContaViewModel> colDetalhes;

    @FXML
    private TableColumn<ContaViewModel, ContaViewModel> colEditar;

    @FXML
    private TableColumn<ContaViewModel, ContaViewModel> colExcluir;

    @FXML
    private TextField txtPesquisar;

    private ObservableList<ContaViewModel> dados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO: Obter dados pelo service
        configurarTabela();
    }

    private void configurarTabela() {
        dados = FXCollections.observableArrayList(new ContaViewModel("1", "Despesa", "05/11/2002", "1000,00", "Primeira compra", ""));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        colAgencia.setCellValueFactory(new PropertyValueFactory<>("Agencia"));
        colConta.setCellValueFactory(new PropertyValueFactory<>("Conta"));
        colBanco.setCellValueFactory(new PropertyValueFactory<>("Banco"));
        colMeta.setCellValueFactory(new PropertyValueFactory<>("Meta"));

        tbConta.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbConta.setItems(dados);

        HelperTable.criaHyperLink(colDetalhes, "Detalhes", (ContaViewModel conta, ActionEvent event) -> {
            try {
                DetalheContaController.setConta(new ContaModel(1, conta.getAgencia(), conta.getBanco(), conta.getDescricao(), conta.getConta(), 110.20));
                ViewConfiguration.mudaTela(Tela.DETALHE_CONTA.getNome());
            } catch (Exception erro) {
                MessageBox.exibeMensagemErro(erro);
            }
        });

        HelperTable.criaHyperLink(colExcluir, "Excluir", (ContaViewModel conta, ActionEvent event) -> {
            //TODO
        });

        HelperTable.criaHyperLink(colEditar, "Editar", (ContaViewModel conta, ActionEvent event) -> {
            //TODO
        });
    }

    @FXML
    private void onMouseClicked_btnAdicionarConta() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_CONTA.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException {
        try {
            //TODO: Atualizar tabela com os dados retornados do service
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }
}
