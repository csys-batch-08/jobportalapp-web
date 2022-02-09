<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.JobPortal.Model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.JobPortal.DaoImpl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>View Applicant</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
.center {
	margin-left: auto;
	margin-right: auto;
}

.button {
	border: none;
	color: black;
	padding: 5px 22px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 19px;
	margin: 4px 2px;
	cursor: pointer;
}

.button1 {
	background-color: lightblue;
}
</style>
<body>
	<table border="2" id="allapplicants" class="table">
		<h1 style="text-align: center">
			<strong>Applicant List</strong>
		</h1>
		<thead>
			<tr>
				<th>S.No</th>
				<th>Applicant Id</th>
				<th>Post Id</th>
				<th>Applicant Name</th>
				<th>Qualification</th>
				<th>Age</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone Number</th>
				<th>Skill</th>
				<th>Applied Date</th>
				<th>Add Status</th>
			</tr>
		</thead>
		<br>
		<br>
		<tbody>
			<c:forEach items="${appliedList}" var="current">
				<c:set var="i" value="${i+1 }" />
				<tr>
					<td class="warning">${i}</td>
					<td class="table-danger"><c:out value="${current.getPostId()}" /></td>
					<td class="table-primary"><c:out
							value="${current.getApplicantId()}" /></td>
					<td class="table-info"><c:out
							value="${current.getApplicantName()}" /></td>
					<td class="table-primary"><c:out
							value="${current.getQualification()}" /></td>
					<td class="table-warning"><c:out value="${current.getAge()}" /></td>
					<td class="table-active"><c:out value="${current.getEmail()}" /></td>
					<td class="table-primary"><c:out
							value="${current.getAddress()}" /></td>
					<td class="table-secondary"><c:out
							value="${current.getPhoneNumber()}" /></td>
					<td class="table-danger"><c:out value="${current.getSkill()}" /></td>
					<td class="table-light">${current.getDate()}</td>


					<td class="table-warning"><a
						href="updateApplicantStatus.jsp?postId=<c:out value="${current.getApplicantId()}&postId=${current.getApplicantId()}&applicantId=${current.getPostId()}" />">Add</a></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="recruiter.jsp"><button class="button button1"
			style="margin-left: 650px">Back</button></a>
</body>
</html>