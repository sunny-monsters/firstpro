<%--
  Created by IntelliJ IDEA.
  User: Insist and Endeavor
  Date: 2021-12-13
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加数据</title>
    <link rel="stylesheet" href="/css/add.css">
    <link rel="stylesheet" href="../layui-v2.6.8/layui-v2.6.8/layui/css/layui.css">
    <script type="text/javascript" src="../layui-v2.6.8/layui-v2.6.8/layui/layui.js"></script>
</head>
<body>
<div class="form_css">
    <form class="layui-form" action="/addOrder">
        <a href="/selectOrdersServlet" class="layui-btn cancel">取消添加</a>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" id="uername" required  lay-verify="required" autocomplete="on" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-inline">
                <input type="text" name="address" required lay-verify="required" autocomplete="on" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
                <input type="text" name="photo" required lay-verify="required" autocomplete="on" class="layui-input" maxlength="11">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">支付方式</label>
            <div class="layui-input-block"  style="width: 250px;">
                <select name="payment" lay-search>
                    <option value="支付宝支付">支付宝支付</option>
                    <option value="微信支付">微信支付</option>
                    <option value="其他">其他</option>
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
        <div class="btn">
            <input type="submit" value="提交" class="layui-btn">
            <input type="reset" value="重置" class="layui-btn">
        </div>
    </form>
</div>

    <script type="text/javascript">
        layui.use("form", function (){
            var form = layui.form;

            form.render();
        });

    </script>
</body>
</html>
