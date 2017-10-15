<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Employee Services</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">
    if (typeof jQuery == 'undefined') {
        alert("jQuery library is not found!");
    }

	var delEmpCall = function(empId) {
        if(empId) {
            $.ajax({
                url: 'delEmp/' + empId,
                type: 'DELETE',
                success: function(result) {
					if(result) {
                        $("#emp_" + result).remove();
                    }
                }
            });
		}
		return false;
	};

    var getEmpCall = function() {
        if($("#empSearchtxt")) {
            var empId = $("#empSearchtxt").val().trim();
            $.ajax({
                url: 'getEmp/' + empId,
                type: 'GET',
                success: function(result) {
                    if(result) {
                        var getEmpResponse = JSON.parse(result);
						$('.empRecordRow').remove();
                        $('table').append("<tr class='empRecordRow' id='emp_" + getEmpResponse.id + "'>"
							+ "<td>" + getEmpResponse.id + "</td><td>" + getEmpResponse.firstName + "</td>"
							+ "<td>" + getEmpResponse.lastName + "</td><td>" + getEmpResponse.email +"</td>"
							+ "<td>" + getEmpResponse.gender + "</td><td>" + getEmpResponse.empDept.deptName + "</td>"
							+ "<td><a class='btn btn-primary'>Edit</a></td><td><a class='btn btn-danger' "
							+ " onclick='delEmpCall(" + getEmpResponse.id + ")'>Delete</a></td></tr>");
                    }
                }
            });
        }
        return false;
    };

    var test = function () {
        location.reload();
        return false;
    }

</script>

<div class="row">
	<div class="col-md-12">
		<div class="container">
			<form class="form-inline">
				<div class="form-group">
					<input id="empSearchtxt" type="text" class="form-control" placeholder="Employee ID">
				</div>
				<div class="form-group">
					<a class="form-control btn btn-success" onclick="getEmpCall()">Search</a>
				</div>
				<div class="form-group">
					<a class="form-control btn btn-info" onclick="test()">Reset</a>
				</div>
				<div class="form-group">
					<a class="form-control btn btn-secondary" href="createEmp">Create Employee</a>
				</div>
			</form>
			<table class="table table-hover">
				<tr class="empRecordHeader">
					<th>EmpID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-mail</th>
					<th>Gender</th>
					<th>Department</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<c:if test="${requestScope.empList != null }">
					<c:forEach var="eachEmp" items="${empList}">
						<tr class="empRecordRow" id="emp_${eachEmp.id}">
							<td>
								<c:out value="${eachEmp.id}" />
							</td>
							<td>
								<c:out value="${eachEmp.firstName}" />
							</td>
							<td>
								<c:out value="${eachEmp.lastName}" />
							</td>
							<td>
								<c:out value="${eachEmp.email}" />
							</td>
							<td>
								<c:out value="${eachEmp.gender}" />
							</td>
							<td>
								<c:out value="${eachEmp.empDept.deptName}" />
							</td>
							<td>
								<a class="btn btn-primary">Edit</a>
							</td>
							<td>
								<a class="btn btn-danger" onclick="delEmpCall(${eachEmp.id})">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>

				<c:if test="${requestScope.empList == null }">
					<tr>
						<td colspan="8">No employee found at this time.</td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
</div>
</body>
</html>