package com.example.mydemo.Jdbc;

import com.example.mydemo.User.utill.JdbcUtill;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

    @Test
    public void testinsert() {

        Connection conn = null;
        Statement st = null;

        try {
            // 创建连接
            conn = JdbcUtill.getConn();
            // 根据连接对象 ， 得到 statement 操作数据库
            st = conn.createStatement();

            // 先插入 ， id=5存在 再更新
            String sql = "insert into user values(5,'love_u')";

            int rs = st.executeUpdate(sql);

            //影响的行数 ， 如果大于0 表明操作成功 , 否则失败
            if (rs > 0) {
                System.out.println("执行成功！");
            } else {
                System.out.println("执行失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtill.release(conn, st, null);
        }

    }

    @Test
    public void testUpdate() {

        Connection conn = null;
        Statement st = null;

        try {
            // 创建连接
            conn = JdbcUtill.getConn();
            // 根据连接对象 ， 得到 statement 操作数据库
            st = conn.createStatement();

            // 先插入 ， id=5存在 再更新
            String sql = "update user set id = 5, text = 'fuck_u' where id = 5";

            int rs = st.executeUpdate(sql);

            //影响的行数 ， 如果大于0 表明操作成功 , 否则失败
            if (rs > 0) {
                System.out.println("执行成功！");
            } else {
                System.out.println("执行失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtill.release(conn, st, null);
        }

    }

    @Test
    public void testdelete() {
        Connection conn = null;
        Statement st = null;

        try {
            // 创建连接
            conn = JdbcUtill.getConn();
            // 根据连接对象，得到statement操作数据库
            st = conn.createStatement();

            String sql = "delete from user where id = 5";
            int rs = st.executeUpdate(sql);

            // 影响的行数 , 如果大于0 表明操作成功 , 否则失败
            if (rs > 0) {
                System.out.println("执行成功！");
            } else {
                System.out.println("执行失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JdbcUtill.release(conn, st, null);
        }

    }

    @Test
    public void testquery() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // 创建连接
            conn = JdbcUtill.getConn();
            // 获得statement操作数据库
            st = conn.createStatement();

            String sql = "select * from user";

            rs = st.executeQuery(sql);

            //返回类型
            System.out.println(rs + "\n");

            //遍历结果
            while (rs.next()) {
                int id = rs.getInt("id");
                String text = rs.getString("text");
                System.out.println(id + " - " + text);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtill.release(conn, st, rs);
        }

    }

}