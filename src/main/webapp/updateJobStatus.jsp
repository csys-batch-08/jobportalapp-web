<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update Status</title>
</head>
<link rel="stylesheet" href="updateApplicant.css">
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

.drop {
	width: 100px;
	height: 50px;
}
</style>
<body>
	<form action="UpdateJobStatus" method="post">
		<div class="form-box">
			<h1>Applicant Status</h1>
			<input type="number" name="postId" placeholder="Enter Post Id"
				pattern="[0-9]{4,4}" required><br>
			<br> <input type="number" name="applicantId"
				placeholder="Enter Applicant Id" pattern="[0-9]{3}" autofocus
				required><br>
			<br> <select name="status" id="status" class="drop">
				<option>Selected</option>
				<option>Rejected</option>
			</select><br>
			<br> <input type="submit" style="background-color: red"
				value="Update">
		</div>
	</form>
	<a href="recruiter.jsp"><button class="button button1"
			style="margin-left: 30px; margin-top: 550px">Back</button></a>
</body>
</html>