<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-28
  Time: 오후 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
    <h1>Register Page</h1>
    <form action="/register" method="post">
        <div>
            <input type="text" name="mid" id="mid" placeholder="ID"/>
        </div>
        <div>
            <input type="text" name="mname" id="mname" placeholder="NAME">
        </div>
        <div>
            <input type="password" name="mpw" id="mpw" placeholder="PASSWORD"/>
        </div>
        <div>
            <button type="submit">REGISTER</button>
        </div>
    </form>
</body>
</html>
