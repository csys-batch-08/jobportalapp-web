package com.JobPortal.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JobPortal.Connection.ConnectionUtil;


@WebServlet("/UserException")
public class UserRegisterEmailException extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserRegisterEmailException() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		String email = request.getParameter("email"); 
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		 con=ConnectionUtil.getDBconnection();   
		 ps=con.prepareStatement("select first_Name,last_Name,user_Name,gender,email_Id,password,mobile_Number from user_info where email_Id=?");  
		ps.setString(1, email);  
	    rs=ps.executeQuery();  
		if(rs.next())
		{
			
			PrintWriter write = response.getWriter();
			write.println("Email id Already Registered");
			System.out.println(email);

		}  
		}
		catch(Exception e)
		{
			

			e.printStackTrace();
			System.out.println(e);

		}
		finally {
			ConnectionUtil.close(con, ps, rs);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
