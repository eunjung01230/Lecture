package com.wanted.entitymapping.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/* comment.
    JDBC에서는 DB접근 객체를 DAO라고 명칭한다.
    다만, Spring 환경에서 JPA를 사용할 때는 DAO 계층을
    Repository로 표현하기 때문에 이제부터는 DAO == Repository
    이렇게 인식하자!
 */
@Repository
public class MemberRepository {

    //DAO 계층
    //Persistence Context에 Entiry 객체 전달
    //전달 시에는 Entity Manager를 통해서 전달

    @PersistenceContext
    private EntityManager manager;

    public void save(Member member) {

        //1. 전달 받은 엔티티 객체를 매니저에게 persist(엔티티 객체)
        manager.persist(member);
    }

    public Member findByMemberNo(int memberNo) {
        //찾아 온 회원 1명을 return
        return manager.find(Member.class, memberNo);
    }
}
