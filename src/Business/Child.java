package Business;

import java.time.LocalDate;

public class Child implements Member {
    private int id;
    private String firstName;
    private String lastName;
    private String classroom;
    private int age;
    private LocalDate birthday;

    public Child() {
    }

    private int calculateAge(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();

        return currentDate.getYear() - birthday.getYear();
    }

    public Child(int id, String firstName, String lastName, String classroom, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classroom = classroom;
        this.birthday = birthday;
        this.age = calculateAge(birthday);
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString(){
        return "id: " + id + "\nfirst name: " + firstName + "\nlast name: " + lastName + "\nclassroom: " + classroom + "\n" + "birthday: " + birthday;
    }
}
