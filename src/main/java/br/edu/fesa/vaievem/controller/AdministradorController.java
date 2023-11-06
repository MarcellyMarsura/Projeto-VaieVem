
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
        ViewConfiguration.setPossuiMenu(false);
        configuraTabela();
    }
    
    private void configuraTabela() {
        tcId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tbUsuario.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbUsuario.setItems(dados);
        
        
        HelperTable.criaHyperLink(tcExcluir, "Excluir", (UsuarioViewModel usuario, ActionEvent event) -> {
            //TODO
        });
    }
    
    @FXML
    private void onMouseClicked_btnSair() throws IOException{
        try {
            ViewConfiguration.mudaTela(Tela.LOGIN.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
        
    }
    
    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException{
        //TODO
    }

}
