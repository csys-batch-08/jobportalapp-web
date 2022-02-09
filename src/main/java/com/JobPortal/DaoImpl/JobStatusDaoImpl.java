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




public class JobStatusDaoImpl implements JobStatusInterface {
	
	public void jobStatus(JobStatusModel pc) {
		Connection con=null;
		PreparedStatement stmt=null;
		try {
		 con= ConnectionUtil.getDBconnection();
		 String query = " insert into job_status(post_id,applicant_id,status)values(?,?,?)";		
		 stmt= con.prepareStatement(query);
		 stmt.setInt(1, pc.getPostID());
		 stmt.setInt(2, pc.getApplicantID());
		 stmt.setString(3, pc.getStatus());		
		 stmt.executeUpdate();
		    }
		catch(Exception e) {
			
		    }
		finally {
			ConnectionUtil.close(con, stmt);
		    }	
	}
	public List<JobStatusModel> updateStatus(String email) {
		 
		 List<JobStatusModel> update=null;
		 Connection con=null;
		 PreparedStatement ps =null;
		 ResultSet rs=null;
		 try {
		 String query ="select c.company_id,c.company_name,c.email,a.applicant_id,a.applicant_name,a.address,a.skill,a.post_id,"
		 		+ "p.job_title,a.apply_date,d.status \r\n"
		 		+ "from apply_job a join posting_job p on a.post_id=p.post_id join Company_login c on p.company_id=c.company_id "
		 		+ "join job_status d on a.post_id=d.post_id \r\n"
		 		+ "where c.email=?\r\n"
		 		+ "order by a.apply_date desc";
		 JobStatusModel statusUpdate =null;
	     update= new ArrayList<JobStatusModel>();
		 con=ConnectionUtil.getDBconnection();
	     ps =con.prepareStatement(query);
		 ps.setString(1, email);
		 rs=ps.executeQuery();	 
		 while(rs.next())
		    {
			 statusUpdate = new JobStatusModel();
			 statusUpdate.setCompanyId(rs.getInt(1));
			 statusUpdate.setCompanyName(rs.getString(2));
			 statusUpdate.setEmail(rs.getString(3));
			 statusUpdate.setApplicantID(rs.getInt(4));
			 statusUpdate.setApplicantName(rs.getString(5));
			 statusUpdate.setAddress(rs.getString(6));
			 statusUpdate.setSkill(rs.getString(7));
			 statusUpdate.setPostID(rs.getInt(8));
			 statusUpdate.setJobTitle(rs.getString(9));
			 statusUpdate.setAppliedDate(rs.getDate(10));
			 statusUpdate.setStatus(rs.getString(11));			
			 update.add(statusUpdate);		
		    }
		  }
		 catch(Exception e) {
			 
		 }finally {
			 ConnectionUtil.close(con, ps, rs);
		 }
		 return update;
	 }	
	public void updateJobStatusDao(JobStatusModel pc1){
		
		PreparedStatement stmt=null;
		Connection con=null;
		try {
		 con=ConnectionUtil.getDBconnection();		
		 String update = "update job_status set applicant_id=?,status=? where post_id=?";		
		 stmt = con.prepareStatement(update);		 	
		 stmt.setInt(1, pc1.getApplicantID());
		 stmt.setString(2, pc1.getStatus());
		 stmt.setInt(3, pc1.getPostID());		
		 System.out.println(stmt.executeUpdate() + " is updated !!");
		}catch(Exception e) {
			
		}finally {
			ConnectionUtil.close(con, stmt);
		}
	}	
}