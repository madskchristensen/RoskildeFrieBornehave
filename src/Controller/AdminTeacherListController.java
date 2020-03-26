package Controller;

import Business.Main;
import Business.MemberRepository;
import Business.TableManager;
import Business.TeacherRepository;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminTeacherListController implements Initializable {

    public GridPane gridPane;
    public Button back;
    public Button guardian;
    public Button update;
    public Button delete;
    private TableManager tableManager;
    private MemberRepository teacherRepo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tableManager = new TableManager();
            //pass the Column names and column properties to the createTable method
            String[] colNavn = new String[]{"ID", "Fornavn", "Efternavn", "Adresse", "Telefon Nummer", "E-mail"};
            //the column Properties (colProp) are the names of the class attributes you want to read
            String[] colProp = new String[]{"id", "firstName", "lastName", "address", "phoneNumber", "email"};
            //the column name and property arrays must run in the same order
            teacherRepo = new TeacherRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
            //initialize the table
            TableView table = tableManager.createTable(colNavn, colProp, teacherRepo.getAllMembers());
            //add table to fxml
            gridPane.add(table, 0, 0);
            gridPane.setVgrow(table, Priority.ALWAYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void readTeacherShift(ActionEvent actionEvent) {
    }

    public void updateTeacherList(ActionEvent actionEvent) {
    }

    public void deleteFromTeacherList(ActionEvent actionEvent) {
        try {
            teacherRepo.deleteMember(tableManager.getSelected());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
