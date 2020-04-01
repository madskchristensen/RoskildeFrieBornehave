package controller;

import utility.PopUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

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
        if(actionEvent.getSource().equals(buttonLoginAdmin)) {

            PopUp popUp = new PopUp<LoginPopUpController>("LoginPopUp.fxml");
            LoginPopUpController loginPopUpController = (LoginPopUpController) popUp.getController();
            loginPopUpController.user = "administrator@localhost";
            popUp.showAndWait("Log Ind");

        } else if (actionEvent.getSource().equals(buttonTeacherLogin)) {

            PopUp popUp = new PopUp<LoginPopUpController>("LoginPopUp.fxml");
            LoginPopUpController loginPopUpController = (LoginPopUpController) popUp.getController();
            loginPopUpController.user = "employee@localhost";
            popUp.showAndWait("Log Ind");
        }
    }

    @FXML
    private void loginSkipAdmin() throws IOException {
        Main.sceneManager.switchScene("AdminMenu.fxml", "Admin Menu");
        Main.sceneManager.setUser("administrator", "admin_pass");
    }

    @FXML
    private void loginSkipTeacher() throws IOException {
        Main.sceneManager.switchScene("TeacherMenu.fxml", "Pædagog Menu");
        Main.sceneManager.setUser("employee", "password");
    }
}