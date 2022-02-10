package com.JobPortal.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.JobPortal.DaoImpl.User_InfoDAOImpl;
import com.JobPortal.Model.User_Info;

@WebServlet("/UserRegisterController")
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String gender = request.getParameter("gender");
			String mailid = request.getParameter("mailid");
			String password = request.getParameter("password");
			String PhoneNumber = request.getParameter("mobilenumber");
			long phonenumber = Long.parseLong(PhoneNumber);
			User_Info objUserInfo = new User_Info(firstname, lastname, username, gender, mailid, password, phonenumber);
			User_InfoDAOImpl RegDao = new User_InfoDAOImpl();
			RegDao.insert(objUserInfo);
			response.sendRedirect("userLogin.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}