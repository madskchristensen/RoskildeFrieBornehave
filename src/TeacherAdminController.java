import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class TeacherAdminController {

    public Button buttonShiftsAdmin;
    public Button buttonTeacherAdmin;
    public Button buttonChildAdmin;
    public Button buttonParentAdmin;
    public Button buttonWaitingAdmin;
    public Button buttonTeacherLogOutAdmin;

    public void showScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TeacherAdmin.fxml"));
        Main.window.setTitle("Teacher admin page");
        Main.window.show();
    }
}
