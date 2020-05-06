package com.example.mydemo.User.utill;

import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

public class JdbcUtill {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties prop = new Properties();
        Reader in;
        try {
            in = new FileReader("src/main/resources/jdbc.properties");
            prop.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver = prop.getProperty("driver");
        url = prop.getProperty("url");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
    }

    public static Connection getConn() {
        try {
            // 类名反射 ， 获得DriverManager类
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
