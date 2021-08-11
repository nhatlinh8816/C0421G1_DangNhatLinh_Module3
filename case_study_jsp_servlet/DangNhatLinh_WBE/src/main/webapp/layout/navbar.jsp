<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/11/2021
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light fs-6 ">
    <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse ms-5" id="navbarSupportedContent">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
    <li class="nav-item mx-4">
    <a class="nav-link active" aria-current="page" href="#">Home</a>
    </li>
    <li class="nav-item dropdown mx-4">
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
    Employee
    </a>
    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
    <li><a class="dropdown-item" href="#">Create new Employee</a></li>
    <li><a class="dropdown-item" href="#">Show List of Employee</a></li>
    </ul>
    </li>
    <li class="nav-item dropdown mx-4">
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-bs-toggle="dropdown" aria-expanded="false">
    Customer
    </a>
    <ul class="dropdown-menu" aria-labelledby="navbarDropdown1">
    <li><a class="dropdown-item" href="#">Create new Customer</a></li>
    <li><a class="dropdown-item" href="#">Show List of Customer</a></li>
    </ul>
    </li>
    <li class="nav-item dropdown mx-4">
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
    Service
    </a>
    <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
    <li><a class="dropdown-item" href="#">Create new Service</a></li>
    <li><a class="dropdown-item" href="#">Show List of Service</a></li>
    </ul>
    </li>
    <li class="nav-item dropdown mx-4">
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-bs-toggle="dropdown" aria-expanded="false">
    Contract
    </a>
    <ul class="dropdown-menu" aria-labelledby="navbarDropdown3">
    <li><a class="dropdown-item" href="#">Create new Contract</a></li>
    <li><a class="dropdown-item" href="#">Show List of Contract</a></li>
    </ul>
    </li>
    </ul>
    <form class="d-flex me-3 mt-2">
    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
    </div>
    </div>
    </nav>
</body>
</html>
