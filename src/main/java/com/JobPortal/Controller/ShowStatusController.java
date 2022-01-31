package com.JobPortal.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JobPortal.DaoImpl.ApplyJobDaoImpl;
import com.JobPortal.DaoImpl.PostJobDaoImpl;
import com.JobPortal.Model.ApplyJob;
import com.JobPortal.Model.PostJobModel;

@WebServlet("/ShowStatus")
public class ShowStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowStatusController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String Email = request.getParameter("email");
			System.out.println(Email);
		  ApplyJobDaoImpl search = new ApplyJobDaoImpl();
		  
            List<ApplyJob> searchStatus = search.viewStatusApplicant(Email);
            System.out.println(Email +"a");
            
           HttpSession session = request.getSession();
            session.setAttribute("Emails",searchStatus );
            System.out.println(Email +"b");
            System.out.println(session.getAttribute("Emails"));
            response.sendRedirect("showStatus.jsp");
										
		} catch (Exception e) {
			System.out.println(e);
			
		}

		
			}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
