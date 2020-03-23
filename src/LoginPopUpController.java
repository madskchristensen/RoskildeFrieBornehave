
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;

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
    LoginController loginController = new LoginController();

    @FXML DialogPane loginPane;

    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private Button buttonLogin;

    public void showScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPopUp.fxml"));
        Main.window.setTitle("LoginPopUp page");
        Main.window.showAndWait();
    }

    public void loginPress() throws IOException {
        loginController.showScene();
    }
}
