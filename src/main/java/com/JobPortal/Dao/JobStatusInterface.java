package com.JobPortal.Dao;

import java.sql.SQLException;

import com.JobPortal.Model.JobStatusModel;


public interface JobStatusInterface {

	public void jobStatus(JobStatusModel pc) throws ClassNotFoundException, SQLException;
	public void updateJobStatusDao(JobStatusModel pc1) throws ClassNotFoundException, SQLException;
	
}
