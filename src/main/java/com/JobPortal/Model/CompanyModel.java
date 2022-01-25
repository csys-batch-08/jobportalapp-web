package com.JobPortal.Model;

public class CompanyModel {

	private int companyId;
	private String companyName;
	private String userName;
	private String userRole;
	private long phoneNumber = 0;
	private String location;
	private String email;
	private String password;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CompanyModel(int companyId, String companyName, String userName, String userRole, long phoneNumber,
			String location, String email, String password) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.userName = userName;
		this.userRole = userRole;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.email = email;
		this.password = password;
	}
	public CompanyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CompanyModel [companyId=" + companyId + ", companyName=" + companyName + ", userName=" + userName
				+ ", userRole=" + userRole + ", phoneNumber=" + phoneNumber + ", location=" + location + ", email="
				+ email + ", password=" + password + "]";
	}
	
	
	
	
		
}
