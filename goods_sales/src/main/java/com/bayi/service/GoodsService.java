package com.bayi.service;

import com.bayi.dao.GoodsDao;
import com.bayi.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public class GoodsService {
    private static GoodsDao goodsDao = new GoodsDao();
    public static boolean deleteDateBySub(String sub) {
        try {
            if (goodsDao.isExist(sub) < 0) {
                return false;
            }
            goodsDao.deleteOrder(sub);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean addDate(Goods goods) {
        String sub_time = Time_.getRandomTime();
        String username = goods.getUserName();
        String sPate = Time_.getTime();
        String address = goods.getAddress();
        String payment = goods.getPayment();
        String photo = goods.getPhoto();
        String carry = goods.getCarry();

        try {
            int count = goodsDao.addOrder(sub_time, username, sPate, address, payment, photo, carry);
            if (count < 0) {
                return false;
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean UpdateDate(String sub, Goods goods) {
        String username = goods.getUserName();
        String address = goods.getAddress();
        String payment = goods.getPayment();
        String photo = goods.getPhoto();
        String carry = goods.getCarry();

        try {
            if (goodsDao.isExist(sub) < 0) {
                return false;
            }
            int count = goodsDao.updateOrder(username, address, payment, photo, carry, sub);
            if (count < 0) {
                return false;
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static List<Goods> selectDate() {
        return goodsDao.selectOrder();
    }

    public static List<Goods> selectDateByOther(String field, String value) {
        String goodsField = null;
        String[] str = {"Sub","Username","Spate","Address","Payment","Photo","Carry"};
        for (int i = 0; i < str.length; i++) {
            if (field.equals(str[i])) {
                goodsField = str[i];
            }
        }
        if (goodsField == null) {
            return null;
        }
        return goodsDao.selectOrderByOther(goodsField, value);
    }

}
