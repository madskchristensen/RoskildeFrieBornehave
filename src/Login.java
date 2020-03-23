import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Login{

    public Button buttonTeacherLogin;
    public Button buttonLoginAdmin;


    public void handleLoginTeacher(ActionEvent actionEvent) {
        System.out.println("logging in");
    }

    public void handleLoginAdmin(ActionEvent actionEvent) {
        System.out.println("logging in");
    }
}