package com.wanted.a_statements;

import com.wanted.common.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.wanted.common.JDBCTemplate.close;
import static com.wanted.common.JDBCTemplate.getConnection;

public class Application05 {
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 입력 : ");
        int empId = sc.nextInt(); //int empId = Integer.parseInt(sc.nextLine());

        EmployeeDTO employee = null;

        try {
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT * FROM TBL_EMPLOYEE WHERE EMP_ID = '" + empId + "'");

            if (rset.next()) {
                employee = new EmployeeDTO();

                employee.setEmpId(rset.getInt("EMP_ID"));
                employee.setEmpName(rset.getString("EMP_NAME"));
                employee.setEmpNo(rset.getString("EMP_NO"));
                employee.setEmail(rset.getString("EMAIL"));
                employee.setPhone(rset.getString("PHONE"));
                employee.setEntDate(rset.getDate("ENT_DATE"));

            }

            System.out.println("employee = " + employee);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(rset);
            close(stmt);
        }
    }
}
