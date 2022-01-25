<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.JobPortal.Model.*"%>
    <%@page import="java.util.*"%>
    <%@page import="com.JobPortal.DaoImpl.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Applicant</title>
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

<%

		ApplyJobDaoImpl showJob = new   ApplyJobDaoImpl();
		List<ApplyJob> appliedList = new ArrayList<ApplyJob>();
		appliedList=showJob.showApplicant();
%>
		
		
		<table border="2" id="allapplicants" class="table" >
			<h1 style="text-align: center"><b>Applicant List</b></h1>
			<thead>
				<tr>
				<th>S.No</th>
				   <th >Post Id</th>
					<th>Applicant Id</th>
					<th>Applicant Name</th>
					<th>Qualification</th>
					<th>Age</th>
					<th>Email</th>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Skill</th>
					<th>Applied Date</th>
					
					
					</tr>
			</thead>
			<br>
			<br>
			
						<tbody>
				<%
					int i = 0;
					for (ApplyJob list : appliedList) {
						i++;
						
				%>
				<tr>
					<td class="warning"><%=i%></td>
					<td class ="table-danger"><%=list.getPostId()%></td>
					<td class="table-primary"><%=list.getApplicantId()%></td>
					<td class="table-info"> <%=list.getApplicantName()%></td>	
					<td class="table-primary"><%=list.getQualification() %></td>	
					<td class="table-warning"><%=list.getAge()%></td>	
					<td class="table-active"><%=list.getEmail() %></td>			
					<td class="table-primary"> <%=list.getAddress()%></td>
					<td class="table-secondary"> <%=list.getPhoneNumber()%></td>
					<td class="table-danger"><%=list.getSkill() %></td>
					<td class="table-light"><%=list.getDate() %></td>
									
			</tr>
					
					<%
				}
				%>
					</tbody>
		           </table>
<a href="Recruiter.jsp" ><button class="button button1" style="margin-left: 650px">Back</button></a>
</body>
</html>