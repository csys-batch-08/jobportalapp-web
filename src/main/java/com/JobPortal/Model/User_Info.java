package com.JobPortal.Model;

public class User_Info {

	private String firstname;
	private String lastname;
	private String username;
	private String gender;
	private String emailId;
	private String password;
	private long mobilenumber ;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public User_Info(String firstname, String lastname, String username, String gender, String emailId, String password,
			long mobilenumber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
		this.mobilenumber = mobilenumber;
	}
	public User_Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User_Info [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", gender="
				+ gender + ", emailId=" + emailId + ", password=" + password + ", mobilenumber=" + mobilenumber + "]";
	}
	
	
}

