package com.bayi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bayi.entity.Goods;
import com.mysql.jdbc.Driver;

public class GoodsDao {

    private static final String URL = "jdbc:mysql://localhost:3306/goods_sales?useUnicode=true&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PWD = "123456";
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    private static int executeDML(String sql, Object... objs) throws SQLException {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PWD);
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                pstmt.setObject(i+1, objs[i]);
            }
            count = pstmt.executeUpdate();
            return count;

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println("SQL语句错误");
            return -1;
        } finally {
            if (con != null)  con.close();
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
        }
    }

    private static List<Goods> executeSelect(String sql, Object... objs) {
        List<Goods> list = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PWD);

            pstmt = con.prepareStatement(sql);
            if (sql.indexOf("like") > 0) {
                pstmt.setObject(1, "%"+objs[0]+"%");
                rs = pstmt.executeQuery();
            } else {
                for (int i = 0; i < objs.length; i++) {
                    pstmt.setObject(i+1, objs[i]);
                }
                rs = pstmt.executeQuery();
            }

            while (rs.next()) {
                Goods goods = new Goods();
                goods.setSub(rs.getString("Sub"));
                goods.setUserName(rs.getString("Username"));
                goods.setsPate(rs.getDate("Spate"));
                goods.setAddress(rs.getString("Address"));
                goods.setPayment(rs.getString("Payment"));
                goods.setPhoto(rs.getString("Photo"));
                goods.setCarry(rs.getString("Carry"));
                list.add(goods);
            }
            if (con != null) con.close();
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("类加载失败");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int addOrder(Object... objs) throws SQLException {
        String sql = "insert into goods_sub(Sub, Username, Spate, Address, Payment, Photo, Carry) value (?,?,?,?,?,?,?)";
        int count = executeDML(sql, objs);
        return count;
    }

    //删除数据
    public int deleteOrder(String sub) throws SQLException {
        String sql = "delete from goods_sub where Sub = ?";
        int count = executeDML(sql, sub);
        return count;
    }

    //找订单号
    public int isExist(String sub) throws SQLException {
        String sql = "select Sub from goods_sub where Sub = ?";
        int count = 0;
        if (executeSelect(sql, sub) != null) {
            count = 1;
        }
        return count;
    }

    //查询数据
    public static List<Goods> selectOrder() {
        String sql = "select * from goods_sub";
        List lists = executeSelect(sql);
        System.out.println(lists);
        return lists;
    }

    //查询指定数据

    //存在错误
    public List<Goods> selectOrderByOther(String field, String value) {
        String sql = "select * from goods_sub where " + field + " like ?"; //第一个问号是字段，第二个问号是数据库中的数值
        List lists = executeSelect(sql, value);
        return lists;
    }

    //更新数据
    public int updateOrder(Object... objs) throws SQLException {
        String sql = "update goods_sub set Username = ?, Address = ?, Payment = ?, Photo = ?, Carry = ? where Sub = ?";
        int count = executeDML(sql, objs);
        return count;
    }

    public static void main(String[] args) {
        selectOrder();
    }
}
