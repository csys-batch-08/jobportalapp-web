package com.JobPortal.Model;

import java.io.Serializable;
import java.util.Date;

public class JobStatusModel implements Serializable {

	private int postID;
	private int ApplicantID;
	private String status;
	private int companyId;
	private String companyName;
	private String email;
	private String jobTitle;
	private Date appliedDate;
	private String applicantName;
	private String address;
	private String skill;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public int getApplicantID() {
		return ApplicantID;
	}

	public void setApplicantID(int applicantID) {
		ApplicantID = applicantID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobStatusModel(int postID, int applicantID, String status) {
		super();
		this.postID = postID;
		ApplicantID = applicantID;
		this.status = status;
	}

	public JobStatusModel() {
		super();

	}

	@Override
	public String toString() {
		return "JobStatusModel [postID=" + postID + ", ApplicantID=" + ApplicantID + ", status=" + status + "]";
	}
}