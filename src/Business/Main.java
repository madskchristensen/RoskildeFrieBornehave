package Business;


import com.mysql.cj.xdevapi.Table;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Set;

public class Main extends Application {
    public static SceneManager sceneManager;

    @Override
    public void start(Stage primaryStage) throws Exception {
        sceneManager = new SceneManager(primaryStage);
        sceneManager.switchScene("login.fxml", "Login");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
