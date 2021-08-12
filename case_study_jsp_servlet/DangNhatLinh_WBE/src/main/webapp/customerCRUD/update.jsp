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
    <title>Update Customer</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
<jsp:include page = "../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="../layout/right_list.jsp"></jsp:include>
        <div class="col-lg-10">
            <div class="col-lg-12 text-center">
                <h2>Please input information</h2>
            </div>
            <form class="row g-3 mx-3" action="/customers" method="post" >
                <input type="hidden" name="actionClient" value="update" >
                <input type="hidden" name="CustomerId" value="${SelectCustomer.idCustomer}">
                <div class="col-lg-8">
                    <label for="inputName" class="form-label">Name of Customer</label>
                    <input type="text" class="form-control" id="inputName" name="newCustomerName" value="${SelectCustomer.nameCustomer}">
                </div>
                <div class="col-lg-6">
                    <label for="inputGender" class="form-label">Gender</label>
                    <select id="inputGender" class="form-select" name="newCustomerGender" value="${SelectCustomer.genderCustomer}">
                        <option selected>Choose...</option>
                        <option value=true>Male</option>
                        <option value=false>Female</option>
                    </select>
                </div>
                <div class="col-lg-6">
                    <label for="inputType" class="form-label">Type Custormer </label>
                    <select id="inputType" class="form-select" name="newCustomerType" value="${SelectCustomer.typeCustomer}">
                        <option selected>Choose...</option>
                        <option value="1">Diamond</option>
                        <option value="2">Platinum</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                </div>
                <div class="col-lg-6">
                    <label for="inputDOB" class="form-label">Customer Date of Birth</label>
                    <input type="date" class="form-control" id="inputDOB" name="newCustomerDOB" value="${SelectCustomer.dateOfBirthCustomer}" >
                </div>
                <div class="col-lg-6">
                    <label for="inputCode" class="form-label">Code of Customer</label>
                    <input type="text" class="form-control" id="inputCode" name="newCustomerCode" value="${SelectCustomer.codeCustomer}">
                </div>
                <div class="col-lg-6">
                    <label for="inputIdentify" class="form-label">Customer Identify</label>
                    <input type="text" class="form-control" id="inputIdentify" name="newCustomerIdentify" value="${SelectCustomer.identifyCodeCustomer}">
                </div>
                <div class="col-lg-6">
                    <label for="inputPhoneNumber" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="inputPhoneNumber" name="newCustomerPhoneNumber" value="${SelectCustomer.phoneNumberCustomer}" >
                </div>
                <div class="col-lg-6">
                    <label for="inputEmail" class="form-label">Email</label>
                    <input type="text" class="form-control" id="inputEmail" name="newCustomerEmail" value="${SelectCustomer.emailCustomer}">
                </div>
                <div class="col-lg-6">
                    <label for="inputAddress" class="form-label">Address</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="newCustomerAddress" value="${SelectCustomer.addressCustomer}">
                </div>
                <div class="col-lg-6">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
                <p style="color: blue;">${msg}</p>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>

<script src="../js/bootstrap.min.js"></script>
</body>
</html>
