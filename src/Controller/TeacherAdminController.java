package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class TeacherAdminController {

    public Button buttonShiftsAdmin;
    public Button buttonTeacherAdmin;
    public Button buttonChildAdmin;
    public Button buttonParentAdmin;
    public Button buttonWaitingAdmin;
    public Button buttonTeacherLogOutAdmin;

    public void handleShiftPlan(ActionEvent actionEvent) {
    }

    public void handleTeachers(ActionEvent actionEvent) {
    }

    public void handleChildren(ActionEvent actionEvent) {
    }

    public void handleGuardians(ActionEvent actionEvent) {
    }

    public void handleWaitingList(ActionEvent actionEvent) {
    }

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("Login.fxml", "Login");
    }
}
