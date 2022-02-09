package com.JobPortal.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JobPortal.DaoImpl.PostJobDaoImpl;

@WebServlet("/delete")
public class DeleteJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteJobs() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post = request.getParameter("postId");
		System.out.println(post);
		int PostID = Integer.parseInt(post);
		System.out.println(PostID);
		PostJobDaoImpl del = new PostJobDaoImpl();
		try {
			del.deletePostJob(PostID);
			response.sendRedirect("recruiter.jsp");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}catch (Exception e) {
			
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}
}