<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/2/2021
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/discount_servlet" method="post">
    <p>Product Description</p>
    <input type="text" name="descriptionProduct">
    <p>List Price</p>
    <input type="text" name="listPrice">
    <p>Discount Percent</p>
    <input type="text" name="discountPercent">
    <input type="Submit" value="Discount Amount and Discount Price">
  </form>
  </body>
</html>
