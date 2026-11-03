package com.wanted.entitymapping.section01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberSercive {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberSercive(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* comment. Service
        1. 비즈니스 로직 작성(시스템 정책)
        2. DAO 데이터베이스 접근 객체의 메서드를 호출한다.
        3. 트랜젝션 관리 (1번과 연관됨)  -> 상당히 중요함
        - 여러 시스템 비즈니스 로직이 섞이게 되며
        - 1개라도 실패 시 rollback 작업이 매우 중요하다.
     */

    // 메서드 실행 시 begin()
    // 메서드 종료 시 - 정상 종료 : commit() = DB에 반영, 예외 발생: rollback();
    // 블로그 작성 키워드
    // 1.Checked 예외 / UnChecked 예외의 Transactional 동작 방식
    // 2.Transactional의 전파
    @Transactional
    public int registMember(MemberRegistDTO dto) {

        // 1. DTO -> Entity
        Member member = new Member(
                dto.getMemberId(),
                dto.getMemberPwd(),
                dto.getMemberName(),
                dto.getPhone(),
                dto.getAddress(),
                dto.getEnrollDate(),
                dto.getMemberRole(),
                dto.getStatus()
        );

        // 2. 변환 된 Entity를 JPA를 사용하는 DAO 계층에 전달한다.
        memberRepository.save(member);

        return member.getMemberNo();
    }

    /* comment.
        읽기 전용 트랜젝션은 불필요한 변경 감지를 하지 않는다. 그래서 묶어놓기만 함
     */
    @Transactional(readOnly = true)
    public MemberRegistDTO findByMemberNo(int memberNo) {

        //1. 영속성 컨텍스트에서 PK 엔티티 find(PK);
        Member foundMember = memberRepository.findByMemberNo(memberNo);
        //2. Entity 객체를 DTO 변환
        MemberRegistDTO findMember = new MemberRegistDTO(
                foundMember.getMemberId(),
                foundMember.getMemberPwd(),
                foundMember.getMemberName(),
                foundMember.getPhone()
        );
        return findMember;
    }
}


