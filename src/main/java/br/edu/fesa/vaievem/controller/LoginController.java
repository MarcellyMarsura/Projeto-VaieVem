package br.edu.fesa.vaievem.controller;

import br.edu.fesa.vaievem.exception.LogicalException;
import br.edu.fesa.vaievem.models.Usuario;
import br.edu.fesa.vaievem.services.UsuarioService;
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


public class LoginController implements Initializable {

    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtSenha;
    
    IUsuarioService _usuarioService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _usuarioService = new UsuarioService();
        configurarTela();
    }
    
    private void configurarTela() {
        try {
            ViewConfiguration.setPossuiMenu(false);
        } catch (Exception erro) {
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
    @FXML
    private void onMouseClicked_lnkCadastrar() throws IOException{
        try {
            ViewConfiguration.mudaTela(Tela.CADASTRO_USUARIO.getNome());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
        
    }
    
    @FXML
    private void onMouseClicked_btnEntrar() throws IOException{
        try {
            String email = txtEmail.getText().trim();
            String senha = txtSenha.getText().trim();
            
            if(email.isEmpty() || senha.isEmpty()) {
                throw new LogicalException("Preencha todos os campos.");
            }
            else {
                if(!_usuarioService.autenticaUsuario(new Usuario(email, senha))){
                    txtSenha.clear();
                    throw new LogicalException("Usuário/senha incorretos.");
                }
                ViewConfiguration.mudaTela(Tela.HOME.getNome());
            }
            
        }
        catch (LogicalException erro) {
            MessageBox.exibeAlerta("Erro ao autenticar usuário", erro.getMessage());
        }
        catch (Exception erro){
            MessageBox.exibeMensagemErro(erro);
        }
    }
    
}
