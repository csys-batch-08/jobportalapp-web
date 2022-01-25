package com.JobPortal.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.JobPortal.Connection.ConnectionUtil;
import com.JobPortal.Dao.PostJobInterface;
import com.JobPortal.Model.ApplyJob;
import com.JobPortal.Model.PostJobModel;


public class PostJobDaoImpl implements PostJobInterface {
	
Scanner sc = new Scanner(System.in);
	
	public void postJobs(PostJobModel str2)throws ClassNotFoundException, SQLException

	{
		
		Connection con= ConnectionUtil.getDBconnection();
		String queries = " insert into posting_job( company_id,  job_title, salary,experience , category)values (?,?,?,?,?)";
	
		PreparedStatement stmt= con.prepareStatement(queries);
		
		stmt.setInt(1, str2.getCompanyId());
		stmt.setString(2, str2.getJobTitle());
		stmt.setInt(3, str2.getIncome());
		stmt.setString(4, str2.getService());
		stmt.setString(5, str2.getCategories());
					
		stmt.executeUpdate();
		System.out.println("Job Post Successfully");
		//System.out.println(str2.getCompanyId());
	}
//	public void deleteJob(PostJobModel st) throws ClassNotFoundException, SQLException {
//		
//		Connection con= ConnectionUtil.getDBconnection();
//		String queries = "delete from posting_job where post_id=?";
//		PreparedStatement stmt= con.prepareStatement(queries);
//		stmt.setInt(1, st.getPostId());
//		
//		stmt.executeUpdate();
//	}
	
// public void postJob() throws ClassNotFoundException, SQLException {
//		 
//		 
//		 String query ="select * from posting_job";
//		 
//		 Connection con=ConnectionUtil.getDBconnection();
//		 PreparedStatement ps =con.prepareStatement(query);
//		 
//		 ResultSet rs=ps.executeQuery();
//		 		
//		 while(rs.next())
//		 {
//			 
//		 System.out.println("\n" +"Companyid :  \t " +rs.getInt(1)+"\n" +"Post ID :  \t"+rs.getInt(2)+"\n"+"job title : \t"+rs.getString(3)+"\n"+"Salary :  \t"+rs.getInt(4)+"\n"
//		+"Experience : \t" +rs.getString(5)+"\n"+"Category : \t"+rs.getString(6));
//		 }
//		
//}
 public List<PostJobModel> showJobs() throws ClassNotFoundException, SQLException {
	 
	 
	 String query ="select * from posting_job";
	 PostJobModel showJobs;
	 List<PostJobModel> viewJobs= new ArrayList<PostJobModel>();
	 Connection con=ConnectionUtil.getDBconnection();
	 PreparedStatement ps =con.prepareStatement(query);
	 
	 ResultSet rs=ps.executeQuery();
	 
	
	 while(rs.next())
	 {
		 showJobs= new PostJobModel(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDate(7));
	
		 viewJobs.add(showJobs);
	
	  }
 
	 return viewJobs;
 }

public void deletePostJob(int postId ) throws ClassNotFoundException, SQLException {
	try {
	 Connection con=ConnectionUtil.getDBconnection();
	 
	 String Query = "delete from posting_job where post_id ="+postId;
	 String queries = "delete from apply_job where post_id ="+postId;
	 String querie = " delete from job_status where post_id ="+postId;
	
	 
	 
	 PreparedStatement ps3 =con.prepareStatement(querie);
	 PreparedStatement ps2 =con.prepareStatement(queries);
	 PreparedStatement ps1 =con.prepareStatement(Query);
	 
	 
	System.out.println(ps1.executeUpdate()+"post job row deleted");
	System.out.println(ps2.executeUpdate()+"application deleted");
	System.out.println(ps3.executeUpdate()+"Job status deleted");
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
} 	 

	public void insertPostJobDao (PostJobModel str21) throws ClassNotFoundException, SQLException {
		
		 Connection con=ConnectionUtil.getDBconnection();
		
		String update = "update posting_job set job_title=?,salary=?,experience=?,category=? where company_id=? ";
		 PreparedStatement stmt = con.prepareStatement(update);
		 
		 stmt.setString(1, str21.getJobTitle());
		 stmt.setInt(2, str21.getIncome());
		 stmt.setString(3, str21.getService());
		 stmt.setString(4, str21.getCategories());
		 stmt.setInt(5,str21.getCompanyId() );
		 
		 int res = stmt.executeUpdate();

			System.out.println(res + " is updated !!");
		 
	}
	
	
// public void searchBySalary(int salary ) throws ClassNotFoundException, SQLException {
//		 
//		 
//		 String query ="select p.company_id,c.company_name,p.post_id,p.job_title from posting_job p ,Company_login where c.company_id=p.company_id and p.salary = ? "; 
//		 Connection con=ConnectionUtil.getDBconnection();
//		 PreparedStatement ps =con.prepareStatement(query);
//		 
//		 ps.setInt(1, salary );
//		 
//		 ResultSet rs=ps.executeQuery();
//		 		
//		 while(rs.next())
//		 {
//			 
//		 System.out.println("\n" +"CompanyId : " +rs.getInt(1)+"\n" +"Company name :  "+rs.getString(2)+"\n"+"Post Id : "+rs.getInt(3)+"\n"+"Job Title : "+rs.getString(4));
//		 }
//		
//		
//}
// 
 
// public void searchByExperience(String experience ) throws ClassNotFoundException, SQLException {
//	 
//	 
//	 String query ="select p.company_id,c.company_name,p.post_id,p.job_title,p.salary  from posting_job p ,Company_login c\r\n"
//	 		+ "where c.company_id=p.company_id and p.experience = ?";
//	 Connection con=ConnectionUtil.getDBconnection();
//	 PreparedStatement ps =con.prepareStatement(query);
//	 
//		 ps.setString(1, experience);
//	 
//	 ResultSet rs=ps.executeQuery();
//	 		
//	 while(rs.next())
//	 {
//		 
//	 System.out.println("\n" +"CompanyId :   " +rs.getInt(1)+"\n" +"Company name :  "+rs.getString(2)+"\n"+"Post Id : "+rs.getInt(3)+"Job Title : "+rs.getString(4)+"\n"+"Salary :   " +rs.getInt(5));
//	 }
//	
//}
 
// public void searchByLocation(String location1 ) throws ClassNotFoundException, SQLException {
//	 
//	 
//	 String query ="select p.company_id,c.company_name,p.post_id,p.job_title,p.salary  from posting_job p ,Company_login c\r\n"
//	 		+ "where c.company_id=p.company_id and c.location = ?";
//	
//	 Connection con=ConnectionUtil.getDBconnection();
//	 PreparedStatement ps =con.prepareStatement(query);
//	 
//		 ps.setString(1, location1);
//	 
//	 ResultSet rs=ps.executeQuery();
//	 		
//	 while(rs.next())
//	 {
//		 
//	 System.out.println("\n" +"CompanyId :   " +rs.getInt(1)+"\n" +"Company name :  "+rs.getString(2)+"\n"+"Post Id : "+rs.getInt(3)+"\n"+"Job Title : "+rs.getString(4)+"\n"+"Salary :   " +rs.getInt(5));
//	 }
// }
public List<PostJobModel> SearchJobs(String Location) throws ClassNotFoundException, SQLException {
	 
	 
	 String query =  "select p.company_id,c.company_name,p.post_id,p.salary,p.job_title,c.location,p.experience  from posting_job p ,Company_login c\r\n"
	 		+ "		 		where c.company_id=p.company_id and c.location = ?";
	 PostJobModel showJobs;
	 List<PostJobModel> viewJobs= new ArrayList<PostJobModel>();
	 Connection con=ConnectionUtil.getDBconnection();
	 PreparedStatement ps =con.prepareStatement(query);
	 
	 ps.setString(1, Location);
	 ResultSet rs=ps.executeQuery();
	 
	
	 while(rs.next())
	 {
		 showJobs= new PostJobModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
	
		 viewJobs.add(showJobs);
	
	  }
 
	 return viewJobs;
 }
public List<PostJobModel> SearchExp(String Experience) throws ClassNotFoundException, SQLException {
	 
	 
	 String query =  "select p.company_id,c.company_name,p.post_id,p.salary,p.job_title,c.location,p.experience  from posting_job p ,Company_login c\r\n"
	 		+ "		 		where c.company_id=p.company_id and p.experience = ?";
	 PostJobModel showJobs;
	 List<PostJobModel> viewJobs= new ArrayList<PostJobModel>();
	 Connection con=ConnectionUtil.getDBconnection();
	 PreparedStatement ps =con.prepareStatement(query);
	 
	 ps.setString(1, Experience);
	 ResultSet rs=ps.executeQuery();
	 
	
	 while(rs.next())
	 {
		 showJobs= new PostJobModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
	
		 viewJobs.add(showJobs);
	
	  }

	 return viewJobs;
}
public List<PostJobModel> SearchSal(int salary) throws ClassNotFoundException, SQLException {
	 
	 
	 String query =  "select p.company_id,c.company_name,p.post_id,p.salary,p.job_title,c.location,p.experience  from posting_job p ,Company_login c\r\n"
	 		+ "		 		where c.company_id=p.company_id and p.salary = ?";
	 PostJobModel showJobs;
	 List<PostJobModel> viewJobs= new ArrayList<PostJobModel>();
	 Connection con=ConnectionUtil.getDBconnection();
	 PreparedStatement ps =con.prepareStatement(query);
	 
	 ps.setInt(1, salary);
	 ResultSet rs=ps.executeQuery();
	 
	
	 while(rs.next())
	 {
		 showJobs= new PostJobModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
	
		 viewJobs.add(showJobs);
	
	  }

	 return viewJobs;
}
public List<PostJobModel> SearchCom(String company) throws ClassNotFoundException, SQLException {
	 
	 
	 String query =  "select p.company_id,c.company_name,p.post_id,p.salary,p.job_title,c.location,p.experience  from posting_job p ,Company_login c\r\n"
	 		+ "		 		where c.company_id=p.company_id and c.company_name = ?";
	 PostJobModel showJobs;
	 List<PostJobModel> viewJobs= new ArrayList<PostJobModel>();
	 Connection con=ConnectionUtil.getDBconnection();
	 PreparedStatement ps =con.prepareStatement(query);
	 
	 ps.setString(1, company);
	 ResultSet rs=ps.executeQuery();
	 
	
	 while(rs.next())
	 {
		 showJobs= new PostJobModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
	
		 viewJobs.add(showJobs);
	
	  }

	 return viewJobs;
}
 
//public void searchByCompany(String CompanyName ) throws ClassNotFoundException, SQLException {
//	 
//	 
//	 String query ="select p.company_id,c.company_name,p.post_id,p.job_title,p.salary  from posting_job p ,Company_login where c.company_id=p.company_id and c.company_name = ?";
//	 		
//	
//	 Connection con=ConnectionUtil.getDBconnection();
//	 PreparedStatement ps =con.prepareStatement(query);
//	 
//		 ps.setString(1, CompanyName);
//	 
//	 ResultSet rs=ps.executeQuery();
//	 		
//	 while(rs.next())
//	 {
//		 
//	 System.out.println("\n" +"CompanyId :   " +rs.getInt(1)+"\n" +"Company name :  "+rs.getString(2)+"\n"+"Post Id : "+rs.getInt(3)+"\n"+"Job Title : "+rs.getString(4)+"\n"+"Salary :   " +rs.getInt(5));
//	 }
// }

@Override
public void postJob() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
}

@Override
public void searchByExperience(String experience) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
}

@Override
public void searchByLocation(String location1) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
}

@Override
public void searchBySalary(int salary) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
}

@Override
public void searchByCompany(String CompanyName) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteJob(PostJobModel st) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
}
}