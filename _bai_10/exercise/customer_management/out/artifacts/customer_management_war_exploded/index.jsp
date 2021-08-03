<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/3/2021
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Customer List</title>
  </head>
  <body>
  <h1 style="text-align: center">Danh sách khách hàng</h1>
  <table border="1" style="text-align: center;alignment: center"  >
    <tr>
      <th>Số thứ tự</th>
      <th>Mã ID</th>
      <th>Tên</th>
      <th>Ngày sinh</th>
      <th>Địa chỉ</th>
      <th>Ảnh</th>
    </tr>
<%--    duyệt phần tử từ customer List--%>
    <c:forEach var="customerObj" items="${customerListServlet}" varStatus="loop">
<%--      mỗi một khác hàng là 1 record tương ứng với 1 tr, mỗi thuộc tính là 1 td--%>
      <tr>
        <td><c:out value="${loop.count}"></c:out></td>
        <td><c:out value="${customerObj.id}"></c:out></td>
        <td><c:out value="${customerObj.name}"></c:out></td>
        <td><c:out value="${customerObj.dateOfBirth}"></c:out></td>
        <td><c:out value="${customerObj.address}"></c:out></td>
        <td><img src="<c:url value="${customerObj.imageFilePath}"></c:url> "></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
