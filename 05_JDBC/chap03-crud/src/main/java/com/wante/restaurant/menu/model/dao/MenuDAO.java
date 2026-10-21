package com.wante.restaurant.menu.model.dao;

import com.wante.restaurant.global.common.QueryUtil;
import com.wante.restaurant.menu.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
    /* comment.
        DAO 계층의 책임
        - DAO는 DB로 접근하기 위한 관문이다.
        DAO 계층의 해야 할 일
        - 1. SQL 구문을 실행한다.
        - 2. Statement 객체 생성
        - 3. 전달 받은 파라미터를 SQL에 바인딩
        - 4. ResultSet으로 SQL 결과 받기
        - 5. SQL 결과를 Java 객체로 변환
     */

    private final Connection connection;

    public MenuDAO(Connection connection) {
        this.connection = connection;
    }

    public List<MenuDTO> findAll() throws SQLException {

        String query = QueryUtil.getQuery("menu.findAll");
        // 조회 결과를 담을 객체 생성
        List<MenuDTO> menus = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {

            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                MenuDTO menu = new MenuDTO(
                        rset.getInt("MENU_CODE"),
                        rset.getString("MENU_NAME"),
                        rset.getInt("MENU_PRICE"),
                        rset.getInt("CATEGORY_CODE"),
                        rset.getString("ORDERABLE_STATUS")
                );
                menus.add(menu);
            }
        }
        return menus;
    }

    public int updateMenuPrice(int code, int price)
        throws SQLException {

            String query = QueryUtil.getQuery("menu.updatePrice");

            try (PreparedStatement pstmt =
                         connection.prepareStatement(query)) {

                pstmt.setInt(1, price);
                pstmt.setInt(2, code);

                return pstmt.executeUpdate();
            }
        }

    public int deleteMenu(int num) throws SQLException {

        String query = QueryUtil.getQuery("menu.deleteMenu");

        try (PreparedStatement pstmt =
                     connection.prepareStatement(query)) {

            pstmt.setInt(1, num);

            return pstmt.executeUpdate();
        }
    }
}
