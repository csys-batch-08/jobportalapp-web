package com.JobPortal.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.JobPortal.Connection.ConnectionUtil;
import com.JobPortal.Dao.ApplyJobInterface;
import com.JobPortal.Model.ApplyJob;



public class ApplyJobDaoImpl implements ApplyJobInterface{

	public void applyJob(ApplyJob str3) throws ClassNotFoundException, SQLException {
		
			Connection con= ConnectionUtil.getDBconnection();
			String query = " insert into Apply_Job( post_id,  applicant_name,qualification,skill, age, email, password,address,phone_number)values (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt= con.prepareStatement(query);
			
			stmt.setInt(1, str3.getPostId());
			stmt.setString(2, str3.getApplicantName());
			stmt.setString(3, str3.getQualification());
			stmt.setString(4, str3.getSkill());
			stmt.setInt(5, str3.getAge());
			stmt.setString(6, str3.getEmail());
			stmt.setString(7, str3.getPassword());
			stmt.setString(8, str3.getAddress());
			stmt.setLong(9, str3.getPhoneNumber());
			
			stmt.executeUpdate();
			System.out.println("Job applied successfully");
		}
			
	 public List<ApplyJob> showApplicant() throws ClassNotFoundException, SQLException {
		 
		 
		 String query ="select * from apply_job";
		 ApplyJob applicants;
		 List<ApplyJob> showApplicants= new ArrayList<ApplyJob>();
		 Connection con=ConnectionUtil.getDBconnection();
		PreparedStatement ps =con.prepareStatement(query);
		

		 ResultSet rs=ps.executeQuery();
		 
		
		
		 while(rs.next())
		 {
		//	applicants= new ApplyJob(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(8),rs.getString(9),rs.getLong(10),rs.getDate(11));
			applicants= new ApplyJob(rs.getInt("Applicant_id"),rs.getInt("Post_id"),rs.getString("Applicant_name"),rs.getString("Qualification"),rs.getInt("Age"),rs.getString("Email"),rs.getString("Address"),rs.getLong("Phone_number"),rs.getString("Skill"),rs.getDate("Apply_Date"));

			 showApplicants.add(applicants);
			

		  }
	 
		 return showApplicants;

	 }
 
 public void viewAppliedJobStatus() throws ClassNotFoundException, SQLException {
	 
	 
	 String query ="select * from job_status";
	 
	 Connection con=ConnectionUtil.getDBconnection();
	 PreparedStatement ps =con.prepareStatement(query);
	 
	 ResultSet rs=ps.executeQuery();
	 		
	 while(rs.next())
	 {
		 
	 System.out.println("\n" +"PostId :   " +rs.getInt(1)+"\n" +"Applicant ID :  "+rs.getInt(2)+"\n"+"job status : "+rs.getString(3));
	 }
	}
	}

