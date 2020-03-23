import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class TeacherRegController {
    public Button buttonShifts;
    public Button buttonChild;
    public Button buttonParent;
    public Button buttonTeacherLogOut;

    public void showScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TeacherReg.fxml"));
        Main.window.setTitle("Teacher Reg page");
        Main.window.show();
    }
}
