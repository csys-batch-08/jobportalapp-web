<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.JobPortal.Model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.JobPortal.DaoImpl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update Applied Status</title>
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
	<table border="2" id="alljobs" class="table">
		<h1 align="center">
			<strong>Applicant Status</strong>
		</h1>
		<br>
		<thead>
			<tr>
				<th>S.No</th>
				<th>Company Id</th>
				<th>Company Name</th>
				<th>Recruiter Email</th>
				<th>Applicant Id</th>
				<th>Applicant Name</th>
				<th>Applicant Address</th>
				<th>Applicant Skill</th>
				<th>Post Id</th>
				<th>Job Title</th>
				<th>Applied Date</th>
				<th>Status</th>
				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${updates}" var="current">
				<c:set var="i" value="${i+1 }" />
				<tr>
					<td class="warning">${i}</td>
					<td class="table-danger"><c:out
							value="${current.getCompanyId()}" /></td>
					<td class="table-primary"><c:out
							value="${current.getCompanyName()}" /></td>
					<td class="table-info"><c:out value="${current.getEmail()}" /></td>
					<td class="table-danger"><c:out
							value="${current.getApplicantID()}" /></td>
					<td class="table-light"><c:out
							value="${current.getApplicantName()}" /></td>
					<td class="warning"><c:out value="${current.getAddress()}" /></td>
					<td class="table-info"><c:out value="${current.getSkill()}" /></td>
					<td class="table-danger"><c:out value="${current.getPostID()}" /></td>
					<td class="table-info"><c:out value="${current.getJobTitle()}" /></td>
					<td class="table-primary"><c:out
							value="${current.getAppliedDate()}" /></td>
					<td class="table-danger"><c:out value="${current.getStatus()}" /></td>
					<td class="table-warning"><a
						href="updateJobStatus.jsp?postId=<c:out value="${current.getPostID()}" />">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="recruiter.jsp"><button class="button button1"
			style="margin-left: 650px">Back</button></a>
</body>
</html>
