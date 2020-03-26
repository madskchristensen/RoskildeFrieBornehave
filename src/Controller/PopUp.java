package Controller;

import Business.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUp{

    public GridPane grid;
    FXMLLoader fxmlLoader;

    PopUp(String title){
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/PopUP.fxml"));
            grid = fxmlLoader.load();
            fxmlLoader.setController(this);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(grid, 300, 200));
            stage.show();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
