package buisnessLogic;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static SceneManager sceneManager;

    @Override
    public void start(Stage primaryStage) throws Exception {
        sceneManager = new SceneManager(primaryStage);
        sceneManager.switchScene("Login.fxml", "Login");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
