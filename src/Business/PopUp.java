package Business;

import Business.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUp extends Stage{
    private Stage stage;
    private Parent node;
    private FXMLLoader fxmlLoader;

    public PopUp(String title, String fxmlFile){
        this(title,fxmlFile,
                (int) Screen.getPrimary().getVisualBounds().getWidth() / 4,
                (int) Screen.getPrimary().getVisualBounds().getHeight() / 4);
    }
    public PopUp(String title, String fxmlFile,  int sizeX, int sizeY){
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + fxmlFile));
            node = fxmlLoader.load();
            setTitle(title);
            setScene(new Scene(node, sizeX, sizeY));
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public Parent getRoot(){
        return node;
    }
}
