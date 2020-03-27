package Controller;

import Business.Guardian;
import Business.GuardianRepository;
import Business.Teacher;
import Business.TeacherRepository;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CreateTeacherFormController {
    public TextField nameTF;
    public TextField lastNameTF;
    public TextField addressTF;
    public TextField phoneNrTF;
    public TextField eMailTF;
    public Button saveButton;
    public Button cancelButton;
    private Teacher teacher;

    public void initialize() {
        // Disabler gem button indtil alle fields er udfyldt
        teacher = new Teacher();
        BooleanBinding booleanBind = nameTF.textProperty().isEmpty().
                or(lastNameTF.textProperty().isEmpty()).
                or(addressTF.textProperty().isNull()).
                or(phoneNrTF.textProperty().isNull()).
            or(eMailTF.textProperty().isNull());

        saveButton.disableProperty().bind(booleanBind);
    }

        public void handleSave(ActionEvent actionEvent) throws IOException {
        // get a handle to the stage the button is built on
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();

        //Something something add guardian
        //...
        try {
            TeacherRepository teacherRepository = new TeacherRepository("administrator","admin_pass");
            Teacher teacher = new Teacher();

            teacher.setFirstName(nameTF.getText());
            teacher.setLastName(lastNameTF.getText());
            teacher.setAddress(addressTF.getText());
            teacher.setPhoneNumber(phoneNrTF.getText());
            teacher.setEmail(eMailTF.getText());

            teacherRepository.createMember(teacher);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleCancel(ActionEvent actionEvent) {
        // get handle and close stage
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
        nameTF.setText(teacher.getFirstName());
        lastNameTF.setText(teacher.getLastName());
        addressTF.setText(teacher.getAddress());
        phoneNrTF.setText(teacher.getPhoneNumber());
        eMailTF.setText(teacher.getEmail());
    }

}
