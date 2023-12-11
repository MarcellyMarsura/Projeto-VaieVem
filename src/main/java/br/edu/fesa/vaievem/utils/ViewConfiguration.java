/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.utils;

import br.edu.fesa.vaievem.App;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author m.molinari.marsura
 */
public class ViewConfiguration {
    
    private static Scene tela;
    private static Parent root;
    private static boolean possuiMenu = true;
   
    public static void setPossuiMenu(boolean possuiMenu) {
        ViewConfiguration.possuiMenu = possuiMenu;
    }
    
    public static void carregaTela(String fxml, Stage stage) throws IOException {
        configuraTela(fxml);
        configuraJanela(stage);
        
        tela = new Scene(root, 1200, 700);
        stage.setScene(tela);
        stage.show();
    }
    
    public static void mudaTela(String fxml) throws IOException {  
        configuraTela(fxml);
        tela.setRoot(root);
    }

    
    private static Parent carregaFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    private static void configuraTela(String fxml) throws IOException{
        root = carregaFXML(fxml);
        
        
        if(possuiMenu){
            adicionaComponente(Tela.MENU.getNome());
        }
        
        possuiMenu = true;
    }
    
    private static void adicionaComponente(String fxml)throws IOException {
        Parent componente = carregaFXML(fxml);
        ((Pane)root).getChildren().add((Pane)componente);
    }
    
    private static void configuraJanela(Stage stage) {

        stage.setResizable(false);
        Image icon = new Image("file:src\\main\\resources\\br\\edu\\fesa\\vaievem\\icon\\icon-logo.png", 32, 32, true, true);
        stage.getIcons().add(icon);
        stage.setTitle("Vai e Vem");
        
    }
}
