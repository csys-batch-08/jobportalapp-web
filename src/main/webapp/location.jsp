<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Search Location</title>
</head>
<link rel="stylesheet" href="location.css">
<body>

	<form action="SearchLocationController" method="post">
		<div class="form-box">
			<h1>Search By Location</h1>
			<input type="text" name="location" placeholder="Enter Location"
				pattern="[A-Za-z]{3,30}" autofocus required><br>
			<br> <input type="submit" style="background-color: red"
				value="Search">
		</div>
	</form>
</body>
</html>