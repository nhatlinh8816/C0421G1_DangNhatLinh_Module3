<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/11/2021
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama Resort Home Page</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>
<body>
<jsp:include page = "../../layout/header.jsp"></jsp:include>
<jsp:include page="../../layout/navbar.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="../../layout/right_list.jsp"></jsp:include>
        <div class="col-lg-10">
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
                            <c:if test="${CustomerObj.genderCustomer}">
                                Male
                            </c:if>
                            <c:if test="${CustomerObj.genderCustomer==false}">
                                Female
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
                        <td><a href="/customers?actionClient=update&customerId=${CustomerObj.idCustomer}">Update</a></td>
<%--                        <td><a href="/customers?actionClient=delete&customerId=${CustomerObj.idCustomer}">Delete</a></td>--%>
                        <td>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop" onclick="deleteCustomer(${CustomerObj.idCustomer})">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p style="color: red;">${msg}</p>
        </div>
        </div>
    </div>
<%--    modal--%>
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Do you want delete
            </div>
            <form action="/customers" method="post">
                <input type="hidden" name="actionClient" value="delete">
                <input type="hidden" name="id" value="" id="idCustomer">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script>
    function deleteCustomer(id) {
        document.getElementById("idCustomer").value = id;
    }
    </script>
</body>
</html>
