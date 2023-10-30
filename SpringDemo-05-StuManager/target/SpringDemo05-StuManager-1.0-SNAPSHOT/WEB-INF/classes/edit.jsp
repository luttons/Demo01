<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑页面</title>
</head>
<script>
    if (request.getParameter("updates").equals("1"))
        alert("修改成功！");
</script>
<body>
<center>
    <%
        String info = "添加";
        String action = request.getParameter("action");
        if (action != null && action.equals("update")) {
            info = "更新";
        }
    %>
    <h1>学生管理系统</h1>
    <hr>
    <a href="/myweb/selAll">浏览学生</a>
    <a href="/myweb/edit.jsp?action=add">添加学生</a>
    <hr>
    <h3><%= info%>学生</h3>
    <hr>

    <form action="/myweb/<%= request.getParameter("action") %>?id=${stu.id}" method="post">
        <table border="0px" width="350px" height="300px">
            <tr>
                <td align="left">姓名：</td>
                <td><input type="text" name="name" placeholder="请输入学生的姓名" value="${stu.name}"></td>
            </tr>
            <tr>
                <td align="left" >性别：</td>
                <td>
                     男<input type="radio" name="sex" value="1">|
                     女<input type="radio" name="sex" value="0"> |
                     未知<input type="radio" name="sex" value="2">
                </td>
            </tr>
            <tr>
                <td align="left">年龄：</td>
                <td><input type="number" name="age" placeholder="请输入学生的年龄" value="${stu.age}"></td>
            </tr>
            <tr>
                <td align="left">成绩：</td>
                <td><input type="number" name="score" placeholder="请输入学生的成绩" value="${stu.score}"></td>
            </tr>
            <tr>
                <td align="left">电话：</td>
                <td><input type="text" name="tel" placeholder="请输入学生的电话" value="${stu.tel}"></td>
            </tr>
            <tr>
                <td align="left">班级：</td>
                <td><input type="text" name="classid" placeholder="请输入学生的班级" value="${stu.classid}"></td>
            </tr>
            <tr>
                <td align="left" colspan="2">
                    <input type="submit" value="<%= info%>">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
