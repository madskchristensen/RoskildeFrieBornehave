package Controller;

import Business.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class TeacherChildListController {

    public Button backButton;
    public Button guardianButton;

    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }


    public void handleGuardian(ActionEvent actionEvent) {
    }
}
