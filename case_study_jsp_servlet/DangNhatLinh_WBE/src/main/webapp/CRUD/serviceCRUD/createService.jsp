<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/11/2021
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Form</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>
<body>
<jsp:include page = "../../layout/header.jsp"></jsp:include>
<jsp:include page="../../layout/navbar.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="../../layout/right_list.jsp"></jsp:include>
        <div class="col-lg-10">
            <div class="col-lg-12 text-center">
                <h2>Please input information</h2>
            </div>
            <form class="row g-3 mx-3" action="/service" method="post" >
                <input type="hidden" name="actionClient" value="create" >
                <div class="col-lg-12">
                    <label for="inputName" class="form-label">Name of Service</label>
                    <input type="text" class="form-control" id="inputName" name="newServiceName">
                </div>
                <div class="col-lg-6">
                    <label for="inputArea" class="form-label">Area</label>
                    <input type="text" class="form-control" id="inputArea" name="newServiceArea">
                </div>
                <div class="col-lg-6">
                    <label for="inputCost" class="form-label">Cost</label>
                    <input type="text" class="form-control" id="inputCost" name="newServiceCost">
                </div>
                <div class="col-lg-6">
                    <label for="inputPerson" class="form-label">Number Of Person</label>
                    <input type="text" class="form-control" id="inputPerson" name="newServicePerson">
                </div>
                <div class="col-lg-6">
                    <label for="inputType" class="form-label">Type of Rent </label>
                    <select id="inputType" class="form-select" name="newServiceTypeOfRent">
                        <option selected>Choose...</option>
                        <c:forEach items="${ServiceTypeRentList}" var="ServiceTypeRent">
                            <option value="${ServiceTypeRent.serviceTypeRentId}">${ServiceTypeRent.serviceTypeRentName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-6">
                    <label for="inputType1" class="form-label">Type of Service </label>
                    <select id="inputType1" class="form-select" name="newServiceTypeOfService">
                        <option selected>Choose...</option>
                        <c:forEach items="${ServiceTypeServiceList}" var="ServiceTypeService">
                            <option value="${ServiceTypeService.serviceTypeId}">${ServiceTypeService.serviceTypeName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-6">
                    <label for="inputStandard" class="form-label">Service Standard</label>
                    <input type="text" class="form-control" id="inputStandard" name="newServiceStandard">
                </div>
                <div class="col-lg-6">
                    <label for="inputDescription" class="form-label">Service Description</label>
                    <input type="text" class="form-control" id="inputDescription" name="newServiceDescription">
                </div>
                <div class="col-lg-6">
                    <label for="inputPoolArea" class="form-label">Service Pool Area</label>
                    <input type="text" class="form-control" id="inputPoolArea" name="newServicePoolArea">
                </div>
                <div class="col-lg-6">
                    <label for="inputFloor" class="form-label">Service Floor</label>
                    <input type="text" class="form-control" id="inputFloor" name="newServiceFloor">
                </div>
                <div class="col-lg-6">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </form>
        </div>
    </div>
    <jsp:include page="../../layout/footer.jsp"></jsp:include>
    <script src="../../js/bootstrap.min.js"></script>
</body>
</html>
