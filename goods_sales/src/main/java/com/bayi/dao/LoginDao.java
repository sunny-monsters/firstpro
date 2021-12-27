package com.bayi.dao;

import com.bayi.entity.Login;

import java.sql.*;

//模型层：用于处理登录（查询数据）
public class LoginDao {

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    static String url = "jdbc:mysql://localhost:3306/goods_sales";
    static String user = "root";
    static String pwd = "123456";

    public int login(Login login) {
        //boolean flag = false; //登录成功与否的标识
        int flag = -1;//-1 系统异常， 0 用户名或者密码错误 1 登陆成功
        int result = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);

            String sql = "select count(*) from user where username = ? and password = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, login.getUname());
            pstmt.setString(2, login.getUpwd());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            if (result > 0) {
                return 1;
            } else {
                return 0; // 登录失败（用户或密码有误）
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;//系统异常
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) pstmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
