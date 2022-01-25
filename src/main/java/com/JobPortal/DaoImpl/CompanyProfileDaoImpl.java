package com.JobPortal.DaoImpl;

import com.JobPortal.Connection.ConnectionUtil;
import com.JobPortal.Dao.CompanyProfileInterface;
import com.JobPortal.Model.CompanyModel;
import com.JobPortal.Model.PostJobModel;
import com.JobPortal.Model.User_Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CompanyProfileDaoImpl implements CompanyProfileInterface {

	Scanner sc = new Scanner(System.in);
	
	public void insertCompanyProfile(CompanyModel str1)throws ClassNotFoundException, SQLException

	{						
		Connection con= ConnectionUtil.getDBconnection();
		String queries = " insert into Company_login( company_id,company_name,  user_name,user_role, phone_number, location,email, password)values (?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt= con.prepareStatement(queries);
		
		stmt.setInt(1, str1.getCompanyId());
		stmt.setString(2, str1.getCompanyName());
		stmt.setString(3, str1.getUserName());
		stmt.setString(4, str1.getUserRole());
		stmt.setLong(5, str1.getPhoneNumber());
		stmt.setString(6, str1.getLocation());
		stmt.setString(7, str1.getEmail());
		stmt.setString(8, str1.getPassword());
		
		
		stmt.executeUpdate();
		System.out.println("Company Profile Registered Successfully");		
	}
	
	public  boolean companyLogin(String email, String Password) throws ClassNotFoundException, SQLException {
		
				
		    Connection con = ConnectionUtil.getDBconnection();
				
		    String query = "select * from Company_login where email= ? and password= ? ";
				
		    PreparedStatement stmt = con.prepareStatement(query);
		    
		    System.out.println("Registered ");
				
		    stmt.setString(1, email);
			stmt.setString(2, Password);
				
			int i = stmt.executeUpdate();
				
if(i>0)
{
				return true;

				//System.out.println("welcome "+rs.getString("first_name") );
				}else {
						return false;
				}
	}

	public void updateCompanyProfile (CompanyModel str11) throws ClassNotFoundException, SQLException {
		
		 Connection con=ConnectionUtil.getDBconnection();
		
		String update = "update Company_login set  company_id = ?,company_name =?,  user_name =?,user_role =?, phone_number=?, location=?,email=? where  password=? ";
		 PreparedStatement stmt = con.prepareStatement(update);
		 
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
	
//	public void viewCompanyProfile (CompanyModel st) throws ClassNotFoundException, SQLException {
//		
//		 Connection con=ConnectionUtil.getDBconnection();
//		
//		String update = "select * from Company_login where email=? ";
//		 PreparedStatement stmt = con.prepareStatement(update);
//		 
//		 
//			stmt.setString(1, st.getEmail());
//			
//					 
//		 int res = stmt.executeUpdate();
//
//			System.out.println(res + " is updated !!");
//		 
//	}
	 public int getEmployee(String email) throws ClassNotFoundException, SQLException {
		 
		 
		 String query ="select * from Company_login where email=?";
		 CompanyModel showJobs;
		 List<CompanyModel> viewJobs= new ArrayList<CompanyModel>();
		 Connection con=ConnectionUtil.getDBconnection();
		 PreparedStatement ps =con.prepareStatement(query);
		 ps.setString(1, email);
		 ResultSet rs=ps.executeQuery();
		 int companyId=0;
		
		 if(rs.next())
		 {
			 showJobs= new CompanyModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getString(8));
		
			 companyId=	 rs.getInt(1);
			 return rs.getInt(1);
		
		  }
	 
		 return companyId;
	 }
	
	}

