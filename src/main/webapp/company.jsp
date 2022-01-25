<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search By Company</title>
</head>
<link rel="stylesheet" href="location.css">
<body background="https://images.pexels.com/photos/1631677/pexels-photo-1631677.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500">

<form action="SearchCompanyController" method="post" >
<div class="form-box">
<h1>Search By Company</h1>
<input type ="text" name = "company" placeholder = "Enter Company Name"   autofocus required ><br><br>

 
 <input type ="submit" style="background-color: red" value ="Search">
   
</div>
</form>

</body>
</html>