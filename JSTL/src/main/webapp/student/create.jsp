<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KILL YOU
  Date: 6/29/2021
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/assert/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/assert/datatables/css/dataTables.bootstrap4.css">
</head>
<body>
<jsp:include page="/layout/header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
            <jsp:include page="/layout/left-sidebar.jsp"></jsp:include>
        </div>
        <div class="col-9">
            <h1>Create Student</h1>

            <form action="/student" method="post">
                <input type="hidden" name="actionClient" value="create">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" aria-describedby="name_stu" name="name" value="${student.getName()}">
                    <c:if test="${map.get('name') != null}">
                    <small id="name_stu" class="form-text text-danger">${map.get('name')}</small>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="point">Point</label>
                    <input type="text" class="form-control" id="point" aria-describedby="point_stu" name="point" value="${student.getPoint()}">
                    <c:if test="${map.get('point') != null}">
                        <small id="point_stu" class="form-text text-danger">${map.get('point')}</small>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="gender">Gender</label>
                    <select class="form-control" id="gender" name="gender">
                        <option value="1" ${student.gender == 1 ? 'selected': ''}>Male</option>
                        <option value="0" ${student.gender == 0 ? 'selected': ''}>Female</option>
                        <option value="2" ${student.gender == 2 ? 'selected': ''}>Other</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>
    </div>

</div>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.js"></script>
<script src="/assert/jquery/popper.min.js"></script>
<script src="/assert/js/bootstrap.js"></script>
</body>
</html>
