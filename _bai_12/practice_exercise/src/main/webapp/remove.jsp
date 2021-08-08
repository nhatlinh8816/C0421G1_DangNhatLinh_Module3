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
<p>
    Do you want remove this user?
</p>
<form action="" method="post">
    <input type="hidden" name="actionClient" value="delete">
    <input type="hidden" name="UserId" value="${SelectUser.id}">
    <p>Name:</p>
    <input type="text" name="UserName" value="${SelectUser.name}">
    <p>Email</p>
    <input type="text" name="UserEmail"value="${SelectUser.email}">
    <p>Country</p>
    <input type="text" name="UserCountry"value="${SelectUser.country}">
    <input type="submit" value="remove">
</form>

</body>
</html>
