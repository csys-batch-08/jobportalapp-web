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

@WebServlet("/SearchSalaryController")
public class SearchSalaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SearchSalaryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

   		try {
		String salary =request.getParameter("salary");
		
		
		
	  PostJobDaoImpl search = new PostJobDaoImpl();
	  
        List<PostJobModel> searchlist = search.SearchSal(Integer.parseInt(salary));
        
        
       HttpSession session = request.getSession();
        session.setAttribute("salary",searchlist );
        
        response.sendRedirect("searchSalary.jsp");
		
	} catch (Exception e) {
		System.out.println(e);
		
	}

		}
}

