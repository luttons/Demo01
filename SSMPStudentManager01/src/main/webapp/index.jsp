<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>系统首页</title>
</head>

<body>

<center>
    <h1>学生管理系统</h1>
    <hr>
    <a href="/myweb/selAll">浏览学生</a>
    <br>
    <a href="/myweb/edit.jsp?action=add">添加学生</a>
    <hr>
    <c:if test="${stuList != null}">
    <h3>浏览学生</h3>
        <hr width="80%">
        <table border="1px" width="80%">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>成绩</th>
                <th>电话</th>
                <th>班级</th>
                <td>操作</td>
            </tr>
<%--            <tr>--%>
<%--                <td>${stuList}</td>--%>
<%--            </tr>--%>
                <%--    model.addAttribute("stuList", stuList); 所以这边可以直接引用stuList--%>
            <c:forEach items="${stuList}" var="stu">
                <tr>
                    <td>${stu.id}</td>
                    <td>${stu.name}</td>
                    <td>${stu.sex}</td>
                    <td>${stu.age}</td>
                    <td>${stu.score}</td>
                    <td>${stu.tel}</td>
                    <td>${stu.classid}</td>
                    <td>
                        <a href="/myweb/edit?action=update&id=${stu.id}">编辑</a>
                        <a href="/myweb/delete?id=${stu.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</center>

</body>
</html>