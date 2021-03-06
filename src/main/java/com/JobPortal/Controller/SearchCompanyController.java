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

@WebServlet("/SearchCompanyController")
public class SearchCompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchCompanyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String company = request.getParameter("company");
			PostJobDaoImpl search = new PostJobDaoImpl();
			List<PostJobModel> searchlist = search.SearchCom(company);
			HttpSession session = request.getSession();
			session.setAttribute("company", searchlist);
			response.sendRedirect("searchCompany.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
