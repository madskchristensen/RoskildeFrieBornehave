package controller;

import model.*;
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
import repository.MemberRepository;
import repository.TeacherRepository;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminTeacherListController implements Initializable {

    public GridPane gridPane;
    public Button back;
    public Button teacherShift;
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
            //add table to fxml
            gridPane.add(tableManager.createTable(colNavn, colProp, teacherRepo.getAllMembers()), 0, 0);
            tableManager.addSearch(teacherRepo);

            // Disabler update og delete knappen hvis ikke et row er valgt i table
            BooleanBinding rowNotSelected = Bindings
                    .size(tableManager.getTable().getSelectionModel().getSelectedItems())
                    .isNotEqualTo(1);

            update.disableProperty().bind(rowNotSelected);
            delete.disableProperty().bind(rowNotSelected);
            teacherShift.disableProperty().bind(rowNotSelected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        tableManager.clearSelection();
        Main.sceneManager.getPreviousScene();
    }

    public void readTeacherShift(ActionEvent actionEvent) {
    }

    public void updateTeacherList(ActionEvent actionEvent) {
        PopUp pop = new PopUp<CreateTeacherFormController>("CreateTeacherForm.fxml");
        CreateTeacherFormController teach = (CreateTeacherFormController) pop.getController();
        teach.setTeacher((Teacher) tableManager.getSelected());
        pop.showAndWait("Opdater Lærer");
        try {
            tableManager.updateTable(teacherRepo.getAllMembers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromTeacherList(ActionEvent actionEvent) {
        try {
            teacherRepo.deleteMember(tableManager.getSelected());
            tableManager.updateTable(teacherRepo.getAllMembers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTeacherForm(ActionEvent actionEvent) throws IOException {
        SceneManager sceneManager = new SceneManager(new Stage());
        sceneManager.setSize(500,400);
        sceneManager.switchScene("CreateTeacherForm.fxml", "Lav pædagog");
    }
}
