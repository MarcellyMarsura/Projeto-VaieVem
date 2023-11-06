
package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.CartaoViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO: Obter dados pelo service
        configurarTabela();
    } 
    
    private void configurarTabela() {
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        colLimite.setCellValueFactory(new PropertyValueFactory<>("Limite"));
        colConta.setCellValueFactory(new PropertyValueFactory<>("Conta"));
   
        tbCartao.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbCartao.setItems(dados);


        HelperTable.criaHyperLink(colExcluir, "Excluir", (CartaoViewModel cartao, ActionEvent event) -> {
            //TODO
        });

        HelperTable.criaHyperLink(colEditar, "Editar", (CartaoViewModel cartao, ActionEvent event) -> {
            //TODO
        });
    }
    
    @FXML
    private void onMouseClicked_btnAdicionarCartao() throws IOException {
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_CARTAO.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException {
        try {
            //TODO: Atualizar tabela com os dados retornados do service
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
}
