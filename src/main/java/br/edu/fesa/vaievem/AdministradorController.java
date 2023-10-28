/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.edu.fesa.vaievem;


import br.edu.fesa.vaievem.viewmodels.UsuarioViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableColumn<UsuarioViewModel, String> tcExcluir;
    
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
        var helper = new HelperController<UsuarioViewModel>();
        
        var mockNome = "Marcelly Molinari Marsura";
        
        nomeAdministrador.setText(mockNome);

        tcId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tcExcluir.setCellFactory(col -> helper.HyperlinkExcluir(tbUsuario));
       
        dados = FXCollections.observableArrayList(
            new UsuarioViewModel("1", "teste1", "teste1@gmail.com"),
            new UsuarioViewModel("2", "teste2", "teste2@gmail.com"),
            new UsuarioViewModel("3", "teste3", "teste3@gmail.com")
        );
        
        tbUsuario.setItems(dados);
    }    
    
    @FXML
    private void onMouseClicked_btnSair() throws IOException{
        try {
            App.setRoot("Login");
        }
        catch (Exception erro){
            //TODO
        }
        
    }
    
    @FXML
    private void onMouseClicked_btnPesquisar() throws IOException{
        //TODO
    }


    
    
}
