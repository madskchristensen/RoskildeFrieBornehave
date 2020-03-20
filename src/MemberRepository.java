import java.sql.SQLException;

public interface MemberRepository {
    Member getById(int id) throws SQLException;
    Member getByName(String name) throws SQLException;
    void deleteMember(Member member) throws SQLException;
    void saveMember(Member member) throws SQLException;
}