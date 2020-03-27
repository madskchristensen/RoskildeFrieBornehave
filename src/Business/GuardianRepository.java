package Business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GuardianRepository implements MemberRepository {
    JDBC connection;

    public GuardianRepository(String username, String password) throws SQLException{
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
                "OR last_name LIKE \"%" + name + "%\" " + "OR CONCAT(first_name, \" \", last_name LIKE \"%" + name + "%\"");
        ArrayList<Guardian> alg = new ArrayList<>();
        while (rs.next()) {
            alg.add(new Guardian(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("address"),
                    rs.getString("phoneNr"), rs.getString("email")));
        }
        connection.closeConnection();
        return alg.toArray(new Guardian[alg.size()]);
    }

    public Child[] getChildren(Guardian guardian) throws SQLException{
    connection.openConnection();
    ResultSet rs = connection.select("guardian JOIN child_guardian_relationship cgr\n" +
            "        ON guardian.id = cgr.guardian_id\n" +
            "        JOIN child c\n" +
            "        ON c.id = cgr.child_id", "c.*", "guardian.id = " + guardian.getId());
    ArrayList<Child> alg = new ArrayList<>();

        while (rs.next()) {
            Child child = new Child(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"),rs.getString("class"),
                    LocalDate.parse(rs.getDate("birthday").toString()));
            System.out.println(child);
        alg.add(child);
    }
        connection.closeConnection();
        return alg.toArray(new Child[alg.size()]);
}

    public Guardian[] getAllMembers() throws SQLException{
        connection.openConnection();
        ResultSet rs = connection.select("guardian", "*");
        ArrayList<Guardian> alg = new ArrayList<>();
        while (rs.next()) {
            alg.add(new Guardian(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("address"),
                    rs.getString("telefon"), rs.getString("email")));
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
        connection.insert("guardian", new String[] {"first_name", "last_name", "address", "telefon", "email"}, new String [] {guardian.getFirstName(), guardian.getLastName(),
                guardian.getAddress(), guardian.getPhoneNumber(), guardian.getEmail()});
        connection.closeConnection();
    }

    @Override
    public void updateMember(Member member) throws SQLException {
        connection.openConnection();
        Guardian guardian = (Guardian) member;
        String[] column = new String[]{"first_name", "last_name", "address", "telefon", "email"};
        String[] newValues = new String[] {guardian.getFirstName(), guardian.getLastName(), guardian.getAddress(), guardian.getPhoneNumber(), guardian.getEmail()};
        for(int i = 0; i < column.length; i++){
            connection.update("guardian", column[i], newValues[i], "id = " + guardian.getId());
        }
        connection.closeConnection();
    }
}
