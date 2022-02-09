package com.JobPortal.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JobPortal.DaoImpl.User_InfoDAOImpl;


@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserLoginController() {
        super();
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String emailId = request.getParameter("emailId");
		String Password = request.getParameter("password");		
		User_InfoDAOImpl user =new User_InfoDAOImpl();		
		try {
			Boolean Str = user.login(emailId, Password);			
			if(Str==true)
			{
			    response.sendRedirect("applicantHomePage.jsp");
			}
			else
			{
				response.sendRedirect("userLoginError.jsp");				
			}
		    } 		
		catch (Exception e) {			
			e.printStackTrace();			
		    }	
	}
}