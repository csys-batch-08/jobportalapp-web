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
import com.JobPortal.DaoImpl.PostJobDaoImpl;
import com.JobPortal.Model.PostJobModel;

@WebServlet("/RecruiterViewJobsControl")
public class RecruiterViewJobsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public RecruiterViewJobsController() {
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
		PostJobDaoImpl show = new   PostJobDaoImpl();
			List<PostJobModel> job = new ArrayList<PostJobModel>();
			
			try {
				
				job=show.viewJobs(email);
				
				session.setAttribute("job",job );
				
				response.sendRedirect("recruiterViewPostJobs.jsp");
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
