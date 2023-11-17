package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.interfaces.IUsuarioService;
import br.edu.fesa.vaievem.utils.MessageBox;
import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class CadastroUsuarioController implements Initializable {

    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtSenha;
    
    IUsuarioService _usuarioService;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //_usuarioService = new UsuarioService();
        ViewConfiguration.setPossuiMenu(false);
    }
    
    @FXML
    private void onMouseClicked_lnkEntrar() throws IOException{
        try {
            ViewConfiguration.mudaTela(Tela.LOGIN.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
    @FXML
    private void onMouseClicked_btnCadastrar() throws IOException{
        try {
            String nome = txtNome.getText().trim();
            String email = txtEmail.getText().trim();
            String senha = txtSenha.getText().trim();
            
            if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                throw new LogicalException("Preencha todos os campos");
            }
            _usuarioService.inserir(new Usuario(email, senha, nome));
            ViewConfiguration.mudaTela(Tela.PERFIL.getNome());
        }
        catch (LogicalException erro) {
            MessageBox.exibeAlerta("Erro ao cadastrar usuário", erro.getMessage());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
        
    }    
    
}
