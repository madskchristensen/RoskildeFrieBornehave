
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPopUpController {//extends AbstractController implements Initializable {

/*
  Forestiller mig at den kan bruges i takt med noget lignede:
  PopupControl popup = new PopupControl();
  popup.getScene().setRoot(yourGridPane);
  popup.show(yourGridPane.getScene().getWindow());
  https://stackoverflow.com/questions/36520331/how-does-one-create-a-pop-up-box-using-javafx
    https://stackoverflow.com/questions/39004086/fxml-set-buttontype-onaction
*/

    public static final ButtonType LOGIN = new ButtonType("Login");

    @FXML DialogPane loginPane;

    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private Button buttonLogin;


    @FXML
    private void loginPress() throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) buttonLogin.getScene().getWindow();

        // do what you have to do
        stage.close();

        Main.sceneManager.switchScene("TeacherAdmin.fxml", "Teacher admin page");
    }
}
