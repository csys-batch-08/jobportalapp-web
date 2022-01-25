package com.JobPortal.Model;

import java.util.Date;

import javax.xml.crypto.Data;

public class PostJobModel {
	
	private int companyId;
	private String jobTitle;
	private int income;
	private String service;
	private String categories;
	private int postId;
	private Date postDate;
	private String companyName;
	private String location;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}

	public PostJobModel(int companyId, int postId, String jobTitle, int income, String service, String categories,Date postDate) {
		super();
		this.companyId = companyId;
		this.jobTitle = jobTitle;
		this.income = income;
		this.service = service;
		this.categories = categories;
		this.postId=postId;
		this.postDate=postDate;
	
	}
	public PostJobModel() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	@Override
	public String toString() {
		return "PostJobModel [companyId=" + companyId + ", jobTitle=" + jobTitle + ", income=" + income + ", service="
				+ service + ", categories=" + categories +"]";
	}
	public PostJobModel(int companyId,String companyName,int postId, int income, String jobTitle,String location,String service) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.postId = postId;
		this.income = income;
		this.jobTitle = jobTitle;	
		this.location = location;
		this.service= service;
	}
	
	

}
