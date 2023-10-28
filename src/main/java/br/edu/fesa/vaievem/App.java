package br.edu.fesa.vaievem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Parent root;
    static boolean possuiMenu = true;

    @Override
    public void start(Stage stage) throws IOException {
        carregaRoot("DetalheConta");
        configuraStage(stage);
        
        stage.show();
        
    }

    static void adicionaComponente(String fxml)throws IOException {
        Parent componente = loadFXML(fxml);
        ((Pane)root).getChildren().add((Pane)componente);
    }
    
    static void carregaRoot(String fxml) throws IOException{
        root = loadFXML(fxml);
        
        if(possuiMenu){
            adicionaComponente("Menu");
        }
        
        possuiMenu = true;
    }
    
    private static void configuraStage(Stage stage){
        scene = new Scene(root, 1200, 700);
        stage.setResizable(false);
        Image icon = new Image("file:src\\main\\resources\\br\\edu\\fesa\\vaievem\\icon\\icon-logo.png", 32, 32, true, true);
        stage.getIcons().add(icon);
        stage.setTitle("Vai e Vem");
        stage.setScene(scene);
    }
    
    static void setRoot(String fxml) throws IOException {  
        carregaRoot(fxml);
        scene.setRoot(root);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}