<%@ page import="java.util.List" %>
<%@ page import="com.bayi.entity.Goods" %>
<%@ page import="com.bayi.service.GoodsService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../layui/layui.js"></script>
</head>
<body>

    <div class="" style="margin: 50px auto; width: 700px; height: 700px">
        <table class="layui-table" lay-even>
            <colgroup>
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="100">
                <col width="200">
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
                <%
                    //(List<Goods>) request.getAttribute("Goods") 强制转换会导致数据丢失
                    List<Goods> goods = GoodsService.selectDate();
//                    List<Goods> goods = (List<Goods>) request.getAttribute("Goods");
                    for (Goods good : goods) {
                %>
                    <tr>
                        <td><%=good.getSub()%></td>
                        <td><%=good.getUserName()%></td>
                        <td><%=good.getsPate()%></td>
                        <td><%=good.getAddress()%></td>
                        <td><%=good.getPayment()%></td>
                        <td><%=good.getPhoto()%></td>
                        <td><%=good.getCarry()%></td>
                        <td><a href="/DeleteOrderServlet?sub=<%=good.getSub()%>">删除</a></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

        
    <script type="text/javascript">
        layui.use(function () {
            var layer = layui.layer;

            var flag = <%=request.getAttribute("flag")%>;
            if (flag) {
                layer.msg("删除成功")
            } else {
                layer.msg("删除失败")
            }
            //layer.msg("登录成功");
        });
    </script>
</body>
</html>
