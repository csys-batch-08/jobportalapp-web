<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PostJob</title>
</head>
<link rel="stylesheet" href="PostJob.css">

<body>>
<form action="PostJobController" method="post" >
<div class="form-box">
<h1>Post Job Form</h1>
<input type ="number" name = "companyid" placeholder="Company Id" pattern = "[0-9]{3}" required><br><br>
<input type ="text" name = "jobtitle" placeholder = "Job Title" pattern = "[A-Za-z., ]{3,30}" autofocus required ><br><br>
<input type ="number" name = "salary" placeholder ="Enter Salary"  required><br><br>
<input type ="text" name = "experience" placeholder="Enter Experience" pattern = "[0-9 ][A-Za-z ]{3,7}" required><br><br>
<input type ="text" name = "category" placeholder="Enter Job Category" pattern = "[A-Za-z]{3,30}" required><br><br>

 <input type ="submit" style="background-color: red" value ="Post Job">
   
</div>
</form>>

</body>
</html>