package com.JobPortal.Dao;

import java.sql.SQLException;

import com.JobPortal.Model.User_Info;

public interface UserInfoInterface {
	
	public void insert(User_Info str) throws ClassNotFoundException, SQLException;
	public boolean login(String Username, String Password) throws ClassNotFoundException, SQLException ;
	

}
