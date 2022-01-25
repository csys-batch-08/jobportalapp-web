package com.JobPortal.Dao;

import java.sql.SQLException;
import java.util.List;

import com.JobPortal.Model.ApplyJob;



public interface ApplyJobInterface {

	public void applyJob(ApplyJob str3) throws ClassNotFoundException, SQLException;
	public List<ApplyJob> showApplicant() throws ClassNotFoundException, SQLException;
	public void viewAppliedJobStatus() throws ClassNotFoundException, SQLException;
}
