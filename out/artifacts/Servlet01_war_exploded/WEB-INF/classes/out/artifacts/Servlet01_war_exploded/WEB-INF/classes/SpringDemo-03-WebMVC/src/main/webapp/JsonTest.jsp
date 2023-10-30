
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JsonTest 测试页面</title>

    <script>
        function getJson(){
           xmlHttp = new XMLHttpRequest();
           xmlHttp.onreadystatechange = function (){
               if (xmlHttp.readyState == 4 & xmlHttp.status == 200){
                   receiveJson = xmlHttp.responseText;  // 从相应的页面相应过来的数据
                   method(receiveJson);
               }
           }
            // 建立与服务器之间的连接，并发送一个GET请求，以获取服务器上的资源或数据。
            // 来打开一个GET请求，
            // ture 表示异步：不干扰其他页面的操作
           xmlHttp.open("get", "/myweb/test12", true);
            // 将上面的get请求发送给相应的 url
           xmlHttp.send();
        }

        function method(userJson){
            userJson = eval("(" + userJson + ")")
            alert(userJson.username + " : " + userJson.password);
        }
    </script>
</head>
<body>
    <h3>getJson and alert</h3>
    <hr>
    <button onclick="getJson()"> 点击测试 Json</button>
</body>
</html>
