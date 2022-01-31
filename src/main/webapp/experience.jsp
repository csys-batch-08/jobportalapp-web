<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search By Experience</title>
</head>
<link rel="stylesheet" href="location.css">
<body background=url(Assets/back.jpg)>

<form action="SearchExperienceController" method="post" >
<div class="form-box">
<h1>Search By Experience</h1>
<input type ="text" name = "experience" placeholder = "Enter Experience" pattern = "[0-9][A-Za-z]+{6,7}"  autofocus required ><br><br>

 
 <input type ="submit" style="background-color: red" value ="Search">
   
</div>
</form>

</body>
</html>