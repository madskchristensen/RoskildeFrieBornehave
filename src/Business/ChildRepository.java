package Business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChildRepository implements MemberRepository {
   private JDBC connection;

   public ChildRepository(String username, String password) throws SQLException {
       connection = new JDBC(username, password);
   }

    @Override
    public Child getMember(int id) throws SQLException {
        connection.openConnection();
        ResultSet rs = connection.select("child", "*", "id = " + id);
        Child child = new Child(rs.getInt("id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getInt("class"));
        connection.closeConnection();
        return child;
    }

    @Override
    public Child[] getMembers(String name) throws SQLException {
        connection.openConnection();
        ResultSet rs = connection.select("child", "*", " first_name LIKE \"%" + name + "%\"" +
                " OR last_name LIKE \"%" + name + "%\"");
        ArrayList<Child> alc = new ArrayList<>();
        while(rs.next()){
            alc.add(new Child(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getInt("class")));
        }
        connection.closeConnection();
        return alc.toArray(new Child[alc.size()]);
    }

    @Override
    public void deleteMember(Member member) throws SQLException{
        connection.openConnection();
        connection.delete("child", "id = " + member.getId());
        connection.closeConnection();
    }

    @Override
    public void createMember(Member member) throws SQLException{
        connection.openConnection();
        Guardian guardian = (Guardian) member;
        connection.insert("child", new String [] {guardian.getFirstName(), guardian.getLastName(),
                guardian.getAddress(), guardian.getPhoneNumber(), guardian.getEmail()});
        connection.closeConnection();
    }

    @Override
    public void updateMember(String updatedColumn, String newValue, Member member) throws SQLException {
        connection.openConnection();
        connection.update("child", updatedColumn, newValue, "id = " + member.getId());
        connection.closeConnection();
    }
}
