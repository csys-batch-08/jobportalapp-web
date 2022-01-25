package com.JobPortal.Dao;

import java.sql.SQLException;

import com.JobPortal.Model.CompanyModel;


public interface CompanyProfileInterface {

	public void insertCompanyProfile(CompanyModel str1) throws ClassNotFoundException, SQLException;
	public boolean companyLogin(String Username, String Password) throws ClassNotFoundException, SQLException;
	public void updateCompanyProfile (CompanyModel str11) throws ClassNotFoundException, SQLException;
}
