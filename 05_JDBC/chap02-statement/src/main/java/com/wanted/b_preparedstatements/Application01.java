package com.wanted.b_preparedstatements;

import com.wanted.common.MenuDTO;

import java.sql.*;
import java.util.Scanner;

import static com.wanted.common.JDBCTemplate.close;
import static com.wanted.common.JDBCTemplate.getConnection;

public class Application01 {
    public static void main(String[] args) {

        /* comment.
            Statement 는 SQL 쿼리문을 실행할 때마다
            SQL 구문이 DB에 전송되어 DB에서 SQL 구문을
            파싱(번역)하고 컴파일 하는 과정을 거치게 된다. // SQL구문을 DB가 읽을 수 있도록 번역
            PreparedStatement 는 최초 1회 실행 시 ,
            SQL 구문을 파싱하고 컴파일하는 것은 동일하지만,
            동일한 SQL을 재요청하면 최초에 컴파일 해둔 SQL을
            재사용하게 된다. // 반복은 비효율
            따라서, 파싱 및 컴파일 과정이 생략되어 성능이 향상된다.
         */

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {

            pstmt = con.prepareStatement("SELECT * FROM TBL_MENU");

            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(
                        rset.getString("MENU_NAME") + " 은/는 "
                                + rset.getString("MENU_PRICE") + "원 입니다. "
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(rset);
            close(pstmt);
        }
    }
}
