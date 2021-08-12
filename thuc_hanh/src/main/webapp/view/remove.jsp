<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link
        rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <h1> Remove View </h1>
        <span>
            <a href="users?action=users">List All Users</a>
        </span>
    </div>
    <div>
        <form method="post">
            <table border="1">
                <tr>
                    <td>${userRemove.getId()}</td>
                </tr>
                <tr>
                    <td>${userRemove.getName()}</td>
                </tr>
                <tr>
                    <td>${userRemove.getEmail()}</td>
                </tr>
                <tr>
                    <td>${userRemove.getCountry()}</td>
                </tr>
            </table>
        </form>
    </div>
    <button onclick="onDelete()" type="button" class="btn btn-danger" data-toggle="modal" data-target="#modelId">Delete</button>
<%--    modal--%>
    <div class="modal" tabindex="-1" id="modelId" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Confirm Delete</h3>
                </div>
                <form method="post">
                    <input type="hidden" name="id" value="" id="userID">
                    <div class="modal-body">
                        <p>Are you sure delete ${userRemove.getName()}</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        function onDelete(id) {
            document.getElementById("userID").value = id;
        }
    </script>
</body>
</html>
