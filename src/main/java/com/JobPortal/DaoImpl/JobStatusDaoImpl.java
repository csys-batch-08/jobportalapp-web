package com.JobPortal.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JobPortal.Connection.ConnectionUtil;
import com.JobPortal.Dao.JobStatusInterface;
import com.JobPortal.Model.JobStatusModel;
import com.JobPortal.Model.PostJobModel;



public class JobStatusDaoImpl implements JobStatusInterface {
	
	public void jobStatus(JobStatusModel pc) throws ClassNotFoundException, SQLException {
		
		Connection con= ConnectionUtil.getDBconnection();
		String query = " insert into job_status(post_id,applicant_id,status)values(?,?,?)";
		
		PreparedStatement stmt= con.prepareStatement(query);
		stmt.setInt(1, pc.getPostID());
		stmt.setInt(2, pc.getApplicantID());
		stmt.setString(3, pc.getStatus());
		
		stmt.executeUpdate();
		System.out.println("Update Applicant Status Successfully");
	
		
	}
	public List<JobStatusModel> updateStatus() throws ClassNotFoundException, SQLException {
		 
		 
		 String query ="select * from job_status";
		 JobStatusModel statusUpdate;
		 List<JobStatusModel> update= new ArrayList<JobStatusModel>();
		 Connection con=ConnectionUtil.getDBconnection();
		 PreparedStatement ps =con.prepareStatement(query);
		 
		 ResultSet rs=ps.executeQuery();
		 
		
		 while(rs.next())
		 {
			 statusUpdate= new JobStatusModel(rs.getInt(1),rs.getInt(2),rs.getString(3));
		
			 update.add(statusUpdate);
		
		  }
	 
		 return update;
	 }

	
	public void updateJobStatusDao(JobStatusModel pc1)throws ClassNotFoundException, SQLException {
		
		 Connection con=ConnectionUtil.getDBconnection();
		
		String update = "update job_status set applicant_id=?,status=? where post_id=?";
		System.out.println(update);
		PreparedStatement stmt = con.prepareStatement(update);
		 	
		stmt.setInt(1, pc1.getApplicantID());
		stmt.setString(2, pc1.getStatus());
		stmt.setInt(3, pc1.getPostID());
		
			System.out.println(stmt.executeUpdate() + " is updated !!");
		 
	}
	
}
