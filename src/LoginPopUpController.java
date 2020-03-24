
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginPopUpController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Disabler gem button indtil alle fields er udfyldt
        BooleanBinding booleanBind = loginUsername.textProperty().isEmpty().
                or(loginPassword.textProperty().isEmpty());
        buttonLogin.disableProperty().bind(booleanBind);
    }

    @FXML
    private void loginPress() throws IOException {
        // get a handle to the stage the button is built on
        Stage stage = (Stage) buttonLogin.getScene().getWindow();
        stage.close();

        Main.sceneManager.switchScene("TeacherAdmin.fxml", "Teacher admin page");
    }
}
