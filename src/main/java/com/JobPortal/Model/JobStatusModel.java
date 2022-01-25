package com.JobPortal.Model;

public class JobStatusModel {
	
	private int postID;
	private int ApplicantID;
	private String status;
	
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
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JobStatusModel [postID=" + postID + ", ApplicantID=" + ApplicantID + ", status=" + status + "]";
	}
	
	

}
