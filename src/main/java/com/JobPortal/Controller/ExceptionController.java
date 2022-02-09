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


@WebServlet("/exception")
public class ExceptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ExceptionController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String email = request.getParameter("email");  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
	    con=ConnectionUtil.getDBconnection();  
	    ps=con.prepareStatement("select company_id,company_name,user_name,user_role,phone_number,location,email,password,"
	    		                + "register_date from Company_login where EMAIL=?");  
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
