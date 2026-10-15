package com.wanted.a_statements;

import com.wanted.common.MenuDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.wanted.common.JDBCTemplate.close;
import static com.wanted.common.JDBCTemplate.getConnection;

public class Application04 {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        //MenuDTO menu = null;

        List<MenuDTO> menuList = new ArrayList<>();

        try {
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT * FROM TBL_MENU");

            while (rset.next()) {
                MenuDTO menu = new MenuDTO();
                menu.setMenuCode(rset.getInt("MENU_CODE"));
                menu.setMenuName(rset.getString("MENU_NAME"));
                menu.setMenuPrice(rset.getInt("MENU_PRICE"));
                menu.setCategoryCode(rset.getInt("CATEGORY_CODE"));
                menu.setOrderableStatus(rset.getString("ORDERABLE_STATUS").charAt(0));

                menuList.add(menu);
            }

//            System.out.println("menuList = " + menuList);
            for( MenuDTO menu2: menuList) {
                System.out.println(menu2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(rset);
            close(stmt);
        }
    }
}

/*
 try {
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT * FROM TBL_MENU");

            while (rset.next()) {
                MenuDTO menu = new MenuDTO(
                        rset.getInt("MENU_CODE"),
                        rset.getString("MENU_NAME"),
                        rset.getInt("MENU_PRICE"),
                        rset.getInt("CATEGORY_CODE"),
                        rset.getString("ORDERABLE_STATUS").charAt(0)
                );


                menuList.add(menu);
            }

            for(MenuDTO menu : menuList) {
                System.out.println(menu);
            }
 */
