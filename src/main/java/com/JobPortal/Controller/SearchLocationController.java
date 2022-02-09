package com.JobPortal.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JobPortal.DaoImpl.PostJobDaoImpl;

import com.JobPortal.Model.PostJobModel;



@WebServlet("/SearchLocationController")
public class SearchLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchLocationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String Location = request.getParameter("location");			
		    PostJobDaoImpl search = new PostJobDaoImpl();		  
            List<PostJobModel> searchlist = search.SearchJobs(Location);           
            HttpSession session = request.getSession();
            session.setAttribute("Locations",searchlist );            
            response.sendRedirect("searchLocation.jsp"); 										
	    	} 
		catch (Exception e) {
			System.out.println(e);
			}	
	 }
}

