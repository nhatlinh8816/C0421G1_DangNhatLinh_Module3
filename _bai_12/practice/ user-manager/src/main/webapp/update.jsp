<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/5/2021
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<h2>Update User</h2>
<p style="color: blueviolet">${msg}</p>
<form action="/users" method="post">
    <input type="hidden" name="actionClient" value="update">
    <input type="hidden" name="UserId" value="${User.id}">
    <p>Name:</p>
    <input type="text" name="UserName" value="${User.name}">
    <p>Email</p>
    <input type="text" name="UserEmail"value="${User.email}">
    <p>Country</p>
    <input type="text" name="UserCountry"value="${User.country}">
    <input type="submit" value="update">
</form>
</body>
</html>
