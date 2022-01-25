<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Register</title>
</head>
<link rel="stylesheet" href="CompanyRegister.css">

<body>

<form action="CompanyRegisterController" method="post" >
<div class="form-box">
<h1>Register Form</h1>
<input type ="number" name = "companyid" placeholder="Company Id" pattern = "[0-9]{3}" autofocus required><br><br>
<input type ="text" name = "companyname" placeholder = "Company Name" pattern = "[A-Za-z.,'@ ]{3,30}"  required ><br><br>
<input type ="text" name = "username" placeholder ="User Name"  pattern = "[A-Za-z., ]{3,30}" required><br><br>
<input type ="text" name = "userrole" placeholder="UserRole" pattern = "[A-Za-z' ]{2,30}" required><br><br>
<input type ="number" name = "phonenumber" placeholder="Phone Number" pattern = "[0-9]{10}" required><br><br>
<input type ="text" name = "location" placeholder ="Location" pattern = "[A-Za-z.' ]{3,30}" required><br><br>
<input type="email" name = "mailid" placeholder="Email Id" id="mailid" required onkeyup ="emailvalid()"><br><br>
<p id="emailresponse"></p>
<input type="password" name="password" placeholder="Password" pattern = "[a-zA-Z0-9@#]{5,8})"  required  ><br><br> 
 <input type ="submit" style="background-color: red" value ="Login">
    <p class="backlink">Already have an account ?<a href="CompanyLogin.jsp">Login</a></p>
</div>

<p id="emailresponse"></p>
</form>>
<script>  
function emailvalid()  
{  
	console.log("called");
var email = document.getElementById("mailid").value;  
console.log(email);

var url="Exception.jsp?email="+email;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var response=request.responseText;  
document.getElementById('emailresponse').innerHTML=response;  
}  
}  
  
</script>  

</body>
</html>