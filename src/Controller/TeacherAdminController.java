package Controller;

import Business.Main;
import Business.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherAdminController {

    public Button buttonShiftsAdmin;
    public Button buttonTeacherAdmin;
    public Button buttonChildAdmin;
    public Button buttonParentAdmin;
    public Button buttonWaitingAdmin;
    public Button buttonTeacherLogOutAdmin;

    public void handleShiftPlan(ActionEvent actionEvent) throws IOException {

    }

    public void handleTeachers(ActionEvent actionEvent) {

    }

    public void handleChildren(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("AdminChildList.fxml", "Børneliste");
    }

    public void handleGuardians(ActionEvent actionEvent) throws IOException {
    }

    public void handleWaitingList(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("VenteListe.fxml", "Venteliste");

    }

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("Login.fxml", "Login");
    }
}
