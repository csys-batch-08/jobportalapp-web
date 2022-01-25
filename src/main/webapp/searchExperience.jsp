<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.JobPortal.Model.*"%>
    <%@page import="java.util.*"%>
    <%@page import="com.JobPortal.DaoImpl.*"%>
   
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Jobs By Experience</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%

		PostJobDaoImpl search = new   PostJobDaoImpl();
		List<PostJobModel> searchList =(List<PostJobModel>) session.getAttribute("Experience");
		
		for(int i=0; i<searchList.size();i++){
	System.out.println(searchList.get(i));
	PostJobModel searchs = searchList.get(i);
	
		     searchList=search.SearchExp(searchs.getService());
		     System.out.println("Experience : "+searchs.getService());
%>
		
			<table border="2" id="alljobs" class="table" >
			<h1 align="center" ><b>Search By Experience List:</b></h1>
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
				<%
					
					for (PostJobModel list : searchList) {
						i++;
						
						System.out.println(list);
										%>
				<tr>
					<td class="warning"><%=i%></td>
					<td class ="table-danger"><%=list.getCompanyId()%></td>
					<td class="table-primary"><%=list.getCompanyName()%></td>
					<td class="table-info"> <%=list.getPostId()%></td>	
					<td class="table-warning"> <%=list.getIncome()%></td>	
					<td class="table-active"> <%=list.getJobTitle()%></td>										
					<td class="table-secondary"> <%=list.getLocation()%></td>
					<td> <%=list.getService()%></td>
					<td class="table-light"><a href="ApplyJob.jsp">Apply</a></td>
					
													
			</tr>
					
					<%
				}}
				%>
					</tbody>
		           </table>
		           <a href="ApplicantHomePage.jsp" ><button class="button button1" style="margin-left: 650px">Back</button></a>
</body>
</html>
