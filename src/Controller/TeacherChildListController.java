package Controller;

import Business.ChildRepository;
import Business.Main;
import Business.MemberRepository;
import Business.TableManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

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
            //initialize the table
            table = tableManager.createTable(colName, colProp, childRep.getAllMembers());
            //add table to fxml
            gridPane.add(table, 0, 0);
            gridPane.setVgrow(table, Priority.ALWAYS);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }


    public void handleGuardian(ActionEvent actionEvent) {
    }
}
