package com.JobPortal.Model;

import java.sql.Date;
import java.time.LocalDate;

public class ApplyJob {
	
	
	private int postId;
	private String applicantName;
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private String qualification;
	private String skill;
	private int age;
	private String email;
	private String password;
	private String address;
	private long phoneNumber;
	private int applicantId;
	private Date date;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ApplyJob(int postId, String applicantName, String qualification, String skill, int age, String email,
			String password, String address, long phoneNumber) {
		super();
		this.postId = postId;
		this.applicantName = applicantName;
		this.qualification = qualification;
		this.skill = skill;
		this.age = age;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public ApplyJob() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApplyJob(int applicantId, int postId, String applicantName, String qualification, String skill, int age, String email,
			String address, long phoneNumber, Date date) {
			this.applicantId=applicantId;
			this.postId=postId;
			this.applicantName=applicantName;
			this.qualification=qualification;
			this.skill=skill;
			this.age=age;
			this.email=email;
			this.address=address;
			this.phoneNumber=phoneNumber;
			this.date=date;
	}
	public ApplyJob(int postId, String applicantName, String qualification, String skill, int age, String email,
			String password, String address, long phoneNumber, int applicantId, Date date) {
		super();
		this.postId = postId;
		this.applicantName = applicantName;
		this.qualification = qualification;
		this.skill = skill;
		this.age = age;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.applicantId = applicantId;
		this.date = date;
	}
	@Override
	public String toString() {
		return "ApplyJob [postId=" + postId + ", applicantName=" + applicantName + ", qualification=" + qualification
				+ ", skill=" + skill + ", age=" + age + ", email=" + email + ", password=" + password + ", address="
				+ address + ", phoneNumber=" + phoneNumber + "]";
	}
	public ApplyJob(int postId,int applicantId, String applicantName, String qualification, int age, String email,
			String address, long phoneNumber,String skill, Date date) {
		super();
		this.postId = postId;
		this.applicantId = applicantId;

		this.applicantName = applicantName;
		this.qualification = qualification;
		this.age = age;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;

		this.skill = skill;
		this.date = date;
	}
	
	
	
	

}
