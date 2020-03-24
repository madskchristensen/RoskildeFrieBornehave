package Controller;

import Business.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.io.IOException;

public class AdminTeacherListController {

    public TableColumn firstName;
    public TableColumn lastName;
    public TableColumn classRoom;
    public TableColumn dateOfBirth;
    public TableColumn address;
    public TableColumn tlfNo;
    public TableColumn email;
    public Button back;
    public Button guardian;
    public Button update;
    public Button delete;

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void readTeacherShift(ActionEvent actionEvent) {
    }

    public void updateTeacherList(ActionEvent actionEvent) {
    }

    public void deleteFromTeacherList(ActionEvent actionEvent) {
    }
}
