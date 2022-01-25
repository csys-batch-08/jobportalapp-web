package com.JobPortal.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JobPortal.DaoImpl.JobStatusDaoImpl;
import com.JobPortal.DaoImpl.User_InfoDAOImpl;
import com.JobPortal.Model.JobStatusModel;
import com.JobPortal.Model.User_Info;

@WebServlet("/UpdateApplicantStatus")
public class UpdateApplicantStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateApplicantStatus() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       

	try {
		String PostId = request.getParameter("postId");
		String ApplicantId = request.getParameter("applicantId");
		String Status = request.getParameter("status");
		

		int postId = Integer.parseInt(PostId);
		int applicantId = Integer.parseInt(ApplicantId);
		
    
		
      JobStatusModel objStatus = new JobStatusModel(postId,applicantId,Status);
		JobStatusDaoImpl statusDao = new JobStatusDaoImpl();
		statusDao.jobStatus(objStatus);
		
		   response.getWriter().print("Update Suceessfully");

			
		   response.sendRedirect("Recruiter.jsp");
		
	} catch (Exception e) {
		System.out.println(e);
	}

		
		}
}





