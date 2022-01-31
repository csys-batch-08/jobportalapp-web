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
<title>Update Applied Status</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>

.center {
  margin-left: auto;
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
			<h1><b>Applicant Status</b></h1>
			<thead>
				<tr>
				<th>S.No</th>
				   <th >Post Id</th>
					<th>Applicant Id</th>
					<th>Status</th>
					<th>Update</th>
					
					</tr>
					</thead>
			<br>
			<br>
			
						<tbody>
				 <c:forEach items="${updates}" var="current">
				 <c:set var="i" value="${i+1 }"/>
				<tr>
					<td class="warning">${i}</td>
					<td class ="table-danger"><c:out value="${current.getPostID()}" /></td>
					<td class="table-primary"><c:out value="${current.getApplicantID()}" /></td>
					<td class="table-active"><c:out value="${current.getStatus()}" /></td> 									
					<c:choose>  
    <c:when test="${postId==current.getPostID()}">  
       <td class="table-warning"><a href="updateJobStatus.jsp?postId=<c:out value="${current.getPostID()}" />">Update</a></td>
    </c:when> 
    <c:otherwise>  
      <td><b>Can't Update</b></td> 
    </c:otherwise>  
</c:choose>
					
									
			</tr>
					
					</c:forEach>
					</tbody>
		           </table>
		           <a href="recruiter.jsp" ><button class="button button1" style="margin-left: 650px">Back</button></a>
</body>
</html>
