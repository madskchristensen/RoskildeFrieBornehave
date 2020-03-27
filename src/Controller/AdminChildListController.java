package Controller;

import Business.*;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
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

public class AdminChildListController implements Initializable{

    public GridPane gridPane;
    public Button back;
    public Button guardian;
    public Button create;
    public Button update;
    public Button delete;
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
            //initialize the table and add it to the Main view
            gridPane.add(tableManager.createTable(colName, colProp, childRep.getAllMembers()), 0, 0);

            // Disabler update og delete knappen hvis ikke et row er valgt i table
            BooleanBinding rowNotSelected = Bindings
                    .size(tableManager.getTable().getSelectionModel().getSelectedItems())
                    .isNotEqualTo(1);

            update.disableProperty().bind(rowNotSelected);
            delete.disableProperty().bind(rowNotSelected);
            guardian.disableProperty().bind(rowNotSelected);

            tableManager.addSearch(childRep);
    } catch (SQLException e){
        e.printStackTrace();
    }

    }

    public void readGuardian(ActionEvent actionEvent) throws IOException {
            PopUp popUp = new PopUp<GuardianPopUpController>("GuardianPopUp.fxml");
            GuardianPopUpController g = (GuardianPopUpController) popUp.getController();
            g.addTable((Child) tableManager.getSelected());
            popUp.showAndWait("Værger");
            tableManager.clearSelection();
        }


    public void goBack(ActionEvent actionEvent) throws IOException {
        tableManager.clearSelection();
        Main.sceneManager.getPreviousScene();
    }

    public void addToChildList(ActionEvent actionEvent) throws IOException {
        try {
            PopUp popUp = new PopUp<CreateChildFormController>("CreateChildForm.fxml");
            popUp.showAndWait("Opret Barn");
            tableManager.updateTable(childRep.getAllMembers());
        }catch(SQLException sql){
            sql.printStackTrace();
        }
    }

    public void editChild(ActionEvent actionEvent) {
        PopUp popUp = new PopUp<CreateChildFormController>("CreateChildForm.fxml");
        CreateChildFormController c = (CreateChildFormController) popUp.getController();
        Child child = (Child) tableManager.getSelected();
        c.setChild(child);
        popUp.showAndWait("Opdater Barn");
        try {
            tableManager.updateTable(childRep.getAllMembers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableManager.clearSelection();
    }

    public void deleteFromChildList(ActionEvent actionEvent) {
        try {
            childRep.deleteMember(tableManager.getSelected());
            tableManager.updateTable(childRep.getAllMembers());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
