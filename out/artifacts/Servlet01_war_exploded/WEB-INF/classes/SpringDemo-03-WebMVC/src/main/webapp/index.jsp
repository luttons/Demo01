<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
    <body>
    <h1> 测试 </h1>
    <br/>
    <a href="/myweb/user/test01"> 跳转到 /myweb/user/test01</a>

    <hr>
    <a href="/myweb/test01"> 跳转到 /myweb/test01</a>
    <hr>


    <form action="/myweb/test02" method="post">
        <input type="submit" value="这是 input 标签">
        <button > 这是button标签，写在 form里面和 input有相同的作用</button>
    </form>

    <hr>
    <a href="/myweb/test03?username=root&password=toor"> 跳转到test03</a>
    <hr>

    <hr>
    <a href="/myweb/test04?username=root&password=toor"> 跳转到test04</a>
    <hr>

    <hr>
    <a href="/myweb/test06?username=root&password=toor"> 跳转到test06</a>
    <hr>

    <hr>
    <a href="/myweb/test07"> 跳转到test07</a>
    <hr>


    <hr>
    <a href="/myweb/test08"> 跳转到test08</a>
    <hr>


    <hr>
    <a href="/myweb/test09"> 跳转到test09</a>
    <hr>


    <hr>
    <a href="/myweb/test10"> 跳转到test10</a>
    <hr>


    <hr>
    <a href="/myweb/test11"> 跳转到test11</a>
    <hr>

    <hr>
    <a href="/myweb/JsonTest.jsp"> 跳转到/myweb/JsonTest.jsp</a>
    <hr>

    <hr>
    <a href="/myweb/test12"> 跳转到test12</a>
    <hr>


    <hr>
    <a href="/myweb/test13"> 跳转到test13</a>
    <hr>


    <hr>
    <a href="/myweb/test14?username=root&password=toor"> 跳转到test14</a>
    <hr>


    <hr>
    <a href="/myweb/test15?username=root&password=toor"> 跳转到test15</a>
    <hr>



    <hr>
    <a href="/myweb/test16?username=root&password=toor"> 跳转到test16</a>
    <hr>



    <hr>
    <form action="/myweb/test17">
        <input type="checkbox" name="hobby" value="0"> 琴|
        <input type="checkbox" name="hobby" value="1"> 棋|
        <input type="checkbox" name="hobby" value="2"> 书|
        <input type="checkbox" name="hobby" value="3"> 画
        <button> 提交到/myweb/test17 </button>
    </form>
    <hr>

    <form action="/myweb/test18">
        <input type="hidden" name="userList[0].username" value="root">
        <input type="hidden" name="userList[0].password" value="toor">
        <input type="hidden" name="userList[1].username" value="admin">
        <input type="hidden" name="userList[1].password" value="nimda">
        <button> /myweb/test18 </button>
    </form>


    <script>
        var userList = new Array();
        userList.push({username:"lutton", password:"nottul"});
        userList.push({username:"root", password:"toor"});
        var userListData = JSON.stringify(userList);
        function method(){
            xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function (){
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    alert("请求成功！");
                }
            }

            xmlHttp.open("post", "/myweb/test19", true);
            xmlHttp.setRequestHeader("Content-type", "application/json");
            xmlHttp.send(userListData);
        }
    </script>
    <button onclick="method()"> 跳转到 /myweb/test19 </button>



    <hr>
    <a href="/myweb/test20?uname=root&pwd=toor"> 跳转到test20</a>
    <hr>



    <hr>
    <a href="/myweb/test21/lutton/nottul"> 跳转到test21</a>
    <hr>


    <hr>
    <a href="/myweb/test22"> 跳转到test22</a>
    <hr>


    <hr>
    <a href="/myweb/test23"> 跳转到test23</a>
    <hr>


    <hr>
    <a href="/myweb/test24?date=2023-9-22"> 跳转到test24</a>
    <hr>


<%--    单文件上传测试--%>
    <form action="/myweb/test25" method="post" enctype="multipart/form-data">
        <input type="text" name="username" placeholder="请输入用户名">
        <input type="file" name="uploadFile">
        <input type="submit" value="上传">
    </form>



<%--    多文件上传测试--%>
    <form action="/myweb/test26" method="post" enctype="multipart/form-data">
        <input type="text" name="username" placeholder="请输入用户名">
        <input type="file" name="uploadFiles" multiple>
        <input type="submit" value="上传">
    </form>



    </body>
</html>