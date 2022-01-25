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
import com.JobPortal.DaoImpl.User_InfoDAOImpl;
import com.JobPortal.Model.PostJobModel;
import com.JobPortal.Model.User_Info;

/**
 * Servlet implementation class SearchLocationController
 */
@WebServlet("/SearchLocationController")
public class SearchLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLocationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	       

		try {
			String Location = request.getParameter("location");
			System.out.println(Location);
			
		  PostJobDaoImpl search = new PostJobDaoImpl();
		  
            List<PostJobModel> searchlist = search.SearchJobs(Location);
            
            
           HttpSession session = request.getSession();
            session.setAttribute("Location",searchlist );
            
            response.sendRedirect("searchLocation.jsp");
			
       
			   response.getWriter().print("Search Suceessfully");

							
		} catch (Exception e) {
			System.out.println(e);
			
		}

			System.out.println("welcome");
		
			}
}

