package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

import Business.*;

public class LoginController {
    @FXML
    private Button buttonTeacherLogin;
    @FXML
    private Button buttonLoginAdmin;

    public void handleLogin(ActionEvent actionEvent) throws IOException {
        SceneManager sceneManager = new SceneManager(new Stage());
        sceneManager.setSize(250,200);
        sceneManager.switchScene("LogInPopUp.fxml", "Log in");
    }

    public void handleLoginAdmin(ActionEvent actionEvent) {
        System.out.println("logging in");
    }

}