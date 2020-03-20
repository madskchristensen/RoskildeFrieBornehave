public interface MemberRepository {
    Member getById(int id);
    Member getByName(String name);
    void deleteMember(Member member);
    void saveMember(Member member);
}
