import javafx.scene.control.Button;

public class Teacher extends TeacherRepository implements Member {


    public Button buttonVagtplan;
    public Button buttonChild;
    public Button buttonParent;
    public Button buttonTeacherLogOut;

    private int id;
    private String name;
    private String[] classroom;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public boolean handleButtonVagtplan() {
        return true;
    }

    public boolean handleButtonChild(){
        return true;
    }

    public boolean handleButtonParent(){
        return true;
    }

    public boolean handleLogOut(){
        return true;
    }
}