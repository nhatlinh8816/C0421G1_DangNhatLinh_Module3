<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/8/2021
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--tao 1 list de hien thi du lieu tu servlet --%>
<html>
<head>
    <title>User List by Country</title>
</head>
<body>
<h2>User List Order By Name</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
    </tr>
    <c:forEach var="UserObj" items="${UserListServletOrderByName}">
        <tr>
            <td>
                <c:out value="${UserObj.id}"></c:out>
            </td>
            <td>
                <a href="/users?actionClient=view&userId=${UserObj.id}"><c:out value="${UserObj.name}"></c:out></a>
            </td>
            <td>
                <c:out value="${UserObj.email}"></c:out>
            </td>
            <td>
                <c:out value="${UserObj.country}"></c:out>
            </td>
        </tr>
    </c:forEach>
    <p>
        <a href="/users">Back to user list</a>
    </p>


</table>
</body>
</html>
