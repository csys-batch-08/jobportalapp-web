<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
</head>
<link rel="stylesheet" href="userRegister.css">
<style>
.drop {
	width: 100px;
	height: 40px;
}
</style>
<body>

	<form action="UserRegisterController" method="post">
		<div class="form-box">
			<h1>Register Form</h1>
			<input type="text" name="firstname" placeholder="FirstName"
				pattern="[A-Za-z ]{3,30}" title="show" autofocus required><br>
			<br> <input type="text" name="lastname" placeholder="LastName"
				pattern="[A-Za-z .]{3,30}" required><br>
			<br> <input type="text" name="username" placeholder="UserName"
				pattern="[A-Za-z ]{3,30}" required><br>
			<br> <select name="gender" id="gender" class="drop">
				<option>Male</option>
				<option>Female</option>
			</select><br>
			<br>
			<input type="email" name="mailid" placeholder="Email Id" id="mailid"
				required onkeyup="emailvalid()"><br>
			<br>
			<p id="emailresponse"></p>
			<input type="password" name="password" placeholder="Password"
				pattern="[a-zA-Z0-9@#]{5,8})" required><br>
			<br> <input type="number" name="mobilenumber"
				placeholder="MobileNumber" pattern="[0-9]{10}" required> <input
				type="submit" style="background-color: red" value="Login">
			<p class="backlink">
				Already have an account ?<a href="userLogin.jsp">Login</a>
			</p>
		</div>
		<p id="emailresponse"></p>
	</form>
	<script>
		function emailvalid() {
			console.log("called");
			var email = document.getElementById("mailid").value;
			console.log(email);

			var url = "UserException?email=" + email;

			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}

			try {
				request.onreadystatechange = getInfo;
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}
		}

		function getInfo() {
			if (request.readyState == 4) {
				var response = request.responseText;
				document.getElementById('emailresponse').innerHTML = response;
			}
		}
	</script>
</body>
</html>