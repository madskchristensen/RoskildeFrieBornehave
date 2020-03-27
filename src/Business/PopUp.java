package Business;

import Business.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class PopUp<E>{
    private FXMLLoader loader;
    private Parent node;
    private Stage stage;

    public PopUp(){
        this("PopUp.fxml");
    }
    public PopUp(String fxmlFile){
        try{
            loader = new FXMLLoader(getClass().getResource("/fxml/" + fxmlFile));
            node = loader.load();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public E getController(){
        return loader.getController();
    }

    public void show(String title){
            stage = new Stage();
            stage.setScene(new Scene(node));
            stage.setTitle(title);
            stage.show();
    }

    public void showAndWait(String title){
            stage = new Stage();
            stage.setScene(new Scene(node));
            stage.setTitle(title);
            stage.showAndWait();
    }

    public Stage getStage() {
        return stage;
    }
}
