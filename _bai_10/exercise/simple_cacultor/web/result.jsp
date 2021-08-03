<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/3/2021
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result</h1>
<p><%=request.getAttribute("numberOne")%>
<%=request.getAttribute("Subtend")%>
<%=request.getAttribute("numberTwo")%>
=
<%=request.getAttribute("Result")%></p>
</body>
</html>
