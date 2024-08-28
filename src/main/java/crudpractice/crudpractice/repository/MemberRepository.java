package crudpractice.crudpractice.repository;

import crudpractice.crudpractice.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    Member findById(String id);
    void update(String memberId, int money);
    void delete(String id);
}
