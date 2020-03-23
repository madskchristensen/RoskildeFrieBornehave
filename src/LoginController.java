import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private Button buttonTeacherLogin;
    @FXML
    private Button buttonLoginAdmin;

    public void handleLogin(ActionEvent actionEvent) throws IOException {
        SceneManager sceneManager = new SceneManager(new Stage());
        sceneManager.switchScene("LogInPopUp.fxml", "Log in");
    }

    public void handleLoginAdmin(ActionEvent actionEvent) {
        System.out.println("logging in");
    }

    public void showScene() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    }
}