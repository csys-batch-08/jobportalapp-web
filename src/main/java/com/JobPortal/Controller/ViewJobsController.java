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
import com.JobPortal.DaoImpl.PostJobDaoImpl;
import com.JobPortal.Model.PostJobModel;

@WebServlet("/ViewJobsControl")
public class ViewJobsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewJobsController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		PostJobDaoImpl showJob = new PostJobDaoImpl();
		List<PostJobModel> jobList = new ArrayList<PostJobModel>();
		jobList = showJob.showJobs();
		HttpSession session = request.getSession();
		session.setAttribute("jobList", jobList);
		try {
			response.sendRedirect("viewJobs.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}