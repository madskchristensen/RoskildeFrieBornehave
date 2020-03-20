public class Child extends ChildRepository implements Member {
    private int id;
    private String name;

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
