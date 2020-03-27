package Business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherRepository implements MemberRepository {
    private JDBC connection;

    public TeacherRepository(String username, String password) throws SQLException{
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
                "OR last_name LIKE \"%" + name + "%\" " + "OR CONCAT(first_name, \" \", last_name LIKE \"%" + name + "%\")");
        ArrayList<Teacher> teachers = new ArrayList<>();
        while (rs.next()) {
            teachers.add(new Teacher(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("address"),
                    rs.getString("phoneNr"), rs.getString("email")));
        }
        connection.closeConnection();
        return teachers.toArray(new Teacher[teachers.size()]);
    }

    public Teacher[] getAllMembers() throws SQLException{
        connection.openConnection();
        ResultSet rs = connection.select("teacher", "*");
        ArrayList<Teacher> alg = new ArrayList<>();
        while (rs.next()) {
            alg.add(new Teacher(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("address"),
                    rs.getString("phoneNr"), rs.getString("email")));
        }
        connection.closeConnection();
        return alg.toArray(new Teacher[alg.size()]);
    }

    @Override
    public void deleteMember(Member member) throws SQLException{
        connection.openConnection();
        connection.delete("teacher", "id = " + member.getId());
        connection.closeConnection();
    }

    @Override
    public void createMember(Member member) throws SQLException{
        connection.openConnection();
        Teacher teach = (Teacher) member;
        connection.insert("teacher", new String[] {"first_name", "last_name", "address", "phoneNr", "email"}, new String [] {teach.getFirstName(), teach.getLastName(),
                teach.getAddress(), teach.getPhoneNumber(), teach.getEmail()});
        connection.closeConnection();
    }

    @Override
    public void updateMember(Member member) throws SQLException {
        connection.openConnection();
        Teacher teacher = (Teacher) member;
        String[] column = new String[]{"first_name", "last_name", "addresse", "telefon", "email"};
        String[] newValues = new String[] {teacher.getFirstName(), teacher.getLastName(), teacher.getAddress(), teacher.getPhoneNumber(), teacher.getEmail()};
        for(int i = 0; i < column.length; i++){
            connection.update("teacher", column[i], newValues[i], "id = " + teacher.getId());
        };
        connection.closeConnection();
    }
}
