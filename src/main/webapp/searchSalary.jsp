<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.JobPortal.Model.*"%>
    <%@page import="java.util.*"%>
    <%@page import="com.JobPortal.DaoImpl.*"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs By Salary</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
table.center {
  margin-left: 350px; 
  margin-right: auto;
}
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
<body>

		
			<table border="2" id="alljobs" class="table">
			<h1 align="center" ><b>Search By Salary List:</b></h1>
			<thead>
				<tr>
				<th>S.No</th>
				   <th >Company Id</th>
					<th>Company Name</th>
					<th>Post Id</th>					
					<th>Salary</th>	
					<th>Job Title</th>				
					<th>Location</th>
					<th>Experience</th>
					<th>Apply</th>
					</tr>
					</thead>
			<br>
			<br>
									<tbody>
				 <c:forEach items="${salary}" var="current">
				 <c:set var="i" value="${i+1 }"/>
				<tr>
					<td class="warning">${i}</td>
					<td class ="table-danger"><c:out value="${current.getCompanyId()}" /></td>
					<td class="table-primary"><c:out value="${current.getCompanyName()}" /></td>
					<td class="table-info"><c:out value="${current.getPostId()}" /></td>
					<td class="table-warning"><c:out value="${current.getIncome()}" /></td>
					<td class="table-active"><c:out value="${current.getJobTitle()}" /></td>										
					<td class="table-secondary"><c:out value="${current.getLocation()}" /></td>
					<td class="table-warning"><c:out value="${current.getService()}" /></td>
					<td class="table-light"><a href="ApplyJob.jsp?postid=<c:out value="${current.getPostId()}" />">Apply</a></td>
					
													
			</tr>
					</c:forEach>
					</tbody>
		           </table>
		           		           <a href="ApplicantHomePage.jsp" ><button class="button button1" style="margin-left: 650px">Back</button></a>
		           
</body>
</html>
