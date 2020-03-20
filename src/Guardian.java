public class Guardian extends GuardianRepository implements Member {
    private int id;
    private String Name;
    private String role;
    private int phoneNumber;
    private String email;

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
