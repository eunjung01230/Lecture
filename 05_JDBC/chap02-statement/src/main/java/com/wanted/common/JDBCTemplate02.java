package com.wanted.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate02 {

    // 해당 클래스의 역할
    // Connection 객체를 생성하는 코드를 메서드화
    // Connection 객체의 자원을 해제하는 코드를 메서드화

    public static Connection getConnection() {
        Connection con = null;

        Properties prop = new Properties();

        try {

            prop.load(new FileReader("src/main/java/com/wanted/config/jdbc-config.properties02"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);

            con = DriverManager.getConnection(
                    url,user,password
            );

            System.out.println("prop = " + prop);
            System.out.println("con = " + con);

        }  catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    // 사용한 Connection 객체를 해제하는 메서드
    public static void close(Connection con) {

        // 커넥션이 존재하거나, 닫혀 있지 않다면
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 사용한 Statement 객체를 해제하는 메서드
    public static void close(Statement stmt) {

        // 커넥션이 존재하거나, 닫혀 있지 않다면
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 사용한 ResultSet 객체를 해제하는 메서드
    public static void close(ResultSet rset) {

        // 커넥션이 존재하거나, 닫혀 있지 않다면
        try {
            if (rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
