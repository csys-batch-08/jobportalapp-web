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

import com.JobPortal.DaoImpl.CompanyProfileDaoImpl;
import com.JobPortal.DaoImpl.JobStatusDaoImpl;
import com.JobPortal.Model.JobStatusModel;

@WebServlet("/AppliedJobControl")
public class AppliedJobController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AppliedJobController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		String email  =  (String)session.getAttribute("Email");
		System.out.println(email);
		CompanyProfileDaoImpl comDao=new CompanyProfileDaoImpl();
		int postId;
		
try {
			
	postId = comDao.getEmploye(email);
			session.setAttribute("postId",postId );
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		JobStatusDaoImpl status = new   JobStatusDaoImpl();
		List<JobStatusModel> update = new ArrayList<JobStatusModel>();
		try {
			update=status.updateStatus();
			
			 session.setAttribute("updates",update );
			 response.sendRedirect("appliedJobStatus.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
