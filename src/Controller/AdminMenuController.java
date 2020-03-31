package Controller;

import Business.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminMenuController {

    public Button buttonShiftsAdmin;
    public Button buttonTeacherAdmin;
    public Button buttonChildAdmin;
    public Button buttonParentAdmin;
    public Button buttonWaitingAdmin;
    public Button buttonTeacherLogOutAdmin;

    public void handleShiftPlan(ActionEvent actionEvent) throws IOException {
        //nothing yet
    }

    public void handleTeachers(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("AdminTeacherList.fxml", "Pædagoger");
    }

    public void handleChildren(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("AdminChildList.fxml", "Børneliste");
    }

    public void handleGuardians(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("AdminGuardianList.fxml", "Værger");
    }

    public void handleWaitingList(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("AdminWaitingList.fxml", "Venteliste");

    }

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("Login.fxml", "Login");
    }
}
