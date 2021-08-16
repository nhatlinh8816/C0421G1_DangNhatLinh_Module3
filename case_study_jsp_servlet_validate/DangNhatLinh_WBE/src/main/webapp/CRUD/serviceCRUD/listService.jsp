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
    <title>Service List</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>
<body>
<jsp:include page = "../../layout/header.jsp"></jsp:include>
<jsp:include page="../../layout/navbar.jsp"></jsp:include>
<div class="container-fluid ">
    <div class="row">
        <jsp:include page="../../layout/right_list.jsp"></jsp:include>
        <div class="col-lg-10 ">
            <table class="table text-center">
                <h2 class="text-center">List Of Service</h2>
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Area</th>
                    <th scope="col">Cost</th>
                    <th scope="col">Number Person</th>
                    <th scope="col">Type Of Rent</th>
                    <th scope="col">Type of Service</th>
                    <th scope="col">Standard</th>
                    <th scope="col">Description</th>
                    <th scope="col">Pool Area</th>
                    <th scope="col">Floor</th>
                    <th scope="col" colspan="2" class="text-center">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ServiceObj" items="${ServiceList}">
                    <tr>
                        <td>
                            <c:out value="${ServiceObj.id}"></c:out>
                        </td>
                        <td>
                            <c:out value="${ServiceObj.name}"></c:out>
                        <td>
                            <c:out value="${ServiceObj.area}"></c:out>
                        </td>
                        <td>
                            <c:out value="${ServiceObj.cost}"></c:out>
                        </td>
                        <td>
                            <c:out value="${ServiceObj.numberPerson}"></c:out>
                        </td>
                        <td>
                            <c:if test="${ServiceObj.typeOfRentId==1}">
                                Năm
                            </c:if>
                            <c:if test="${ServiceObj.typeOfRentId==2}">
                               Tháng
                            </c:if>
                            <c:if test="${ServiceObj.typeOfRentId==3}">
                                Ngày
                            </c:if>
                            <c:if test="${ServiceObj.typeOfRentId==4}">
                                Giờ
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${ServiceObj.typeOfServiceId==1}">
                                Villa
                            </c:if>
                            <c:if test="${ServiceObj.typeOfServiceId==2}">
                                House
                            </c:if>
                            <c:if test="${ServiceObj.typeOfServiceId==1}">
                                Room
                            </c:if>
                        </td>
                        <td>
                            <c:out value="${ServiceObj.standard}"></c:out>
                        </td>
                        <td>
                            <c:out value="${ServiceObj.description}"></c:out>
                        </td>
                        <td>
                            <c:out value="${ServiceObj.poolArea}"></c:out>
                        </td>
                        <td>
                            <c:out value="${ServiceObj.floor}"></c:out>
                        </td>
                        <td>
                            <a class="btn btn-primary" href="/service?actionClient=update&serviceId=${ServiceObj.name}" role="button">Update</a>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#staticBackdrop" onclick="deleteService('${ServiceObj.id}','${ServiceObj.name}}')">
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
                Do you want delete <input id="name" style="border: none;outline: none ; color: red">
            </div>
            <form action="/service" method="post">
                <input type="hidden" name="actionClient" value="delete">
                <input type="hidden" name="id" value="" id="idService">
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
    function deleteService(id,name) {
        document.getElementById("idService").value = id;
        document.getElementById("name").value = name;
    }
</script>
</body>
</html>
