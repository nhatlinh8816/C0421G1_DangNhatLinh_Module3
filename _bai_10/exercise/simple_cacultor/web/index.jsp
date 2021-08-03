<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/3/2021
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple Caculator</h1>
  <form action="/calculator" method="post">
    <p>First operand:</p>
    <input type="text" name="numberOne">
    <p>Operator</p>
    <select name="Operator" id="">
      <option value="addition">Addition</option>
      <option value="subtraction">Subtraction</option>
      <option value="multiplication">Multiplication</option>
      <option value="divide">Divide</option>
    </select>
    <p>Second operand:</p>
    <input type="text" name="numberTwo">
    <input type="Submit" value="Result">
  </form>
  </body>
</html>
