<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="companyLogin.css">
<body>
	<form action="UserLoginController" method="POST">
		<div class="form-box">
			<h1>Login Form</h1>
			<input placeholder="Your MailId" type="email" name="emailId"
				id="mailid" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{2,5}" required>
			<input placeholder="Your Password" type="password" name="password"
				id="pas" pattern="[a-zA-Z0-9@#]{5,8})" required> <input
				type="submit" style="background-color: red" value="Login">
			<p class="backlink">
				Don't have an account ?<a href="userRegister.jsp">Register</a>
			</p>
		</div>
	</form>
</body>
</html>