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
<title>View Jobs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
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
<body>

		<table border="2" id="alljobs" class="table">
			<h1 style="text-align: center"><b>Job List</b></h1>
			<thead>
				<tr>
				<th>S.No</th>
				   <th >Company Id</th>
					<th>Post Id</th>
					<th>Job Title</th>
					<th>Salary</th>
					<th>Experience</th>
					<th>Category</th>
					<th>Post Date</th>
					<th>Apply Link</th>
					
					
					</tr>
			</thead>
			<br>
			<br>
			
						<tbody>
				 <c:forEach items="${jobList}" var="current">
				 <c:set var="i" value="${i+1 }"/>
				<tr>
					<td class="warning">${i}</td>
					<td class ="table-danger"><c:out value="${current.getCompanyId()}" /></td>
					<td class="table-primary"><c:out value="${current.getPostId()}" /></td>
					<td class="table-info"><c:out value="${current.getJobTitle()}" /></td> 
					<td class="table-primary"><c:out value="${current.getIncome()}" /></td>	
					<td class="table-warning"><c:out value="${current.getService()}" /></td>
					<td class="table-danger"><c:out value="${current.getCategories()}" /></td>		
					<td class="warning"><c:out value="${current.getPostDate()}" /></td>
					<td><a href="ApplyJob.jsp?postid=<c:out value="${current.getPostId()}&postId=${current.getPostId()}" />"class="table-light">Apply</a></td>
									
			</tr>
					</c:forEach>
					</tbody>
		           </table>
		           		           <a href="ApplicantHomePage.jsp" ><button class="button button1" style="margin-left: 650px">Back</button></a>
		           
</body>
</html>