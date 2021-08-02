 <%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/2/2021
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h3 style="color: black">
    Describe Product:<%=request.getAttribute("descriptionProduct")%>
</h3>
<h3 style="color: blue">
    Discount Amount:<%=request.getAttribute("discountAmount")%>
</h3>
<h3 style="color: red">
    Discount Price:<%=request.getAttribute("discountPrice")%>
</h3>
</body>
</html>
