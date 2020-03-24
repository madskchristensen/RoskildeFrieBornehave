package controllers;

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
import buisnessLogic.*;

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