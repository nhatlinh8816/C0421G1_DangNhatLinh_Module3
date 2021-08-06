<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/6/2021
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Form</title>
</head>
<body>
    <p>
        <a href="/users"> Back to user list</a>
    </p>
    <form action="" method="post">
        <h3>Are you sure</h3>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["User"].getName()}</td>
            </tr>
            <tr>
                <td>Email </td>
                <td>${requestScope["User"].getEmail()}</td>
            </tr>
            <tr>
                <td>Country</td>
                <td>${requestScope["User"].getCountry()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete user"></td>
            </tr>
        </table>
        </fieldset>
    </form>
</body>
</html>
