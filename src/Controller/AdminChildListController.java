package Controller;

import Business.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
    private TableView table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            TableManager tm = new TableManager();
            //pass the Column names and column properties to the createTable method
            String[] colNavn = new String[] {"ID", "Fornavn", "Efternavn", "Stue"};
            //the column Properties (colProp) are the names of the class attributes you want to read
            String[] colProp = new String[] {"id", "firstName", "lastName", "classroom"};
            //the column name and property arrays must run in the same order
            MemberRepository cr = new ChildRepository("employee", "password");
            //initialize the table
            table = tm.createTable(colNavn, colProp, cr.getAllMembers());
            //add table to fxml
            gridPane.add(table, 0, 0);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void readGuardian(ActionEvent actionEvent) throws IOException {
            SceneManager sceneManager = new SceneManager(new Stage());
            sceneManager.setSize(250,200);
            sceneManager.switchScene("PopUp.fxml", "Værger");
        }


    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void addToChildList(ActionEvent actionEvent) {
    }

    public void updateChildList(ActionEvent actionEvent) {
    }

    public void deleteFromChildList(ActionEvent actionEvent) {
    }


   /*public void initialize() {
        TableColumn id = new TableColumn("ID");
        TableColumn firstName = new TableColumn("firstName");
        TableColumn lastName = new TableColumn("lastName");
        TableColumn classroom = new TableColumn("class");
    }
*/


}
