package br.edu.fesa.vaievem;

import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ViewConfiguration.carregaTela(Tela.LOGIN.getNome(), stage);
    }
    
    public static void main(String[] args) {
        launch();
    }
    

}