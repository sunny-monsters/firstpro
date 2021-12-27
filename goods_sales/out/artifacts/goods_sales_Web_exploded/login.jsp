<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
    <div class="layui-container" align="center">
        <div class="layui-col-md6">
            <div class="insert">
                <form action="/login" method="get">
                    <div>
                        <h2>图书销售管理系统</h2>
                        <span style="text-align: left"; text-indent: 0.4em;><label>用户名</label></span>
                        <span><input type="text" name="uName" id="uName" value="" class="textbox" autocomplete="off"></span>
                    </div>
                    <div>
                        <span style="text-align: left"; text-indent: 0.4em><label>密码</label></span>
                        <span><input type="password" name="uPassword" id="uPassword" value="" class="password"></span>
                    </div>
                    <div class="sign">
                        <input type="reset" class="layui-btn" value="重置">
                        <input type="submit" class="layui-btn layui-bg-blue" value="登录" class="submit">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript">
        layui.use(function () {
            var layer = layui.layer;

            layer.msg('Hello World');
        });
    </script>
</body>
</html>
