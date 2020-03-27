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
            TableView table = tableManager.createTable(colName, colProp, childRep.getAllMembers());
            gridPane.add(table, 0, 0);
    } catch (SQLException e){
        e.printStackTrace();
    }

    }

    public void readGuardian(ActionEvent actionEvent) throws IOException {
        PopUp pop = new PopUp<GuardianPopUpController>("GuardianPopUp.fxml");
        GuardianPopUpController g = (GuardianPopUpController) pop.getController();
        g.addTable((Child) tableManager.getSelected());
        pop.show("Værger");
        }


    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void addToChildList(ActionEvent actionEvent) throws IOException {
        try {
            PopUp pop = new PopUp<CreateChildFormController>("CreateChildForm.fxml");
            pop.showAndWait("Opret Barn");
            tableManager.updateTable(childRep.getAllMembers());
        }catch(SQLException sql){
            sql.printStackTrace();
        }
    }

    public void updateChildList(ActionEvent actionEvent) {
        System.out.println(tableManager.getSelected());
        PopUp pop = new PopUp<CreateChildFormController>("CreateChildForm.fxml");
        CreateChildFormController c = (CreateChildFormController) pop.getController();
        Child child = (Child) tableManager.getSelected();
        c.setChild(child);
        pop.showAndWait("Opdater Barn");
        try {
            tableManager.updateTable(childRep.getAllMembers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
