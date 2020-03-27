package Controller;

import Business.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

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
            //initialize the table
            //add table to fxml
            gridPane.add(tableManager.createTable(colNavn, colProp, guardianRepo.getAllMembers()), 0, 0);
            tableManager.addSearch(guardianRepo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();

    }

    public void handleChild(ActionEvent actionEvent) {
        PopUp pop = new PopUp<ChildPopUpController>("ChildPopUp.fxml");
        ChildPopUpController c = (ChildPopUpController) pop.getController();
        c.addTable((Guardian) tableManager.getSelected());
        pop.show("Børn");
    }
}
