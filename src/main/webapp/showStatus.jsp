<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.JobPortal.Model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.JobPortal.DaoImpl.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ShowStatus</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
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
			<strong>View Applicant Status</strong>
		</h1>
		<thead>
			<tr>
				<th>S.No</th>
				<th>Post Id</th>
				<th>Applicant Name</th>
				<th>Email</th>
				<th>PhoneNumber</th>
				<th>Applicant Id</th>
				<th>Date</th>
				<th>Status</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${Emails}" var="current">
				<c:set var="i" value="${i+1 }" />
				<tr>
					<td class="warning">${i}</td>
					<td class="table-danger"><c:out
							value="${current.getPostId()} " /></td>
					<td class="table-primary"><c:out
							value="${current.getApplicantName()}" /></td>
					<td class="table-info"><c:out value="${current.getEmail()}" /></td>
					<td class="table-warning"><c:out
							value="${current.getPhoneNumber()}" /></td>
					<td class="table-active"><c:out
							value="${current.getApplicantId()}" /></td>
					<td><fmt:formatDate value="${current.getDate()}"
							pattern="dd-MM-yyyy" /></td>
					<td class="table-warning"><c:out
							value="${current.getStatus()}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="applicantHomePage.jsp"><button class="button button1"
			style="margin-left: 650px">Back</button></a>
</body>
</html>