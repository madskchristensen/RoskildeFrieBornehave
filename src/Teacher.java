public class Teacher extends TeacherRepository implements Member {
    private int id;
    private String name;
    private String[] classroom;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getId() {
        return 0;
    }
}