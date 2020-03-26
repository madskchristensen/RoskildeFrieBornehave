package Controller;

import Business.Child;
import Business.ChildRepository;
import Business.TableManager;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateChildFormController extends Stage{

    public TextField nameTF;
    public TextField lastNameTF;
    public ChoiceBox<String> classRoom;
    public Button saveButton;
    public Button cancelButton;
    public DatePicker birthDate;



    public void initialize() {
        // Disabler gem button indtil alle fields er udfyldt
            BooleanBinding booleanBind = nameTF.textProperty().isEmpty().
                    or(lastNameTF.textProperty().isEmpty()).
                    or(classRoom.valueProperty().isNull());

            saveButton.disableProperty().bind(booleanBind);

            // populate choiceBox
            ObservableList<String> list = FXCollections.observableArrayList();
            list.addAll("Blå", "Indigo", "Orange", "Violet");
            classRoom.setItems(list);

    }

    public void handleSave(ActionEvent actionEvent) throws IOException {
        // get a handle to the stage the button is built on
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();

        //Something something add guardian
        //...
        try {
            ChildRepository childRep = new ChildRepository("administrator","admin_pass");
            Child child = new Child();

            child.setFirstName(nameTF.getText());
            child.setLastName(lastNameTF.getText());
            child.setBirthday(birthDate.getValue());
            child.setClassroom(classRoom.getValue());

            childRep.createMember(child);

            TableManager tm = new TableManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleCancel(ActionEvent actionEvent) {
        // get handle and close stage
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
}
