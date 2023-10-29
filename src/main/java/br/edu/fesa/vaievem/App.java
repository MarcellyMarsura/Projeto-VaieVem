package br.edu.fesa.vaievem;

import br.edu.fesa.vaievem.utils.Tela;
import br.edu.fesa.vaievem.utils.ViewConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Parent root;
    static boolean possuiMenu = true;

    @Override
    public void start(Stage stage) throws IOException {
        ViewConfiguration.carregaTela(Tela.LOGIN.getNome(), stage);
    }
    
    public static void main(String[] args) {
        launch();
    }
    

}