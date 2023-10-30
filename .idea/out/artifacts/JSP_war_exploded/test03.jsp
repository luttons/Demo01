<%--
  Created by IntelliJ IDEA.
  User: qyk
  Date: 2023/9/8
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test03</title>
</head>
<body>
  <h2>JSP 的常用对象</h2>
  <hr>

<%--  通过 Jsp 设置属性--%>
  <%
    request.setAttribute("reqTest", "请求测试对象");
    session.setAttribute("sessionTest", "Session测试对象");
    application.setAttribute("applicationTest", "application测试对象");  // 全局作用域对象
//    作用域只在当前页面里面,换个页面就失效了
    pageContext.setAttribute("pageContextTest", "pageContext测试对象"); // 页面数据
  %>

<%--  通过 jsp 获取相应的属性--%>
  <p>request : <%= request.getAttribute("reqTest")%></p>
  <p>session : <%= session.getAttribute("sessionTest")%></p>
  <p>application : <%= application.getAttribute("applicationTest")%></p>
  <p>pageContext : <%= pageContext.getAttribute("pageContextTest")%></p>
  <p>out : <%out.print("我是通过jsp中的out输出流来输出的");%></p>
  <p>out : 我是直接写在p标签里的内容,和out输出流的作用一模一样</p>

<%--  通过 EL 来读取作用域对象中的数据(tomcat自带)--%>
<%--  ${作用域对象名.共享数据}--%>
<%--  完整写法--%>
  <hr>
  <p>request: ${requestScope.reqTest}</p>
  <p>session: ${sessionScope.sessionTest}</p>
  <p>application: ${applicationScope.applicationTest}</p>
  <p>pageContext: ${pageScope.pageContextTest}</p>


<%--   EL 简化写法.  作用域对象名可以省略不写--%>
  <hr>
  <p>request: ${reqTest}</p>
  <p>session: ${sessionTest}</p>
  <p>application: ${applicationTest}</p>
  <p>pageContext: ${pageContextTest}</p>
  <hr>


  <p> 简化写法下,如果重名的优先级: pageContext --- request --- session --- application</p>
  <%
    request.setAttribute("valueTest", "request测试值");
    session.setAttribute("valueTest", "session测试值");
    application.setAttribute("valueTest", "application测试值");
  %>
  <p>${valueTest}</p>

</body>
</html>
