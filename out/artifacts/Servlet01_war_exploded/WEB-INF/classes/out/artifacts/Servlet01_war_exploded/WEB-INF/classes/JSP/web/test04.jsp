<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lutton.controller.global.Student" %><%--
  Created by IntelliJ IDEA.
  User: qyk
  Date: 2023/9/8
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test04</title>
</head>
<body>
    <center>
        <h2>显示学生信息</h2>
        <hr>
        <table border="1px">
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>成绩</th>
            </tr>
<%--            <tr>--%>
<%--                <%--%>
<%--                ArrayList<Student> stuList = (ArrayList<Student>) request.getAttribute("stuList");--%>
<%--                for (Student student : stuList) { %>--%>

<%--                <tr>--%>
<%--                    <td><%= student.getName()%></td>--%>
<%--                    <td><%= student.getSex()%></td>--%>
<%--                    <td><%= student.getAge()%></td>--%>
<%--                    <td><%= student.getScore()%></td>--%>
<%--                </tr>--%>
<%--                <%}%>--%>
<%--            </tr>--%>

<%--            JSTL写法(需要导入两个jar包)--%>
             <c:forEach items="${requestScope.stuList}" var="stu">
                 <tr>
                     <td>${stu.name}</td>
                     <td>${stu.sex}</td>
                     <td>${stu.age}</td>
                     <td>${stu.score}</td>
                 </tr>
             </c:forEach>
        </table>
    </center>
</body>
</html>
