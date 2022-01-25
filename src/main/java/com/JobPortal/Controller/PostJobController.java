package com.JobPortal.Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JobPortal.DaoImpl.CompanyProfileDaoImpl;
import com.JobPortal.DaoImpl.PostJobDaoImpl;
import com.JobPortal.Model.CompanyModel;
import com.JobPortal.Model.PostJobModel;

@WebServlet("/PostJobController")
public class PostJobController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PostJobController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String companyid1 = request.getParameter("companyid");
			String JobTitle = request.getParameter("jobtitle");
			String EnterSalary = request.getParameter("salary");
			String EnterExperience = request.getParameter("experience");
			String JobCategory = request.getParameter("category");
			

			int companyid = Integer.parseInt(companyid1);
			int salary = Integer.parseInt(EnterSalary);
        
			int postId =0;
			Date postDate = null;
			PostJobModel objpost = new PostJobModel(companyid,postId,JobTitle,salary,EnterExperience,JobCategory,postDate);
         
          PostJobDaoImpl postDao = new PostJobDaoImpl();
          postDao.postJobs(objpost);
			
			   response.getWriter().print("Post Job Suceessfully");
				
				response.sendRedirect("Recruiter.jsp");
				
				
			
		} catch (Exception e) {
			System.out.println(e);
		}

			
		
			}
	}


