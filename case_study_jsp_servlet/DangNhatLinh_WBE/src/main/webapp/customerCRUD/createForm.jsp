<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/11/2021
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Customer</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
<div class="col-lg-12 text-center">
    <h2>Please input information</h2>
</div>
<form class="row g-3 mx-3" action="/customers" name="actionClient" value="create" method="post">
    <div class="col-lg-8">
        <label for="inputName" class="form-label">Name of Customer</label>
        <input type="text" class="form-control" id="inputName" name="newCustomerName">
    </div>
    <div class="col-lg-6">
        <label for="inputGender" class="form-label">Gender  (0.Female - 1.Male)</label>
        <select id="inputGender" class="form-select" name="newCustomerGender">
            <option selected>Choose...</option>
            <option value="Female">0</option>
            <option value="Male">1</option>
        </select>
    </div>
    <div class="col-lg-6">
        <label for="inputType" class="form-label">Type Custormer 1."Diamond" - 2."Platinium" - 3."Gold" - 4."Silver" - 5."Member"</label>
        <select id="inputType" class="form-select" name="newCustomerType">
            <option selected>Choose...</option>
            <option value="Diamond">1</option>
            <option value="Platinium">2</option>
            <option value="Gold">3</option>
            <option value="Silver">4</option>
            <option value="Member">5</option>
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
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Create</button>
    </div>
</form>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
