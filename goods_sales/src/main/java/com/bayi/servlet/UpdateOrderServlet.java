package com.bayi.servlet;

import com.bayi.entity.Goods;
import com.bayi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/UpdateOrderServlet", urlPatterns = "/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String sub = req.getParameter("sub");
        String username = req.getParameter("username");
        String address = req.getParameter("address");
        String photo = req.getParameter("photo");
        String payment = req.getParameter("payment");
        String carry = req.getParameter("carry");
        System.out.println(sub + " " + username + "  " + address + " " + photo + " " + payment + " " + carry);


        List<Goods> goods = GoodsService.selectDateByOther("Sub", sub);
        System.out.println(goods);
        Goods good1 = goods.get(0);
        good1.setUserName(username);
        good1.setAddress(address);
        good1.setPhoto(photo);
        good1.setPayment(payment);
        good1.setCarry(carry);

        boolean flag = GoodsService.UpdateDate(sub, good1);

        if (flag) {
            System.out.println("更新成功");
            req.getRequestDispatcher("/selectOrdersServlet").forward(req, resp);
        } else {
            System.out.println("更新失败");
            req.setAttribute("flag", flag);
            req.getRequestDispatcher("/selectOrdersServlet").forward(req, resp);
        }

        //req.getRequestDispatcher("/html/updateorder.jsp").forward(req, resp);
    }
}
