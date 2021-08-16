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
            <form class="row g-3 mx-3" action="/customers" method="post" >
                <input type="hidden" name="actionClient" value="create" >
                <div class="col-lg-8">
                    <label for="inputName" class="form-label">Name of Customer</label>
                    <input type="text" class="form-control" id="inputName" name="newCustomerName">
                    <c:if test="${map.get('name')!=null}">
                        ${map.get('name')};
                    </c:if>
                </div>
                <div class="col-lg-6">
                    <label for="inputGender" class="form-label">Gender</label>
                    <select id="inputGender" class="form-select" name="newCustomerGender">
                        <option selected>Choose...</option>
                        <option value=true>Male</option>
                        <option value=false>Female</option>
                    </select>
                </div>
                <div class="col-lg-6">
                    <label for="inputType" class="form-label">Type Custormer </label>
                    <select id="inputType" class="form-select" name="newCustomerType">
                        <option selected>Choose...</option>
                        <c:forEach items="${CustomerTypeList}" var="customerType">
                            <option value="${customerType.idCustomerType}">${customerType.nameCustomerType}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-6">
                    <label for="inputDOB" class="form-label">Customer Date of Birth</label>
                    <input type="date" class="form-control" id="inputDOB" name="newCustomerDOB">
                </div>
                <div class="col-lg-6">
                    <label for="inputCode" class="form-label">Code of Customer</label>
                    <input type="text" class="form-control" id="inputCode" name="newCustomerCode">
                </div>
                <div class="col-lg-6">
                    <label for="inputIdentify" class="form-label">Customer Identify</label>
                    <input type="text" class="form-control" id="inputIdentify" name="newCustomerIdentify">
                </div>
                <div class="col-lg-6">
                    <label for="inputPhoneNumber" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="inputPhoneNumber" name="newCustomerPhoneNumber">
                </div>
                <div class="col-lg-6">
                    <label for="inputEmail" class="form-label">Email</label>
                    <input type="text" class="form-control" id="inputEmail" name="newCustomerEmail">
                </div>
                <div class="col-lg-6">
                    <label for="inputAddress" class="form-label">Address</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="newCustomerAddress">
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
