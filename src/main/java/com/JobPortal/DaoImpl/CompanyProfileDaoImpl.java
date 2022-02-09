package com.JobPortal.DaoImpl;

import com.JobPortal.Connection.ConnectionUtil;
import com.JobPortal.Dao.CompanyProfileInterface;
import com.JobPortal.Model.CompanyModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CompanyProfileDaoImpl implements CompanyProfileInterface {

	Scanner sc = new Scanner(System.in);
	
	public void insertCompanyProfile(CompanyModel str1) {
	
		Connection con=null;
		PreparedStatement stmt=null;
		try {
		 con= ConnectionUtil.getDBconnection();
		 String queries = " insert into Company_login( company_id,company_name,  user_name,user_role, phone_number, location,email,"
		 		          + " password)values (?,?,?,?,?,?,?,?)";		
		 stmt= con.prepareStatement(queries);		
		 stmt.setInt(1, str1.getCompanyId());
		 stmt.setString(2, str1.getCompanyName());
		 stmt.setString(3, str1.getUserName());
		 stmt.setString(4, str1.getUserRole());
		 stmt.setLong(5, str1.getPhoneNumber());
		 stmt.setString(6, str1.getLocation());
		 stmt.setString(7, str1.getEmail());
	   	 stmt.setString(8, str1.getPassword());	
		 stmt.executeUpdate();
		   }
		catch(Exception e) {
			
		   }
		finally {
			ConnectionUtil.close(con, stmt);		
		   }
 }	
 public  boolean companyLogin(String email, String Password) {
		
		Connection con=null;
		PreparedStatement stmt=null;
    	try {
		    con = ConnectionUtil.getDBconnection();				
		    String query = "select company_id,company_name,user_name,user_role,phone_number,location,email,password,"
		    		      + "register_date from Company_login where email= ? and password= ? ";				
		    stmt = con.prepareStatement(query);    
		    stmt.setString(1, email);
			stmt.setString(2, Password);				
			int i = stmt.executeUpdate();				
            if(i>0)
            	{
				return true;
				}
            else 
            	{
				return false;
				}
			}
    	catch(Exception e) {
			
		    }finally {
			ConnectionUtil.close(con, stmt);
		    }
		return false;
	}

	public void updateCompanyProfile (CompanyModel str11)  {
		
		Connection con=null;
		PreparedStatement stmt=null;
		try {
		    con=ConnectionUtil.getDBconnection();		
		    String update = "update Company_login set  company_id = ?,company_name =?,  user_name =?,user_role =?, phone_number=?, "
				      + "location=?,email=? where  password=? ";
		    stmt = con.prepareStatement(update);		 
		    stmt.setInt(1, str11.getCompanyId());
			stmt.setString(2, str11.getCompanyName());
			stmt.setString(3, str11.getUserName());
			stmt.setString(4, str11.getUserRole());
			stmt.setLong(5, str11.getPhoneNumber());
			stmt.setString(6, str11.getLocation());
			stmt.setString(7, str11.getEmail());
			stmt.setString(8, str11.getPassword());			 
		    int res = stmt.executeUpdate();
			System.out.println(res + " is updated !!");
		   }
		catch(Exception e) {
			
		   }
		finally {
			ConnectionUtil.close(con, stmt);
		   }		 
	}
	

	 public int getEmployee(String email){
		 
		 Connection con=null;
		 PreparedStatement ps=null;
		 List<CompanyModel> viewJobs=null;
		 try {
		 String query ="select company_id,company_name,user_name,user_role,phone_number,location,email,password,register_date "
		 	        	+ "from Company_login where email=?";
		 CompanyModel showJobs;
		 viewJobs= new ArrayList<CompanyModel>();
		 con=ConnectionUtil.getDBconnection();
		 ps =con.prepareStatement(query);
		 ps.setString(1, email);
		 ResultSet rs=ps.executeQuery();
		 int companyId=0;		
		 if(rs.next())
		 {
			 showJobs= new CompanyModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),
					   rs.getString(6),rs.getString(7),rs.getString(8));		
			 companyId=	 rs.getInt(1);
			 return rs.getInt(1);		
		  }		 
		 }
		 catch(Exception e) {
			 
		 }
		 finally {
			 ConnectionUtil.close(con, ps);
		 }	 
		 int companyId=0;
		 return companyId;
	 }
	
 public int getEmploye(String email)  {
		 
	 List<CompanyModel> viewJob=null;
	 Connection con=null;
	 PreparedStatement ps=null;
	 ResultSet rs=null;
	 try {
		  String query ="select c.company_id,c.email,p.post_id from Company_login c,posting_job p "
		  		       + "where c.company_id=p.company_id and c.email=?";
		  CompanyModel showJob;
		  viewJob= new ArrayList<CompanyModel>();
		  con=ConnectionUtil.getDBconnection();
		  ps =con.prepareStatement(query);
		  ps.setString(1, email);
		  rs=ps.executeQuery();
		  int postId=0;		
		 if(rs.next())
		   {
			 showJob= new CompanyModel(rs.getInt(1),rs.getString(2),rs.getInt(3));		
			 postId=	 rs.getInt(3);
			 return rs.getInt(3);		
		   }
	     }
	 catch(Exception e) {
		 
	     }
	 finally {
		 ConnectionUtil.close(con, ps, rs);
	     }	 
		 int postId=0;
		 return postId;
	 }
}