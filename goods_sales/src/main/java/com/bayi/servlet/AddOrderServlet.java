package com.bayi.servlet;

import com.bayi.entity.Goods;
import com.bayi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

@WebServlet(name = "/addOrder", urlPatterns = "/addOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String photo = req.getParameter("photo");
        String payment = req.getParameter("payment");
        String carry = req.getParameter("carry");
        System.out.println(username + "  " + address + " " + photo + " " + payment + " " + carry);

        Goods goods = new Goods();
        goods.setUserName(username);
        goods.setAddress(address);
        goods.setPhoto(photo);
        goods.setPayment(payment);
        goods.setCarry(carry);

        Boolean flag = GoodsService.addDate(goods);
        if (flag) {
            System.out.println("添加成功");
            req.getRequestDispatcher("/selectOrdersServlet").forward(req, resp);
        } else {
            System.out.println("添加失败");
            req.setAttribute("flag", flag);
            req.getRequestDispatcher("html/index.jsp").forward(req, resp);
        }
    }
}
