package com.JobPortal.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JobPortal.DaoImpl.CompanyProfileDaoImpl;
import com.JobPortal.DaoImpl.User_InfoDAOImpl;
import com.JobPortal.Model.CompanyModel;
import com.JobPortal.Model.PostJobModel;


@WebServlet("/CompanyLoginController")
public class CompanyLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CompanyLoginController() {
        super();
            }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		System.out.println("cnvccvc"+email);
		String Password = request.getParameter("password");
		System.out.println("snvdfcgscdcghcdgdccd");
	
		CompanyProfileDaoImpl cpDao = new CompanyProfileDaoImpl();
		
		try {
			Boolean Str = cpDao.companyLogin(email, Password);
		HttpSession session=request.getSession();
			session.setAttribute("Email", email);


			if(Str==true)
			{

			    response.sendRedirect("Recruiter.jsp");
			   			    
			}
			else
			{
				response.sendRedirect("CompanyLoginError.jsp");
				
			}
		} 
		
		catch (Exception e) {			
			e.printStackTrace();
			
		}
		
	}

}
