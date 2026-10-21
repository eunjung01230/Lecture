package com.wante.restaurant.menu.model.service;

import com.wante.restaurant.global.config.JDBCTemplate;
import com.wante.restaurant.menu.model.dao.MenuDAO;
import com.wante.restaurant.menu.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuService {

    /* comment
        써비스 중요한 클래스임
        Service 계층의 책임
        - Service 계층은 비즈니스 로직을 담당하는 계층이다.
        - 비즈니스 로직이란?
        - 우리 프로젝트 규칙 상 어떤 작업이 어떤 순서대로
        - 처리 되는 지에 대한 정의를 내리는 구문이다.
        Service 계층이 해야 할 일
        - 1. DAO 계층 호출
        - 2. 데이터 검증 및 가공
        - 3. 필요 시 여러 DAO 조합(ex- 메뉴 생성 시 카테고리도 같이 삽입)
        - 4. 트랜젝션 처리(commit, rollback) & Connection 생성
        - 5. 예외처리
     */

//    private final MenuDAO menuDAO;
//
//    //menuDAO 초기화하는 생성자
//    public MenuService(MenuDAO menuDAO) {
//        this.menuDAO = menuDAO;
//    }

    public List<MenuDTO> findAllMenus() {

        //try-with-resource 절
        //try-catch 절은 사용한 자원을 finally 구문에서 수동 해제해야한다.
        //try() 소괄호 내부 자원을 자동 해제 해준다. // close기능을 자동으로 해줌 많이 사용
        try (Connection con = JDBCTemplate.getConnection()) {
            return new MenuDAO(con).findAll();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int updateMenuPrice(int code, int price) {
        if (price < 0) {
            throw new IllegalArgumentException(
                    "가격은 0원 이상이어야 합니다."
            );
        }

        try (Connection con = JDBCTemplate.getConnection()) {

            // 자동 커밋 비활성화
            con.setAutoCommit(false);

            try {
                MenuDAO menuDAO = new MenuDAO(con);

                int result = menuDAO.updateMenuPrice(code, price);

                if (result > 0) {
                    con.commit();
                } else {
                    con.rollback();
                }

                return result;

            } catch (SQLException e) {
                con.rollback();
                throw e;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public int deleteMenu(int num) {
//
//        try (Connection con = JDBCTemplate.getConnection()) {
//
//            return new MenuDAO(con).deleteMenu(num);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public int deleteMenu(int num) {

        try (Connection con = JDBCTemplate.getConnection()) {

            // 1. 자동 커밋 비활성화
            con.setAutoCommit(false);

            try {
                // 2. DAO를 통해 메뉴 삭제
                MenuDAO menuDAO = new MenuDAO(con);
                int result = menuDAO.deleteMenu(num);

                // 3. 삭제 성공 여부 확인
                if (result > 0) {
                    con.commit();    // 성공하면 확정
                } else {
                    con.rollback();  // 삭제된 행이 없으면 취소
                }

                return result;

            } catch (SQLException e) {
                // 4. SQL 오류 발생 시 취소
                con.rollback();
                throw e;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
