package com.bayi.servlet;

import com.bayi.entity.Goods;
import com.bayi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/selectOrdersServlet")
public class SelectOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询出数据后返回到前台
        req.setCharacterEncoding("utf-8");
        GoodsService goodsService = new GoodsService();
        List<Goods> goods = goodsService.selectDate();
        req.setAttribute("goods", goods);
        //因为request域中有数据，需要通过请求转发的方式跳转（重定向会丢失request域）

        req.getRequestDispatcher("html/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    }
}
