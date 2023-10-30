<%--
  Created by IntelliJ IDEA.
  User: qyk
  Date: 2023/9/7
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test02</title>
</head>
<body>
    <h2>转发到 test02</h2>
    <hr>
    <p>我的名字是：<%= request.getAttribute("name")%> </p>
    <p>我的职业是：<%= request.getAttribute("job")%> </p>
</body>
</html>
