package buisnessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherRepository implements MemberRepository {
    JDBC connection;

    TeacherRepository(String username, String password) throws SQLException{
        connection = new JDBC(username, password);
    }

    @Override
    public Teacher getMember(int id) throws SQLException{
        connection.openConnection();
        ResultSet rs = connection.select("teacher", "*", "id = " + id);
        Teacher teach = new Teacher(rs.getInt("id"), rs.getString("first_name"),
                rs.getString("last_name"),rs.getString("address"),
                rs.getString("phoneNr"), rs.getString("email"));
        connection.closeConnection();
        return teach;
    }

    @Override
    public Teacher[] getMembers(String name) throws SQLException {
        connection.openConnection();
        ResultSet rs = connection.select("teacher", "*", " first_name LIKE \"%" + name + "%\" " +
                "OR last_name LIKE \"%" + name + "%\"");
        ArrayList<Teacher> teachers = new ArrayList<>();
        while (rs.next()) {
            teachers.add(new Teacher(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("address"),
                    rs.getString("phoneNr"), rs.getString("email")));
        }
        connection.closeConnection();
        return teachers.toArray(new Teacher[teachers.size()]);
    }

    @Override
    public void deleteMember(Member member) throws SQLException{
        connection.openConnection();
        connection.delete("Teacher", "id = " + member.getId());
        connection.closeConnection();
    }

    @Override
    public void createMember(Member member) throws SQLException{
        connection.openConnection();
        Teacher teach = (Teacher) member;
        connection.insert("teacher", new String [] {teach.getFirstName(), teach.getLastName(),
                teach.getAddress(), teach.getPhoneNumber(), teach.getEmail()});
        connection.closeConnection();
    }

    @Override
    public void updateMember(String updatedColumn, String newValue, Member member) throws SQLException {
        connection.openConnection();
        connection.update("teacher", updatedColumn, newValue, "id = " + member.getId());
        connection.closeConnection();
    }
}
