<%--
  Created by IntelliJ IDEA.
  User: qyk
  Date: 2023/9/7
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test01</title>
</head>


<%--     <% .... %>   ------> 写Java代码 (执行标签)                 --%>
<%--     <%= .... %>  ------>  取到相应变量的值(输出标签)                                 --%>

<body>
    <h2>test01 测试</h2>
    <hr>
    <select name="" id="">
<%--        <option value="">1</option>--%>
<%--        <option value="">2</option>--%>
<%--        <option value="">3</option>--%>
<%--        <option value="">4</option>--%>
<%--    这样就相当于写进去了一个 for 循环，总共会有10个option标签--%>
        <% for (int i = 0; i < 10; i++) {%>
    <option value="<%= i %>"> 学生 <%= i %></option>
        <% } %>
    </select>
</body>
</html>
