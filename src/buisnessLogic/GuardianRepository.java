package buisnessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuardianRepository implements MemberRepository {
    JDBC connection;

    GuardianRepository(String username, String password) throws SQLException{
        connection = new JDBC(username, password);
    }

    @Override
    public Guardian getMember(int id) throws SQLException{
            connection.openConnection();
            ResultSet rs = connection.select("guardian", "*", "id = " + id);
            Guardian guard = new Guardian(rs.getInt("id"), rs.getString("first_name"),
                rs.getString("last_name"),rs.getString("address"),
                rs.getString("phoneNr"), rs.getString("email"));
            connection.closeConnection();
            return guard;
    }

    @Override
    public Guardian[] getMembers(String name) throws SQLException {
        connection.openConnection();
        ResultSet rs = connection.select("guardian", "*", " first_name LIKE \"%" + name + "%\" " +
                "OR last_name LIKE \"%" + name + "%\"");
        ArrayList<Guardian> alg = new ArrayList<>();
        while (rs.next()) {
            alg.add(new Guardian(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("address"),
                    rs.getString("phoneNr"), rs.getString("email")));
        }
        connection.closeConnection();
        return alg.toArray(new Guardian[alg.size()]);
    }

    public Guardian[] getAllMembers() throws SQLException{
        connection.openConnection();
        ResultSet rs = connection.select("guardian", "*");
        ArrayList<Guardian> alg = new ArrayList<>();
        while (rs.next()) {
            alg.add(new Guardian(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("address"),
                    rs.getString("phoneNr"), rs.getString("email")));
        }
        connection.closeConnection();
        return alg.toArray(new Guardian[alg.size()]);
    }

    @Override
    public void deleteMember(Member member) throws SQLException{
        connection.openConnection();
        connection.delete("guardian", "id = " + member.getId());
        connection.closeConnection();
    }

    @Override
    public void createMember(Member member) throws SQLException{
        connection.openConnection();
        Guardian guardian = (Guardian) member;
        connection.insert("guardian", new String [] {guardian.getFirstName(), guardian.getLastName(),
                guardian.getAddress(), guardian.getPhoneNumber(), guardian.getEmail()});
        connection.closeConnection();
    }

    @Override
    public void updateMember(String updatedColumn, String newValue, Member member) throws SQLException {
        connection.openConnection();
        connection.update("guardian", updatedColumn, newValue, "id = " + member.getId());
        connection.closeConnection();
    }
}
