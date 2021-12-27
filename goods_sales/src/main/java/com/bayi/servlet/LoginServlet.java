package com.bayi.servlet;

import com.bayi.dao.LoginDao;
import com.bayi.entity.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//控制器层：接受view请求，并且分发Model处理
@WebServlet(name = "/login", urlPatterns = "/login") //通过前端action，返回到LoginServlet控制类中
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理登录
        req.setCharacterEncoding("utf-8");
        String uname = req.getParameter("uName");
        String pwd = req.getParameter("uPassword");

        Login login = new Login(uname, pwd);
        LoginDao loginDao = new LoginDao();

        //调用模型层的 登录功能
        int result = loginDao.login(login);
        if (result > 0) {
            resp.sendRedirect("/selectOrdersServlet"); //成功则跳转到index.jsp
        } else {
            resp.sendRedirect("login.jsp");
            System.out.println("登录失败，接着跳转"); //失败则继续进行登录
        }
    }


}

