package Controller;

import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Business.*;
import Utility.*;

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
    @FXML
    private Button buttonExit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Disabler gem button indtil alle fields er udfyldt
        BooleanBinding booleanBind = loginUsername.textProperty().isEmpty().
                or(loginPassword.textProperty().isEmpty());
        buttonLogin.disableProperty().bind(booleanBind);
    }

    /***
     * Noget vi kan implementere senere:
     * Individuelt login til hver bruger => nedenstående metode skal laves lidt om => knap mere på admin menu
     * @throws IOException
     * @throws SQLException
     */

    @FXML
    private void exitPress() throws IOException {

        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();

    }


    @FXML
    private void loginPress() throws IOException, SQLException {
        // get a handle to the stage the button is built on
        Stage stage = (Stage) buttonLogin.getScene().getWindow();

        DialogBox errorDialog = new DialogBox("Fejl", "Forkert brugernavn eller kodeord.", "OK");

        // Validerer login ved at forsøge at åbne en jdbc connection med det givne username og password
        // hvis user/pass er forkert vil jdbc.openconnection throwe en sqlexception som håndteres som en fejl i bruger/pass
        // hvis forbindelsen åbnes er user/pass rigtigt og brugeren sendes videre til enten admin eller employee page
        try {
            JDBC jdbc = new JDBC(loginUsername.getText(), loginPassword.getText());
            jdbc.openConnection();
            Main.sceneManager.setUser(loginUsername.getText(), loginPassword.getText());
        } catch (SQLException e) {
            errorDialog.showAndWait();
            loginUsername.clear();
            loginPassword.clear();

        } finally {
            switch(loginUsername.getText()) {
                case "administrator":
                    Main.sceneManager.switchScene("AdminMenu.fxml", "Teacher admin page");
                    stage.close();
                    break;
                case "employee":
                    Main.sceneManager.switchScene("TeacherMenu.fxml", "Teacher page");
                    stage.close();
                    break;
            }
        }
    }
}
