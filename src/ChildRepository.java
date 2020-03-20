import java.sql.SQLException;
import java.util.Scanner;

public class ChildRepository implements MemberRepository {
    private JDBC jdbc;
    private Scanner scanner;

    public ChildRepository() throws SQLException {
        this.jdbc = new JDBC("administrator", "admin_pass");
    }

    @Override
    public Child getById(int id) throws SQLException {
        jdbc.openConnection();

        jdbc.select("child", "*", "id = " + id);
        String firstName = jdbc.getResultSet().getString("first_name");
        String lastName =  jdbc.getResultSet().getString("last_name");

        jdbc.closeConnection();

        return new Child(id, firstName, lastName);
    }

    @Override
    public Child getByName(String name) throws SQLException {
        scanner = new Scanner(name);
        String firstName = scanner.next();
        String lastName = scanner.next();

        jdbc.openConnection();
        jdbc.select("child", "*", "first_name = " + "\"" + firstName  + "\"" + " AND last_name = "
                + "\"" + lastName + "\"");

        int id = jdbc.getResultSet().getInt("id");

        jdbc.closeConnection();

        return new Child(id, firstName, lastName);
    }

    @Override
    public void deleteMember(Member member) throws SQLException {

    }

    @Override
    public void saveMember(Member member) throws SQLException {

    }
}
