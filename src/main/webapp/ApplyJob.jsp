<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="com.JobPortal.Model.*"%>
    <%@page import="com.JobPortal.DaoImpl.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PostJob</title>
</head>
<link rel="stylesheet" href="ApplyJob.css">

<body  background="Assets/back.jpg">

<form action="ApplyJobController" method="post" >
<div class="form-box">
<h1> Application Form</h1>
<input type ="number" name = "postid" value="<%=request.getParameter("postid")%>" placeholder="Enter Job Post Id"><br><br>
<input type ="text" name = "applicantname" placeholder = "Enter Your Name" pattern = "[A-Za-z ]{3,30}" autofocus required ><br><br>
<input type ="text" name = "qualification" placeholder ="Enter Qualification" pattern = "[A-Za-z.,' ]{3,30}" required><br><br>
<input type ="text" name = "skill" placeholder="Enter Your Skill" pattern = "[A-Za-z ]{3,30}" required><br><br>
<input type ="number" name = "age" placeholder="Enter Your Age" pattern = "[0-9]{2}" required><br><br>
<input type = "email" name = "emailid" placeholder="Enter Mail Id" pattern = "[a-z0-9]+[@][a-z]+[.][a-z]+{2,5}" required><br><br>
<input type = "password" name ="password" placeholder="Enter Password" pattern = "[a-zA-Z0-9@#]+{5,8})" required><br><br>
<input type = "text" name = "city" placeholder = "Enter Your City" pattern = "[a-zA-Z 0-9 /,]+{3,30}" required><br><br>
<input type = "number" name = "mobilenumber" placeholder = "Enter Mobile Number" pattern = "[0-9]+{10}" required><br><br>


 <input type ="submit" style="background-color: red" value ="Apply Job">
   
</div>
</form>>

</body>
</html>