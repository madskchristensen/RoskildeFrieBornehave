package Business;

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

    public PopUp(String title, String fxmlFil){
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + fxmlFil));
            setTitle(title);
            setScene(new Scene(fxmlLoader.load()));
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
