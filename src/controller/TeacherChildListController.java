package controller;

import model.*;
import utility.PopUp;
import utility.TableManager;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import repository.ChildRepository;
import repository.MemberRepository;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherChildListController implements Initializable {

    public GridPane gridPane;
    public Button backButton;
    public Button guardianButton;
    private TableView table;
    private TableManager tableManager;
    private MemberRepository childRep;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tableManager = new TableManager();
            //pass the Column names and column properties to the createTable method
            String[] colName = new String[] {"ID", "Fornavn", "Efternavn", "Alder", "Stue", "Fødselsdato"};
            //the column Properties (colProp) are the names of the class attributes you want to read
            String[] colProp = new String[] {"id", "firstName", "lastName", "age", "classroom", "birthday"};
            //the column name and property arrays must run in the same order
            childRep = new ChildRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
            //add table to fxml
            gridPane.add(tableManager.createTable(colName, colProp, childRep.getAllMembers()), 0, 0);
            tableManager.addSearch(childRep);

            // Disabler update og delete knappen hvis ikke et row er valgt i table
            BooleanBinding rowNotSelected = Bindings
                    .size(tableManager.getTable().getSelectionModel().getSelectedItems())
                    .isNotEqualTo(1);

            guardianButton.disableProperty().bind(rowNotSelected);

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        tableManager.clearSelection();
        Main.sceneManager.getPreviousScene();
    }


    public void handleGuardian(ActionEvent actionEvent) {
        PopUp popUp = new PopUp<GuardianPopUpController>("GuardianPopUp.fxml");
        GuardianPopUpController g = (GuardianPopUpController) popUp.getController();
        g.addTable((Child) tableManager.getSelected());
        popUp.show("Værger");
        tableManager.clearSelection();
    }
}
