package com.JobPortal.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JobPortal.DaoImpl.ApplyJobDaoImpl;
import com.JobPortal.DaoImpl.CompanyProfileDaoImpl;
import com.JobPortal.Model.ApplyJob;

@WebServlet("/ViewApplicantControl")
public class ViewApplicantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewApplicantController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		
		HttpSession session=request.getSession();
		String email  =  (String)session.getAttribute("Email");		
		CompanyProfileDaoImpl comDao=new CompanyProfileDaoImpl();
		int postId;		
		postId = comDao.getEmploye(email);
		session.setAttribute("postId",postId );
		ApplyJobDaoImpl showJob = new   ApplyJobDaoImpl();
		List<ApplyJob> appliedList = new ArrayList<ApplyJob>();
		appliedList=showJob.showApplicant(email);		
		session.setAttribute("appliedList",appliedList );
		try {
			response.sendRedirect("viewApplicant.jsp");
		    } 
		catch (IOException e) 
			{			
			e.printStackTrace();
		    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}