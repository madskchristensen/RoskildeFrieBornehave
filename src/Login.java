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

public class Login {//extends AbstractController implements Initializable {
    LoginPopUp loginpopUp = new LoginPopUp();
    @FXML private Label resultLbl;
    @FXML private Button loginButton;

    public Button buttonTeacherLogin;
    public Button buttonLoginAdmin;

    public boolean handleLogin() {
        System.out.println("logging in");
        return true;
    }
/*

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resultLbl.setText("");
        buttonTeacherLogin.setOnAction((event)->{
            HashMap<String, Object> resultMap = showPopupWindow();
            resultLbl.setText("username: "+resultMap.get("username")
                    +" /Password: "+resultMap.get("password")+")");
        });

    }
    private HashMap<String, Object> showPopupWindow() {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoginPopUp.fxml"));
        // initializing the controller
        LoginPopUp loginPopUp = new LoginPopUp();
        loader.setController(loginPopUp);
        Parent layout;
        try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            // this is the popup stage
            Stage popupStage = new Stage();
            // Giving the popup controller access to the popup stage (to allow the controller to close the stage)
            loginPopUp.setStage(popupStage);
            if(this.main!=null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginPopUp.getResult();
    }


}
*/
}