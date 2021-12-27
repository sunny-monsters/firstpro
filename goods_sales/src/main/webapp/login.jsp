<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <form action="/login" class="login">
        <p>Login</p>
        <input type="text" placeholder="用户名" name="uName">
        <input type="password" placeholder="密码" name="uPassword">
        <input type="submit" class="btn" value="登 录">
        <input type="reset" class="btn" value="重 置">
    </form>
</body>
</html>
