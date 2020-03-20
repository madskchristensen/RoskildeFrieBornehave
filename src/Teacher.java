public class Teacher extends TeacherRepository implements Member {
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
}