package repository;

import model.Member;

import java.sql.SQLException;

public interface MemberRepository {
    Member getMember(int id) throws SQLException;
    Member[] getMembers(String name) throws SQLException;
    Member[] getAllMembers() throws SQLException;
    void deleteMember(Member member) throws SQLException;
    void updateMember(Member member) throws SQLException;
    void createMember(Member member) throws SQLException;
}