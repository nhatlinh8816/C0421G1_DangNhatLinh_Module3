<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="assert/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assert/datatables/css/dataTables.bootstrap4.css">
</head>
<body>
<jsp:include page="/layout/header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
            <jsp:include page="/layout/left-sidebar.jsp"></jsp:include>
        </div>
        <div class="col-9">
            <h1>Student List</h1>

            <a class="btn btn-success mb-2" href="/student?actionClient=create" role="button">Create</a>
            <c:if test="${empty studentList}">
                <h3 style="color: red">Student List Empty!</h3>
            </c:if>

            <c:if test="${not empty studentList}">
                <table id="tableStudent" class="table table-striped">
                    <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Point</th>
                        <th>Result</th>
                        <th>Image</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${studentList}" var="student">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${student.gender == 0}">Female</c:when>
                                    <c:when test="${student.gender == 1}">Male</c:when>
                                    <c:otherwise>LGBT</c:otherwise>
                                </c:choose>
                            </td>
                            <td>${student.point}</td>
                            <td>
                                <c:if test="${student.point >= 75}">Pass</c:if>
                                <c:if test="${student.point < 75}">Fail</c:if>
                            </td>
                            <td>
                                <img src="assert/img/${student.image}" width="50" height="50">
                            </td>
                            <td>
                                <button onclick="onDelete('${student.id}','${student.name}')" type="button"
                                        class="btn btn-danger" data-toggle="modal" data-target="#modelId">Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <!-- Button trigger modal -->
            <%--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modelId">--%>
            <%--    Launch--%>
            <%--</button>--%>
            <!-- Modal -->
            <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Confirm delete</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="/student" method="post">
                            <input type="hidden" name="actionClient" value="delete">
                            <input type="hidden" name="id" value="" id="idStudentDel">
                            <div class="modal-body">
                                Ban co muon xoa...
                                <input style="border: none; outline: none; color: red"
                                       id="nameStudentDel" readonly>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-primary">OK</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="assert/jquery/jquery-3.5.1.min.js"></script>
<script src="assert/datatables/js/jquery.dataTables.js"></script>
<script src="assert/datatables/js/dataTables.bootstrap4.js"></script>
<script src="assert/jquery/popper.min.js"></script>
<script src="assert/js/bootstrap.js"></script>
<script>
    function onDelete(id, name) {
        document.getElementById("idStudentDel").value = id;
        console.log(id);
        console.log(name);
        document.getElementById("nameStudentDel").value = name;
    }
</script>

<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>

</body>
</html>
