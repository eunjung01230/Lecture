package com.wanted.project.domain.menu.model.dao;

import com.wanted.project.domain.menu.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * [MenuRepository]
 * 역할 : Menu Entity 의 DB 접근을 담당한다. (구현체는 Spring Data JPA 가 만든다)
 * 책임 : - "무엇을 조회/저장/삭제할지" 만 선언한다. (SQL 실행은 Spring Data JPA 의 몫)
 *        - Entity 만 다룬다. DTO 변환, 트랜잭션, 규칙 판단은 Service / Policy 의 책임이다.
 *        - Menu 팀 소유. 다른 팀(Order 등)은 이 Repository 를 직접 사용하지 않는다.
 *
 * 할 일
 *  1. Menu Entity 를 관리하는 JPA Repository 로 만들기
 *  2. 쿼리 메서드 : 입력 가격 "초과" 메뉴를 가격 오름차순으로 조회
 *  3. [PART 3] 이름 중복 확인용 쿼리 메서드 (MenuNamePolicy 가 사용)
 *     - existsByMenuName()               : 같은 이름의 메뉴가 있는가?
 *     - existsByMenuNameAndMenuCodeNot() : "나를 제외하고" 같은 이름의 메뉴가 있는가? (이름 수정 시)
 */
@Repository
public interface MenuRepository {

    // TODO 2

    // TODO 3
}
