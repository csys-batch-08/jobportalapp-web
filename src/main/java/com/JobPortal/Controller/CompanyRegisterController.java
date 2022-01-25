package com.JobPortal.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JobPortal.DaoImpl.CompanyProfileDaoImpl;
import com.JobPortal.DaoImpl.User_InfoDAOImpl;
import com.JobPortal.Model.CompanyModel;
import com.JobPortal.Model.User_Info;


@WebServlet("/CompanyRegisterController")
public class CompanyRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CompanyRegisterController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String companyid1 = request.getParameter("companyid");
			String companyname = request.getParameter("companyname");
			String username = request.getParameter("username");
			String userrole = request.getParameter("userrole");
			String mobilenumber = request.getParameter("phonenumber");
			String location = request.getParameter("location");
			String email = request.getParameter("mailid");
			String  password =request.getParameter("password");

			int companyid = Integer.parseInt(companyid1);
			long phonenumber = Long.parseLong(mobilenumber);
        
			
          CompanyModel objcompanymodel = new CompanyModel(companyid,companyname,username,userrole,phonenumber,location,email, password);
          CompanyProfileDaoImpl comDao = new CompanyProfileDaoImpl();
			comDao.insertCompanyProfile(objcompanymodel);
			
			   response.getWriter().print("Register Suceessfully");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("CompanyLogin.jsp");
				requestDispatcher.forward(request, response);
				
				
			
		} catch (Exception e) {
			System.out.println(e);
			
		}

			
		
			}
	}


