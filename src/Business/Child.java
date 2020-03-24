package Business;

public class Child implements Member {
    private int id;
    private String firstName;
    private String lastName;
    private int classroom;

    public Child() {
    }

    public Child(int id, String firstName, String lastName, int classroom) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classroom = classroom;
    }

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

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString(){
        return "id: " +id + "\nfirst name: " + firstName + "\nlast name: " + lastName + "\nclassroom: " + classroom + "\n ";
    }
}
