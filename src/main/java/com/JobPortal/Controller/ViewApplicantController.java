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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String email  =  (String)session.getAttribute("Email");
		
		CompanyProfileDaoImpl comDao=new CompanyProfileDaoImpl();
		int postId;
		
try {
			
	postId = comDao.getEmploye(email);
			session.setAttribute("postId",postId );
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		ApplyJobDaoImpl showJob = new   ApplyJobDaoImpl();
		List<ApplyJob> appliedList = new ArrayList<ApplyJob>();
		try {
			appliedList=showJob.showApplicant();
			
			session.setAttribute("appliedList",appliedList );
			response.sendRedirect("viewApplicant.jsp");

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
