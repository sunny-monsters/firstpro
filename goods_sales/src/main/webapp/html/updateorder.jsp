<%@ page import="com.bayi.entity.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bayi.service.GoodsService" %><%--
  Created by IntelliJ IDEA.
  User: Insist and Endeavor
  Date: 2021-12-13
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/add.css">
    <link rel="stylesheet" href="../layui-v2.6.8/layui-v2.6.8/layui/css/layui.css">
    <script type="text/javascript" src="../layui-v2.6.8/layui-v2.6.8/layui/layui.js"></script>
</head>
<body>
<%
    String sub = request.getParameter("sub");
    List<Goods> goods = GoodsService.selectDateByOther("Sub", sub);
    String username = goods.get(0).getUserName();
    String address = goods.get(0).getAddress();
    String photo = goods.get(0).getPhoto();
%>
<div class="form_css">
    <form class="layui-form" action="/UpdateOrderServlet" method="get">
        <input type="text" style="display: none" name="sub" class="layui-input" value="<%=sub%>">
        <div class="layui-form-item">
            <label class="layui-form-label">订单号</label>
            <div class="layui-input-inline">
                <input type="text" disabled class="layui-input" value="<%=sub%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" id="uername" required  lay-verify="required" autocomplete="on" class="layui-input" value="<%=username%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-inline">
                <input type="text" name="address" required lay-verify="required" autocomplete="on" class="layui-input" value="<%=address%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
                <input type="text" name="photo" required lay-verify="required" autocomplete="on" class="layui-input" maxlength="11" value="<%=photo%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">支付方式</label>
            <div class="layui-input-block"  style="width: 250px;">
                <select name="payment" lay-search>
                    <option value="支付宝支付">支付宝支付</option>
                    <option value="微信支付">微信支付</option>
                    <<option value="其他">其他</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">运送方式</label>
            <div class="layui-input-block" style="width: 250px;">
                <select name="carry" lay-search>
                    <option value="申通快递">中通快递</option>
                    <option value="申通快递">申通快递</option>
                    <option value="圆通快递">圆通快递</option>
                    <option value="韵达快递">韵达快递</option>
                    <option value="顺丰快递">顺丰快递</option>
                    <option value="百世快递">百世快递</option>
                    <option value="天天快递">天天快递</option>
                    <option value="邮政包裹">邮政包裹</option>
                    <option value="其他">其他</option>
                </select>
            </div>
        </div>
        <div class="btn" style="margin-top: 15px">
            <input type="submit" value="提交" class="layui-btn">
            <input type="reset" value="重置" class="layui-btn">
        </div>
    </form>
    <script type="text/javascript">
        layui.use("form", function (){
            var form = layui.form;

            form.render();
        });

    </script>
</body>
</html>
