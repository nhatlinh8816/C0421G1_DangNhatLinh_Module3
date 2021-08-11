<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
<table class="table">
    <h2 class="text-center">List Of Customer</h2>
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Type</th>
        <th scope="col">Name</th>
        <th scope="col">Gender</th>
        <th scope="col">Code</th>
        <th scope="col">DOBr</th>
        <th scope="col">Identify</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="CustomerObj" items="${CustomerListServlet}">
        <tr>
            <td>
                <c:out value="${CustomerObj.idCustomer}"></c:out>
            </td>
            <td>
                <c:if test="${CustomerObj.typeCustomer==1}">
                    Diamond
                </c:if>
                <c:if test="${CustomerObj.typeCustomer==2}">
                    Platinum
                </c:if>
                <c:if test="${CustomerObj.typeCustomer==3}">
                    Gold
                </c:if>
                <c:if test="${CustomerObj.typeCustomer==4}">
                    Silver
                </c:if>
                <c:if test="${CustomerObj.typeCustomer==5}">
                    Member
                </c:if>
            </td>
            <td>
                <c:out value="${CustomerObj.nameCustomer}"></c:out>
            </td>
            <td>
                <c:if test="${CustomerObj.genderCustomer==0}">
                    Female
                </c:if>
                <c:if test="${CustomerObj.genderCustomer==1}">
                    Male
                </c:if>
            </td>
            <td>
                <c:out value="${CustomerObj.codeCustomer}"></c:out>
            </td>
            <td>
                <c:out value="${CustomerObj.dateOfBirthCustomer}"></c:out>
            </td>
            <td>
                <c:out value="${CustomerObj.identifyCodeCustomer}"></c:out>
            </td>
            <td>
                <c:out value="${CustomerObj.phoneNumberCustomer}"></c:out>
            </td>
            <td>
                <c:out value="${CustomerObj.emailCustomer}"></c:out>
            </td>
            <td>
                <c:out value="${CustomerObj.addressCustomer}"></c:out>
            </td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
    </c:forEach>

    <script src="../js/bootstrap.min.js"></script>
    </tbody>
</table>
</body>
</html>
