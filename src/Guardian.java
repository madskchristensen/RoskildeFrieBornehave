public class Guardian extends GuardianRepository implements Member {
    private int id;
    private String name;
    private String role;
    private int phoneNumber;
    private String email;

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
