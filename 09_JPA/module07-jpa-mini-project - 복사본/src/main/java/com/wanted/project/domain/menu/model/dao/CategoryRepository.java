package com.wanted.project.domain.menu.model.dao;

import com.wanted.project.domain.menu.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * [CategoryRepository]
 * 역할 : Category Entity 의 DB 접근을 담당한다.
 * 책임 : - 쿼리 메서드로 표현하기 어려운 조회는 @Query 로 직접 SQL 을 작성한다.
 *        - Entity 만 다룬다. DTO 변환은 Service 의 책임이다.
 *
 * 할 일
 *  1. Category Entity 를 관리하는 JPA Repository 로 만들기
 *  2. findSubCategories() : 하위 카테고리(ref_category_code 가 NULL 이 아닌 것)만 category_code 순으로 조회
 *                           (native query 직접 작성, 메뉴 등록 화면의 카테고리 목록에 사용)
 */
@Repository
public interface CategoryRepository {

    // TODO 2
}
