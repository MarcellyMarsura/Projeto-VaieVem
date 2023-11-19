
package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.models.Banco;
import br.edu.fesa.vaievem.models.ContaBancaria;
import br.edu.fesa.vaievem.services.ContaBancariaService;
import br.edu.fesa.vaievem.services.interfaces.IContaBancariaService;
import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.TipoCadastro;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.ContaViewModel;
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

    IContaBancariaService _contaBancariaService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            _contaBancariaService = new ContaBancariaService();

            configurarTabela();
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }

    }

    private void configurarTabela() {
        try {
            colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
            colAgencia.setCellValueFactory(new PropertyValueFactory<>("Agencia"));
            colConta.setCellValueFactory(new PropertyValueFactory<>("Conta"));
            colBanco.setCellValueFactory(new PropertyValueFactory<>("Banco"));
            colMeta.setCellValueFactory(new PropertyValueFactory<>("Meta"));

            dados = _contaBancariaService.listarDadosTabela("");
            tbConta.setItems(dados);

            HelperTable.criaHyperLink(colDetalhes, "Detalhes", (ContaViewModel conta, ActionEvent event) -> {

                try {

                    ContaBancaria c = new ContaBancaria(
                            Long.valueOf(conta.getId()),
                            conta.getDescricao(),
                            conta.getAgencia(),
                            conta.getConta(),
                            Float.valueOf(conta.getMeta()));

                    c.setBanco(new Banco(0L, conta.getBanco()));

                    DetalheContaController.setConta(c);

                    ViewConfiguration.mudaTela(Tela.DETALHE_CONTA.getNome());
                } catch (Exception erro) {
                    MessageBox.exibeMensagemErro(erro);
                }

            });

            HelperTable.criaHyperLink(colExcluir, "Excluir", (ContaViewModel conta, ActionEvent event) -> {

                try {
                    var resultado = MessageBox.exibeAlerta("Confirmar exclusão", String.format("Deseja excluir a conta %s?", conta.getDescricao()));

                    if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                        _contaBancariaService.remover(new ContaBancaria(Long.valueOf(conta.getId())));
                        tbConta.setItems(_contaBancariaService.listarDadosTabela(""));
                    }
                } catch (LogicalException erro) {
                    MessageBox.exibeAlerta(erro.getMessage());
                } catch (Exception erro) {
                    MessageBox.exibeMensagemErro(erro);
                }

            });

            HelperTable.criaHyperLink(colEditar, "Editar", (ContaViewModel conta, ActionEvent event) -> {
                try {
                    ContaBancaria c = new ContaBancaria(
                            Long.valueOf(conta.getId()),
                            conta.getDescricao(),
                            conta.getAgencia(),
                            conta.getConta(),
                            Float.valueOf(conta.getMeta()));

                    c.setBanco(conta.getBancoModel());

                    CadastroContaController.setConta(c);
                    CadastroContaController.setTipoCadastro(TipoCadastro.UPDATE);

                    ViewConfiguration.mudaTela(Tela.CADASTRO_CONTA.getNome());
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
    private void onMouseClicked_btnAdicionarConta() throws IOException {
        try {
            CadastroContaController.setTipoCadastro(TipoCadastro.INSERT);
            CadastroContaController.setConta(null);
            ViewConfiguration.mudaTela(Tela.CADASTRO_CONTA.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException {
        try {
            String pesquisa = txtPesquisar.getText().trim().isEmpty() ? "" : txtPesquisar.getText().trim();
            tbConta.setItems(_contaBancariaService.listarDadosTabela(pesquisa));
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }
}
