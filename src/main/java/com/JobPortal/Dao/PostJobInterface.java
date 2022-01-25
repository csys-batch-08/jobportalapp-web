package com.JobPortal.Dao;

import java.sql.SQLException;

import com.JobPortal.Model.PostJobModel;


public interface PostJobInterface {

	public void postJobs(PostJobModel str2) throws ClassNotFoundException, SQLException;
	public void postJob() throws ClassNotFoundException, SQLException;
	public void deletePostJob(int postId) throws ClassNotFoundException, SQLException;
	public void insertPostJobDao (PostJobModel str21) throws ClassNotFoundException, SQLException;
	 public void searchBySalary(int salary ) throws ClassNotFoundException, SQLException;
	 public void searchByExperience(String experience ) throws ClassNotFoundException, SQLException;
	 public void searchByLocation(String location1 ) throws ClassNotFoundException, SQLException;
	 public void searchByCompany(String CompanyName ) throws ClassNotFoundException, SQLException;
	 public void deleteJob(PostJobModel st) throws ClassNotFoundException, SQLException;
}
