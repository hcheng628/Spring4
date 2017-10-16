<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="us.supercheng.spring.spring4.springmvc.entity.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
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
	var updateCall = function (empId) {
		var data = $.param(
            {
                "empDept.deptId": $('#empDept\\.deptId option:selected').val(),
                "id": empId,
                "firstName": $('#firstName').val(),
                "lastName": $('#lastName').val(),
                "email": $('#email').val(),
                "gender": $('input[name=gender]:checked').val()
    });
		console.log("PUT: " + data);
        $.ajax({
            url: '${pageContext.request.contextPath}/api/rest/updateEmp/' + empId,
            type: 'PUT',
            data: data,
            success: function(result) {
                if(result == empId) {
					// location.href = "getEmps";
					console.log("PUT Response: " + result);
                }
            }
        });
	    return false;
    }
</script>
<div class="row">
	<div class="col-md-8">
		<div class="container">
			<%--<c:out value="${emp}" />--%>
			<h3>New Employee Information</h3>
			<%
				Emp emp = (Emp) request.getAttribute("emp");
				String goToAction = emp.getId() == null || emp.getId().length() < 1 ? "/addEmp" : "/updateEmp/" + emp.getId();
				request.setAttribute("goToAction",goToAction);
			%>
			<form:form action='${pageContext.request.contextPath}/api/rest${goToAction}' method="post" modelAttribute="emp">
				<table class="table table-hover">

					<c:if test="${emp.id != null && emp.id.length() > 0}">
						<tr>
							<td>ID</td>
							<td>
								<form:input path="id" class="form-control" />
								<%--<c:if test="${emp.id != null && emp.id.length() > 0}">--%>
									<%--<input type="hidden" name="_method" value="PUT"/>--%>
								<%--</c:if>--%>
							</td>
						</tr>
					</c:if>
					<tr>
						<td>First Name</td>
						<td>
							<form:input path="firstName" class="form-control" />
						</td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td>
							<form:input type="text" path="lastName" class="form-control" />
						</td>
					</tr>
					<tr>
						<td>E-mail</td>
						<td>
							<form:input type="text" path="email" class="form-control" />
						</td>
					</tr>
					<tr>
						<td>Gender</td>
						<%
							Map<String, Object> genderMap = new HashMap<>();
							genderMap.put("0", "Female");
							genderMap.put("1", "Male");
							request.setAttribute("genderMap", genderMap);
						%>
						<td>
							<form:radiobuttons path="gender" items="${genderMap}"/>
						</td>
					</tr>
					<tr>
						<td>Department</td>
						<td>
							<form:select path="empDept.deptId" class="form-control" items="${depts}"
										 itemValue="deptId" itemLabel="deptName">
							</form:select>
						</td>
					</tr>
					<tr>
						<td>

							<c:if test="${emp.id == null}">
								<input class="btn btn-success" type="submit" value="Create" />
							</c:if>
							<c:if test="${emp.id != null}">
								<a class="btn btn-success" onclick="updateCall(${emp.id})">Update</a>
							</c:if>

						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>