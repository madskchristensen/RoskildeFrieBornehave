package controller;

import model.*;
import utility.DialogBox;
import utility.PopUp;
import utility.SceneManager;
import utility.TableManager;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import repository.GuardianRepository;
import repository.MemberRepository;

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
    private DialogBox dialogBox;

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
            gridPane.add(tableManager.createTable(colNavn, colProp, guardianRepo.getAllMembers()), 0, 0);
            //add table to fxml

            // Disabler update og delete knappen hvis ikke et row er valgt i table
            BooleanBinding rowNotSelected = Bindings
                    .size(tableManager.getTable().getSelectionModel().getSelectedItems())
                    .isNotEqualTo(1);

            editButton.disableProperty().bind(rowNotSelected);
            deleteButton.disableProperty().bind(rowNotSelected);
            childButton.disableProperty().bind(rowNotSelected);

            tableManager.addSearch(guardianRepo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        tableManager.clearSelection();
        Main.sceneManager.getPreviousScene();
    }

    public void handleCreateGuardian(ActionEvent actionEvent) throws IOException {
        try {
            PopUp popUp = new PopUp<CreateGuardianFormController>("CreateGuardianForm.fxml");
            popUp.showAndWait("Opret Værge");
            tableManager.updateTable(guardianRepo.getAllMembers());
        }catch(SQLException sql){
            sql.printStackTrace();
        }
    }

    public void handleEdit(ActionEvent actionEvent) {
        PopUp pop = new PopUp<CreateGuardianFormController>("CreateGuardianForm.fxml");
        CreateGuardianFormController c = (CreateGuardianFormController) pop.getController();
        Guardian guardian = (Guardian) tableManager.getSelected();
        c.setGuardian(guardian);
        pop.showAndWait("Rediger Værge");
        try {
            tableManager.updateTable(guardianRepo.getAllMembers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleDelete(ActionEvent actionEvent) {
        try {
            guardianRepo.deleteMember(tableManager.getSelected());
            tableManager.updateTable(guardianRepo.getAllMembers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleChild (ActionEvent actionEvent){
            PopUp popUp = new PopUp<ChildPopUpController>("ChildPopUp.fxml");
            ChildPopUpController c = (ChildPopUpController) popUp.getController();
            Guardian guard = (Guardian) tableManager.getSelected();
            c.addTable(guard);

            String selectedGuardianName = tableManager.getSelected().getFirstName() + " "
                    + tableManager.getSelected().getLastName();


            popUp.show("Børn (" + selectedGuardianName + ")");

            tableManager.clearSelection();
    }

}
