package Controller;

import Business.Main;
import Business.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class VenteListeController {
    public TableColumn firstName;
    public TableColumn lastName;
    public TableColumn age;
    public TableColumn dateOfBirth;
    public TableColumn address;
    public TableColumn dateOfRegistration;
    public Button back;
    public Button guardian;
    public Button create;
    public Button update;
    public Button delete;

    public void readGuardian(ActionEvent actionEvent) {
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void addToWaitList(ActionEvent actionEvent) {
    }

    public void updateWaitList(ActionEvent actionEvent) {
    }

    public void deleteFromWaitList(ActionEvent actionEvent) {
    }
}
