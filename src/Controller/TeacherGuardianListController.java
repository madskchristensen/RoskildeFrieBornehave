package Controller;

import Business.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class TeacherGuardianListController {
    public Button backButton;
    public Button childButton;

    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();

    }

    public void handleChild(ActionEvent actionEvent) {
    }
}
