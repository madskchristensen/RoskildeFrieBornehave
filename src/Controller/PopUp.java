package Controller;

import Business.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUp extends Stage{
    Stage stage;
    public GridPane grid;
    FXMLLoader fxmlLoader;

    PopUp(String title, String fxmlFil){
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + fxmlFil));
            setTitle(title);
            setScene(new Scene(fxmlLoader.load(), 300, 200));
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
