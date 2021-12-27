package com.bayi.servlet;

import com.bayi.entity.Goods;
import com.bayi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="/SelectOrdersByOtherServlet", urlPatterns = "/SelectOrdersByOtherServlet")
public class SelectOrderByOtherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String payment = req.getParameter("payment");
        String carry = req.getParameter("carry");
//        Map<String, String> map = new HashMap<>();
//        map.put("Username", username);
//        map.put("Address", address);
//        map.put("Payment", payment);
//        map.put("Carry", carry);
//        int count = 0;
//        for (int i = 0; i < map.size(); i++) {
//            if (map.get(i) != null) {
//                count = i;
//            }
//        }
//        if (count == 0) {
//            req.getRequestDispatcher("html/index.jsp").forward(req, resp);
//        } else {
//            GoodsService.selectDateByOther(, map.get(count));
//        }
        String[] value = {username, address, payment, carry};
        String[] key = {"Username", "Address", "Payment", "Carry"};
        String value_ = null;
        int count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i] != null) {
                value_ = value[i];
                count = i;
                break;
            }
        }
        if (value_ == null) {
            req.getRequestDispatcher("html/index.jsp").forward(req, resp);
        } else {
            List<Goods> goods = GoodsService.selectDateByOther(key[count], value_);
            req.setAttribute("goods", goods);
            req.getRequestDispatcher("html/index.jsp").forward(req, resp);
        }
    }
}
