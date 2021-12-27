<%--
  Created by IntelliJ IDEA.
  User: Insist and Endeavor
  Date: 2021-12-11
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body>

    <%-- 表格 --%>
    <a href="/servlet/SelectOrdersServlet" target="_blank">查询</a>
    <div class="" style="margin: 50px auto; width: 700px; height: 700px">
        <table class="layui-table" lay-even>
            <colgroup>
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="100">
            </colgroup>
            <thead>
            <tr>
                <th>订单号</th>
                <th>用户名</th>
                <th>订单生成时间</th>
                <th>地址</th>
                <th>支付方式</th>
                <th>电话号码</th>
                <th>运送方式</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <%
                %>
            </tr>
            </tbody>
        </table>
    </div>

        
    <script type="text/javascript">
        layui.use(function () {
            var layer = layui.layer;

            layer.msg("登录成功");
        });
    </script>
</body>
</html>
