package Controller;

import Business.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminGuardianListController {

    public Button backButton;
    public Button createGuardianButton;
    public Button editButton;
    public Button deleteButton;
    public Button childButton;

    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void handleCreateGuardian(ActionEvent actionEvent) {
    }

    public void handleEdit(ActionEvent actionEvent) {
    }

    public void handleDelete(ActionEvent actionEvent) {
    }

    public void handleChild(ActionEvent actionEvent) {
    }
}
