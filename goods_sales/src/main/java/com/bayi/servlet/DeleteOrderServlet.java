package com.bayi.servlet;

import com.bayi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/DeleteOrderServlet", urlPatterns = "/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        //接收前端传来的学号
        String sub = req.getParameter("sub");
        System.out.println(sub);
        boolean flag = GoodsService.deleteDateBySub(sub);
        if (flag) {
            System.out.println("删除成功");
            req.setAttribute("flag", flag);

            req.getRequestDispatcher("/selectOrdersServlet").forward(req, resp);
            //resp.sendRedirect("/selectOrdersServlet");
        } else {
            System.out.println("删除失败");
            req.setAttribute("flag", flag);
            req.getRequestDispatcher("html/index.jsp").forward(req, resp);
            //resp.sendRedirect("html/index.jsp");
        }
    }
}
