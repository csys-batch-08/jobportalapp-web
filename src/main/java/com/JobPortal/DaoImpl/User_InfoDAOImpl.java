package com.JobPortal.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.JobPortal.Connection.ConnectionUtil;
import com.JobPortal.Dao.UserInfoInterface;
import com.JobPortal.Model.User_Info;

public class User_InfoDAOImpl implements UserInfoInterface {

	Scanner sc = new Scanner(System.in);

	public void insert(User_Info str) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnection();
			String query = " insert into User_Info( first_name,  last_name, user_name,gender,email_Id,  password,  mobile_number)"
					+ "values (?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, str.getFirstname());
			stmt.setString(2, str.getLastname());
			stmt.setString(3, str.getUsername());
			stmt.setString(4, str.getGender());
			stmt.setString(5, str.getEmailId());
			stmt.setString(6, str.getPassword());
			stmt.setLong(7, str.getMobilenumber());
			stmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, stmt);
		}
	}

	public boolean login(String emailId, String Password) {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDBconnection();
			String query = "select first_Name,last_Name,user_Name,gender,email_Id,password,mobile_Number from User_info "
					+ "where email_id= ? and password= ? ";
			stmt = con.prepareStatement(query);
			stmt.setString(1, emailId);
			stmt.setString(2, Password);
			int i = stmt.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return false;
	}
}