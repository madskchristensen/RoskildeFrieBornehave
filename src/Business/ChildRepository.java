package Business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
                rs.getString("last_name"), rs.getInt("class"), LocalDate.parse(rs.getDate("birthday").toString()));
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
                    rs.getString("last_name"), rs.getInt("class"), LocalDate.parse(rs.getDate("birthday").toString())));
        }
        connection.closeConnection();
        return alc.toArray(new Child[alc.size()]);
    }

    public Child[] getAllMembers() throws SQLException{
        connection.openConnection();
        ResultSet rs = connection.select("Child", "*");
        ArrayList<Child> alg = new ArrayList<>();
        while (rs.next()) {
            alg.add(new Child(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getInt("class"), LocalDate.parse(rs.getDate("birthday").toString())));
        }
        connection.closeConnection();
        return alg.toArray(new Child[alg.size()]);
    }

    public Guardian[] getGuardians(Member member) throws SQLException{
       connection.openConnection();
        ResultSet rs = connection.select("guardian JOIN child_guardian_relationship cgr\n" +
                "        ON guardian.id = cgr.guardian_id\n" +
                "        JOIN child c\n" +
                "        ON c.id = cgr.child_id", "guardian.*", "c.id = " + member.getId());
        ArrayList<Guardian> alg = new ArrayList<>();

        while (rs.next()) {
            alg.add(new Guardian(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"),rs.getString("address"),
                    rs.getString("telefon"), rs.getString("email")));
        }
        connection.closeConnection();
        return alg.toArray(new Guardian[alg.size()]);
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
        Child child = (Child) member;

        connection.insert("child", new String [] {child.getFirstName(), child.getLastName(), Integer.toString(child.getClassroom()), child.getBirthday().toString()});
        connection.closeConnection();
    }

    @Override
    public void updateMember(String updatedColumn, String newValue, Member member) throws SQLException {
        connection.openConnection();
        connection.update("child", updatedColumn, newValue, "id = " + member.getId());
        connection.closeConnection();
    }
}
