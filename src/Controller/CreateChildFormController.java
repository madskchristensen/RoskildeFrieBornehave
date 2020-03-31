package Controller;

import Business.Child;
import Business.ChildRepository;
import Utility.TableManager;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateChildFormController extends Stage{

    public TextField getNameTF() {
        return nameTF;
    }

    public void setNameTF(TextField nameTF) {
        this.nameTF = nameTF;
    }

    public TextField getLastNameTF() {
        return lastNameTF;
    }

    public void setLastNameTF(TextField lastNameTF) {
        this.lastNameTF = lastNameTF;
    }

    public ChoiceBox<String> getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ChoiceBox<String> classRoom) {
        this.classRoom = classRoom;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    public DatePicker getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DatePicker birthDate) {
        this.birthDate = birthDate;
    }
    public int id;

    public TextField nameTF;
    public TextField lastNameTF;
    public ChoiceBox<String> classRoom;
    public Button saveButton;
    public Button cancelButton;
    public DatePicker birthDate;
    private Child child;

    public void initialize() {
        // Disabler gem button indtil alle fields er udfyldt
            child = new Child();
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

        //Something something add child
        //...
        try {
            ChildRepository childRep = new ChildRepository("administrator","admin_pass");

            child.setFirstName(nameTF.getText());
            child.setLastName(lastNameTF.getText());
            child.setBirthday(birthDate.getValue());
            child.setClassroom(classRoom.getValue());
            if(child.getId() == 0) {
                childRep.createMember(child);
            }else{
                childRep.updateMember(child);
            }

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

    public void setChild(Child child){
        this.child = child;
        nameTF.setText(child.getFirstName());
        lastNameTF.setText(child.getLastName());
        classRoom.setValue(child.getClassroom());
        birthDate.setValue(child.getBirthday());
    }


}
