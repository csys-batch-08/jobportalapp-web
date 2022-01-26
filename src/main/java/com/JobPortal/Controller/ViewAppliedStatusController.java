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

import com.JobPortal.DaoImpl.JobStatusDaoImpl;
import com.JobPortal.Model.JobStatusModel;

@WebServlet("/ViewAppliedStatusControl")
public class ViewAppliedStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewAppliedStatusController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobStatusDaoImpl status = new   JobStatusDaoImpl();
		List<JobStatusModel> update = new ArrayList<JobStatusModel>();
		try {
			update=status.updateStatus();
			HttpSession session=request.getSession();
			session.setAttribute("update",update );
			response.sendRedirect("ViewAppliedStatus.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
