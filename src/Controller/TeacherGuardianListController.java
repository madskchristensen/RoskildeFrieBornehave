package Controller;

import Business.*;
import Utility.PopUp;
import Utility.TableManager;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherGuardianListController implements Initializable {

    public GridPane gridPane;
    public Button backButton;
    public Button childButton;
    private TableManager tableManager;
    private MemberRepository guardianRepo;

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
            //add table to fxml
            gridPane.add(tableManager.createTable(colNavn, colProp, guardianRepo.getAllMembers()), 0, 0);
            tableManager.addSearch(guardianRepo);

            // Disabler update og delete knappen hvis ikke et row er valgt i table
            BooleanBinding rowNotSelected = Bindings
                    .size(tableManager.getTable().getSelectionModel().getSelectedItems())
                    .isNotEqualTo(1);

            childButton.disableProperty().bind(rowNotSelected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        tableManager.clearSelection();
        Main.sceneManager.getPreviousScene();

    }

    public void handleChild(ActionEvent actionEvent) {
        PopUp popUp = new PopUp<ChildPopUpController>("ChildPopUp.fxml");
        ChildPopUpController c = (ChildPopUpController) popUp.getController();
        c.addTable((Guardian) tableManager.getSelected());
        popUp.show("Børn");
        tableManager.clearSelection();
    }
}
