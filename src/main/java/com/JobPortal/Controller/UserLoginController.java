package com.JobPortal.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JobPortal.DaoImpl.User_InfoDAOImpl;
import com.JobPortal.Model.User_Info;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			
		String emailId = request.getParameter("emailId");
		String Password = request.getParameter("password");
		
		User_InfoDAOImpl user =new User_InfoDAOImpl();
		
		try {
			Boolean Str = user.login(emailId, Password);
			System.out.println(Str);
			if(Str==true)
			{
			    response.sendRedirect("ApplicantHomePage.jsp");
			}
			else
			{
				response.sendRedirect("UserLoginError.jsp");
				
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
