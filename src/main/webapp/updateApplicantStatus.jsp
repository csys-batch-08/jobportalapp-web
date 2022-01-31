<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update applicant</title>
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
.button1 {background-color: lightblue;}
</style>
<body >

<form action="UpdateApplicantStatus" method="post" >
<div class="form-box">
<h1>Applicant Status</h1>
<input type ="number" name = "postId" value="${param.postId}"  placeholder = "Enter Post Id"   ><br><br>
<input type ="number" name = "applicantId" value="${param.applicantId}" placeholder ="Enter Applicant Id"  required ><br><br>
<input type ="text" name = "status" placeholder="Enter Status" pattern = "[a-zA-Z]+{5,9}" required><br><br>

 
 <input type ="submit" style="background-color: red" value ="Add">
    
</div>


</form>
<a href="recruiter.jsp" ><button class="button button1" style="margin-left: 30px;margin-top: 550px">Back</button></a>
</body>
</html>