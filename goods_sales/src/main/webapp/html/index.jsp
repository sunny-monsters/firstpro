<%@ page import="java.util.List" %>
<%@ page import="com.bayi.entity.Goods" %>
<%@ page import="com.bayi.service.GoodsService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="/css/index.css">
    <script type="text/javascript" src="../layui-v2.6.8/layui-v2.6.8/layui/layui.js"></script>
</head>
<body>
<div class="title">
    <h1>订 单 管 理 系 统</h1>
</div>
<div class="search bar1">
    <div class="text">
        <input type="text" id="username" value="" placeholder="按照用户名查询"/>
        <button type="button" onclick="window.location.href='/SelectOrdersByOtherServlet?username=' + document.getElementById('username').value">搜 索</button>
    </div>
    <div class="text">
        <input type="text" id="address" value="" placeholder="按照地址查询"/>
        <button type="button" onclick="window.location.href='/SelectOrdersByOtherServlet?address=' + document.getElementById('address').value">搜 索</button>
    </div>
    <div class="text">
        <input type="text" id="payment" value="" placeholder="按照支付方式查询"/>
        <button type="button" onclick="window.location.href='/SelectOrdersByOtherServlet?payment=' + document.getElementById('payment').value">搜 索</button>
    </div>
    <div class="text" style="margin-right: 0">
        <input type="text" id="carry" value="" placeholder="按照配送方式查询"/>
        <button type="button" onclick="window.location.href='/SelectOrdersByOtherServlet?carry=' + document.getElementById('carry').value">搜 索</button>
    </div>
    <div class="add text"><a href="/html/addorder.jsp">添加</a></div>
</div>

<table width="90%" id="mytab"  border="1" class="table_css">
    <thead>
    <th width="10%">订单号</th>
    <th width="10%">用户名</th>
    <th width="10%">订单生成时间</th>
    <th width="10%">地址</th>
    <th width="10%">支付方式</th>
    <th width="10%">电话号码</th>
    <th width="10%">运送方式</th>
    <th width="10%">操作</th>
    </thead>
    <c:forEach items="${goods}" var="goods">
        <tr class="tr_css">
            <td>${goods.sub}</td>
            <td>${goods.userName}</td>
            <td>${goods.sPate}</td>
            <td>${goods.address}</td>
            <td>${goods.payment}</td>
            <td>${goods.photo}</td>
            <td>${goods.carry}</td>
            <td>
                <a href="/html/updateorder.jsp?sub=${goods.sub}" id="update">更新</a>
                <a href="/DeleteOrderServlet?sub=${goods.sub}" id="delete">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

    <script type="text/javascript">
        layui.use(function () {
            var layer = layui.layer;
            var del = document.getElementById("delete");
            del.onclick = function () {
                var flag = <%=request.getAttribute("flag")%>
                if(flag) {
                    layer.msg("删除成功");
                } else {
                    layer.msg("删除失败");
                }
            }
        });
    </script>
</body>
</html>
