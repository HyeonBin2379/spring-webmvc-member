<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Member List Page</title>
</head>
<body>
    <h1>Member List Page</h1>
    <ul>
        <c:forEach var="member" items="${memberList}">
            <li>${member.mid} ${member.mname} ${member.mpw}</li>
        </c:forEach>
    </ul>
</body>
</html>
