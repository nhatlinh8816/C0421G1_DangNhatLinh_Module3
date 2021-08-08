<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View user</title>
</head>
<body>
<h1>User details</h1>
<p>
    <a href="/users">Back to user list</a>
</p>
<table><tr>
    <td>Id: </td>
    <td>${SelectUser.id}</td>
</tr>
    <tr>
        <td>Name: </td>
        <td>${SelectUser.name}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${SelectUser.email}</td>
    </tr>
    <tr>
        <td>Country: </td>
        <td>${SelectUser.country}</td>
    </tr>
</table>
</body>
</html>
