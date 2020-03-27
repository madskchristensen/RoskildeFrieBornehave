package Controller;

import Business.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminGuardianListController implements Initializable {

    public GridPane gridPane;
    public Button backButton;
    public Button createGuardianButton;
    public Button editButton;
    public Button deleteButton;
    public Button childButton;
    private MemberRepository guardianRepo;
    private TableManager tableManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tableManager = new TableManager();
            //pass the Column names and column properties to the createTable method
            String[] colNavn = new String[]{"ID", "Fornavn", "Efternavn", "Adresse", "Telefon Nummer", "E-mail"};
            //the column Properties (colProp) are the names of the class attributes you want to read
            String[] colProp = new String[]{"id", "firstName", "lastName", "address", "phoneNumber", "email"};
            //the column name and property arrays must run in the same order
            guardianRepo = new GuardianRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
            //initialize the table
            TableView table = tableManager.createTable(colNavn, colProp, guardianRepo.getAllMembers());
            //add table to fxml
            gridPane.add(table, 0, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void handleCreateGuardian(ActionEvent actionEvent) throws IOException {
        SceneManager sceneManager = new SceneManager(new Stage());
        sceneManager.setSize(500,400);
        sceneManager.switchScene("CreateGuardianForm.fxml", "Opret værge");
    }

    public void handleEdit(ActionEvent actionEvent) {
    }

    public void handleDelete(ActionEvent actionEvent) {
        try {
            guardianRepo.deleteMember(tableManager.getSelected());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleChild (ActionEvent actionEvent){
        PopUp pop = new PopUp<ChildPopUpController>("ChildPopUp.fxml");
        ChildPopUpController c = (ChildPopUpController) pop.getController();
        Guardian guard = (Guardian) tableManager.getSelected();
        System.out.println(c);
        c.addTable(guard);
        pop.show("Børn");
    }

}
