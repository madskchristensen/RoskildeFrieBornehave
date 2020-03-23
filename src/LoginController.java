import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private Button buttonTeacherLogin;
    @FXML
    private Button buttonLoginAdmin;

    public LoginController() throws SQLException {
    }

    //Atm kan der ikke differentieres imllem admin knap login og teacher admin knap login
    //Needs fixing
    public void handleLogin(ActionEvent actionEvent) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource("LoginPopUp.fxml"));
        Scene scene = new Scene(layout);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Roskilde Frie Børnehave");
        stage.show();
    }
}