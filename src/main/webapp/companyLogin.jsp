<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<link rel="stylesheet" href="companyLogin.css">
<body background=url(Assets/back.jpg)>
	<form action="CompanyLoginController" method="post">
		<div class="form-box">
			<h1>Login Form</h1>
			<input placeholder="Your MailId" type="email" name="email"required >
			<input placeholder="Your Password" type="password" name="password" required>
		    <input type="submit"style="background-color: red" value="Login">				
			<p class="backlink">
				Don't have an account ?<a href="companyRegister.jsp">Register</a>
			</p>
		</div>
	</form>
</body>
</html>