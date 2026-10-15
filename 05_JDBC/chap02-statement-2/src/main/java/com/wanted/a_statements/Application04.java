package com.wanted.a_statements;

import com.wanted.common.EmpDTO;
import com.wanted.common.JDBCTemplate;
import com.wanted.common.JDBCTemplate02;
import com.wanted.common.MenuDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application04 {

    /* comment. 금일 하부르타 시 과제
     *   1. 메뉴 전체 조회 값을 Java 객체로 옮겨담기
     *   2. EmployeeDB를 사용해서 각자 1개 이상의 DB 접속 및 반환
     */

    public static void main(String[] args) {

        // JDBCTemplate   -> jdbc-config.properties   (employeedb)
        // JDBCTemplate02 -> jdbc-config.properties02 (menudb)
        Connection empCon = JDBCTemplate.getConnection();
        Connection menuCon = JDBCTemplate02.getConnection();
        Statement st = null;
        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("ID를 입력해주세요 (200~222) : ");
        String empId = sc.nextLine();

        EmpDTO emp = null;

        List<MenuDTO> menuList = new ArrayList<>();

        try {
            /* 1. MenuDB 전체 조회 */
            st = menuCon.createStatement();
            rs = st.executeQuery("SELECT * FROM TBL_MENU");

            while (rs.next()) {
                MenuDTO menu = new MenuDTO();
                menu.setMenuCode(rs.getInt("MENU_CODE"));
                menu.setMenuName(rs.getString("MENU_NAME"));
                menu.setMenuPrice(rs.getInt("MENU_PRICE"));
                menu.setCategoryCode(rs.getInt("CATEGORY_CODE"));
                menu.setOrderableStatus(rs.getString("ORDERABLE_STATUS").charAt(0));
                menuList.add(menu);
            }
            for (MenuDTO menu : menuList) {
                System.out.println(menu);
            }

            JDBCTemplate02.close(rs);
            JDBCTemplate02.close(st);

            /* 2. EmployeeDB 사번으로 조회 */
            st = empCon.createStatement();
            rs = st.executeQuery("SELECT * FROM TBL_EMPLOYEE WHERE EMP_ID = '" + empId + "'");

            if (rs.next()) {
                emp = new EmpDTO();
                emp.setEmpId(rs.getInt("EMP_ID"));
                emp.setEmpName(rs.getString("EMP_NAME"));
                emp.setEmpNo(rs.getString("EMP_NO"));
                emp.setEmpEmail(rs.getString("EMAIL"));
                emp.setEmpPhone(rs.getString("PHONE"));
                emp.setEmpSalary(rs.getInt("SALARY"));
                emp.setEmpHiredate(rs.getDate("HIRE_DATE"));
                emp.setEmpEntdate(rs.getDate("ENT_DATE"));
                emp.setEmpEntyn(rs.getString("ENT_YN").charAt(0));
            }

            System.out.println("emp = " + emp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCTemplate.close(rs);
            JDBCTemplate.close(st);
            JDBCTemplate.close(empCon);
            JDBCTemplate02.close(menuCon);
        }
    }
}
