<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<input type="hidden" name="actionClient" value="create">
<h1>User Management</h1>
<h2>
    <a href="/users"> Back to user list</a>
</h2>
<div align="center">
    <form action="" name="actionClient" value="create" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New User</h2>
            </caption>
            <tr>
                <th>New User ID:</th>
                <td>
                    <input type="text" name="newId" id="newId" size="45" placeholder="Type new ID"/>
                </td>
            </tr>
            <tr>
                <th>New User Name:</th>
                <td>
                    <input type="text" name="newName" id="newName" size="45" placeholder="Type new Name"/>
                </td>
            </tr>
            <tr>
                <th>New User Email:</th>
                <td>
                    <input type="text" name="newEmail" id="newEmai" size="45" placeholder="Type new Email"/>
                </td>
            </tr>
            <tr>
                <th>New Country:</th>
                <td>
                    <input type="text" name="newCountry" id="newCountry" size="15" placeholder="Type new Country"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
