package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class TeacherMenuController {
    public Button buttonShifts;
    public Button buttonChild;
    public Button buttonParent;
    public Button buttonTeacherLogOut;

    public void handleShiftPlan(ActionEvent actionEvent) {
        //nothing yet
    }

    public void handleChildren(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("TeacherChildList.fxml", "Børn");
    }

    public void handleGuardians(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("TeacherGuardianList.fxml", "Værger");
    }

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("Login.fxml", "Login");
    }
}
