<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<center>
    <h1>登陆页面</h1>
    <hr>
    <form action="/myweb/login" method="post">
        <table>
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="text" name="username" placeholder="请输入用户名">
                </td>
            </tr>
            <tr>
                <td align="right">密码:</td>
                <td>
                    <input type="password" name="password" placeholder="请输入密码">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="登录"> |
                    <input type="reset">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
