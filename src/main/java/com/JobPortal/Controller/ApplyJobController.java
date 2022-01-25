package com.JobPortal.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JobPortal.DaoImpl.ApplyJobDaoImpl;
import com.JobPortal.DaoImpl.PostJobDaoImpl;
import com.JobPortal.Model.ApplyJob;
import com.JobPortal.Model.PostJobModel;


@WebServlet("/ApplyJobController")
public class ApplyJobController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ApplyJobController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String PostId = request.getParameter("postid");
			String ApplicantName = request.getParameter("applicantname");
			String Qualification = request.getParameter("qualification");
			String Skills = request.getParameter("skill");
			String Age = request.getParameter("age");
			String Email =request.getParameter("emailid");
			String Passsword = request.getParameter("password");
			String location = request.getParameter("city");
			String Phone = request.getParameter("mobilenumber");
			

			int postId = Integer.parseInt(PostId);
			int age = Integer.parseInt(Age);
			long phonenumber = Long.parseLong(Phone);
        
			ApplyJob objapply = new ApplyJob(postId,ApplicantName,Qualification,Skills,age,Email,Passsword,location,phonenumber);
         
          ApplyJobDaoImpl applyDao = new ApplyJobDaoImpl();
          applyDao.applyJob(objapply);
			
			   response.getWriter().print("Apply Job Suceessfully");
				
				response.sendRedirect("ApplicantHomePage.jsp");
				
				
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

}
