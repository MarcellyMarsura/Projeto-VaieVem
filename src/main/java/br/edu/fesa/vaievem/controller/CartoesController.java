package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.mockService.CartaoService;
import br.edu.fesa.vaievem.models.Cartao;
import br.edu.fesa.vaievem.services.interfaces.ICartaoService;
import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.TipoCadastro;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.CartaoViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartoesController implements Initializable {

    @FXML
    private TableView<CartaoViewModel> tbCartao;

    @FXML
    private TableColumn<CartaoViewModel, String> colConta;

    @FXML
    private TableColumn<CartaoViewModel, String> colDescricao;

    @FXML
    private TableColumn<CartaoViewModel, String> colLimite;

    @FXML
    private TableColumn<CartaoViewModel, CartaoViewModel> colEditar;

    @FXML
    private TableColumn<CartaoViewModel, CartaoViewModel> colExcluir;

    @FXML
    private ComboBox<String> cbConta;

    @FXML
    private TextField txtPesquisar;

    private ObservableList<CartaoViewModel> dados;

    ICartaoService _cartaoService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            _cartaoService = new CartaoService();
            configurarTabela();
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }

    }

    private void configurarTabela() {
        try {
            colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
            colLimite.setCellValueFactory(new PropertyValueFactory<>("Limite"));
            colConta.setCellValueFactory(new PropertyValueFactory<>("Conta"));

            dados = _cartaoService.listarDadosTabela("");
            tbCartao.setItems(dados);

            HelperTable.criaHyperLink(colExcluir, "Excluir", (CartaoViewModel cartao, ActionEvent event) -> {
                try {
                    var resultado = MessageBox.exibeAlerta("Confirmar exclusão", String.format("Deseja excluir o cartão %s?", cartao.getDescricao()));

                    if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                        _cartaoService.remover(new Cartao(Long.valueOf(cartao.getId())));
                        tbCartao.setItems(_cartaoService.listarDadosTabela(""));
                    }
                } catch (LogicalException erro) {
                    MessageBox.exibeAlerta(erro.getMessage());
                } catch (Exception erro) {
                    MessageBox.exibeMensagemErro(erro);
                }
            });

            HelperTable.criaHyperLink(colEditar, "Editar", (CartaoViewModel cartao, ActionEvent event) -> {
                try {
                    Cartao c = new Cartao(
                            Long.valueOf(cartao.getId()),
                            cartao.getDescricao(),
                            Integer.parseInt(cartao.getDiaFechamento()),
                            Integer.parseInt(cartao.getDiaVencimento()),
                            Float.valueOf(cartao.getLimite()));

                    CadastroCartaoController.setCartao(c);
                    CadastroCartaoController.setTipoCadastro(TipoCadastro.UPDATE);

                    ViewConfiguration.mudaTela(Tela.CADASTRO_CARTAO.getNome());
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
    private void onMouseClicked_btnAdicionarCartao() throws IOException {
        try {
            CadastroCartaoController.setTipoCadastro(TipoCadastro.INSERT);
            CadastroCartaoController.setCartao(null);
            ViewConfiguration.mudaTela(Tela.CADASTRO_CARTAO.getNome());
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }

    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException {
        try {
            tbCartao.setItems(_cartaoService.listarDadosTabela(txtPesquisar.getText().trim()));
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }
}
