package Business;

import java.sql.SQLException;

public interface MemberRepository {
    Member getMember(int id) throws SQLException;
    Member[] getMembers(String name) throws SQLException;
    void deleteMember(Member member) throws SQLException;
    void updateMember(String updatedColumn, String newValue, Member member) throws SQLException;
    void createMember(Member member) throws SQLException;
}