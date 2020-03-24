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
    @FXML
    private Button buttonSkipLoginAdmin;
    @FXML
    private Button buttonSkipLoginTeacher;

    public void handleLogin(ActionEvent actionEvent) throws IOException {
        SceneManager sceneManager = new SceneManager(new Stage());
        sceneManager.setSize(250,200);
        sceneManager.switchScene("LogInPopUp.fxml", "Log in");
    }

    @FXML
    private void loginSkipAdmin() throws IOException {
        Main.sceneManager.switchScene("AdminMenu.fxml", "Teacher page");
    }

    @FXML
    private void loginSkipTeacher() throws IOException {
        Main.sceneManager.switchScene("TeacherMenu.fxml", "Teacher admin page");
    }
}