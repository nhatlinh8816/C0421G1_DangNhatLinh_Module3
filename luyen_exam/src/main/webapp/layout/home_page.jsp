<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/11/2021
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
    <title>Furama Resort Home Page</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
    <jsp:include page = "header.jsp"></jsp:include>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="right_list.jsp"></jsp:include>
            <jsp:include page="body.jsp"></jsp:include>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>

<script src="../js/bootstrap.min.js"></script>
</body>
</html>
