package Controller;

import Business.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminGuardianListController {

    public GridPane gridPane;
    public Button backButton;
    public Button createGuardianButton;
    public Button editButton;
    public Button deleteButton;
    public Button childButton;
    private TableView table;


    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void handleCreateGuardian(ActionEvent actionEvent) {
    }

    public void handleEdit(ActionEvent actionEvent) {
    }

    public void handleDelete(ActionEvent actionEvent) {
    }

    public void handleChild(ActionEvent actionEvent) {
    }
}
