
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class LoginPopUp {//extends AbstractController implements Initializable {

/*
  Forestiller mig at den kan bruges i takt med noget lignede:
  PopupControl popup = new PopupControl();
  popup.getScene().setRoot(yourGridPane);
  popup.show(yourGridPane.getScene().getWindow());
  https://stackoverflow.com/questions/36520331/how-does-one-create-a-pop-up-box-using-javafx


    Har forsøgt med noget controller men er ikke fædrdig
*/

    @FXML private TextField loginUsername;
    @FXML private PasswordField loginPassword;
    @FXML private Button buttonLogin;

/*    private Stage stage = null;
    private HashMap<String, Object> result = new HashMap<String, Object>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonLogin.setOnAction((event)->{
            result.clear();
            result.put("username", loginUsername.getText());
            result.put("password", loginPassword.getText());
            closeStage();
        });

    }

    public HashMap<String, Object> getResult() {
        return this.result;
    }

     //setting the stage of this view
    public void setStage(Stage stage) {
        this.stage = stage;
    }


    //Closes the stage of this view
    private void closeStage() {
        if(stage!=null) {
            stage.close();
        }
    }*/
}
