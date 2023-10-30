
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failed</title>
</head>
<body>
    <h1>Failed 页面</h1>
    <hr>
<%--    这是 el 表达式，一般用于 modelAndview   --%>
    <p>user = ${username}</p>

<%--    原生 JSP 的写法--%>
    <p>user = <%= request.getParameter("username") %></p>
</body>
</html>
