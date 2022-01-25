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

@WebServlet("/SearchExperienceController")
public class SearchExperienceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchExperienceController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   		try {
			String Experience = request.getParameter("experience");
			
			
		  PostJobDaoImpl search = new PostJobDaoImpl();
		  
            List<PostJobModel> searchlist = search.SearchExp(Experience);
            
            
           HttpSession session = request.getSession();
            session.setAttribute("Experience",searchlist );
            
            response.sendRedirect("searchExperience.jsp");
			
       
			   response.getWriter().print("Search Suceessfully");

				
			
		} catch (Exception e) {
			System.out.println(e);
			
		}

			System.out.println("welcome");
		
			}
}

