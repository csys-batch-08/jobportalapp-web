<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.JobPortal.Model.*"%>
    <%@page import="java.util.*"%>
    <%@page import="com.JobPortal.DaoImpl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applied Status</title>
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
<%

		JobStatusDaoImpl status = new   JobStatusDaoImpl();
		List<JobStatusModel> update = new ArrayList<JobStatusModel>();
		update=status.updateStatus();
%>
		
			<table border="2" id="alljobs" class="table" >
			<h1 style="text-align: center;"><b>Applicant Status</b></h1>
			<thead>
				<tr>
				<th>S.No</th>
				   <th >Post Id</th>
					<th>Applicant Id</th>
					<th>Status</th>
					
					
					</tr>
					</thead>
			<br>
			<br>
			
						<tbody>
				<%
					int i = 0;
					for (JobStatusModel list : update) {
						i++;
										%>
				<tr>
					<td class ="table-danger"><%=i%></td>
					<td class="table-primary"><%=list.getPostID()%></td>
					<td class="table-secondary"><%=list.getApplicantID()%></td>
					<td class="table-danger"> <%=list.getStatus()%></td>	
					
					
									
			</tr>
					
					<%
				}
				%>
					</tbody>
		           </table>
		           <a href="ApplicantHomePage.jsp" ><button class="button button1" style="margin-left: 650px">Back</button></a>
		           
</body>
</html>
