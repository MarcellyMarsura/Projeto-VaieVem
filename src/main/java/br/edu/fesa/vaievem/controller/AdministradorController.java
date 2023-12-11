package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.utils.HelperTable;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import br.edu.fesa.vaievem.viewmodels.UsuarioViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdministradorController implements Initializable {

    @FXML
    private TableView<UsuarioViewModel> tbUsuario;

    @FXML
    private TableColumn<UsuarioViewModel, String> tcId;

    @FXML
    private TableColumn<UsuarioViewModel, String> tcNome;

    @FXML
    private TableColumn<UsuarioViewModel, String> tcEmail;

    @FXML
    private TableColumn<UsuarioViewModel, UsuarioViewModel> tcExcluir;

    @FXML
    private Label nomeAdministrador;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnPesquisar;

    @FXML
    private TextField txtPesquisar;

    private ObservableList<UsuarioViewModel> dados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    @FXML
    private void onMouseClicked_btnSair() throws IOException {
        //TODO
    }

    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException {
        //TODO
    }

}
