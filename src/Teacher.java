import javafx.scene.control.Button;

public class Teacher extends TeacherRepository implements Member {

    public Button buttonShifts;
    public Button buttonChild;
    public Button buttonParent;
    public Button buttonTeacherLogOut;

    public Button buttonTeacherLogOutAdmin;
    public Button buttonWaitingAdmin;
    public Button buttonParentAdmin;
    public Button buttonChildAdmin;
    public Button buttonGuardAdmin;
    public Button buttonShiftsAdmin;

    private int id;
    private String firstName;
    private String lastName;
    private String[] classroom;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getClassroom() {
        return classroom;
    }

    public void setClassroom(String[] classroom) {
        this.classroom = classroom;
    }
}

