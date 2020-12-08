package com.echannelling.model;

public class Feedback {

	//declare private attributes
	private String feedbackID;
	private String email;
	private String subject;
	private String comment;
	
	//overloaded constructor for all private attributes
	public Feedback(String feedbackID, String email, String subject, String comment) {
		super();
		this.feedbackID = feedbackID;
		this.email = email;
		this.subject = subject;
		this.comment = comment;
	}

	//overloaded constructor for private attributes without feedbackID
	public Feedback(String email, String subject, String comment) {
		super();
		this.email = email;
		this.subject = subject;
		this.comment = comment;
	}

	//create default constructor
	public Feedback() {
		
	}

	//get method to get private attribute feedbackID
	public String getFeedbackID() {
		return feedbackID;
	}

	//set method to set value for private attribute feedbackID
	public void setFeedbackID(String feedbackID) {
		this.feedbackID = feedbackID;
	}

	//get method to get private attribute email
	public String getEmail() {
		return email;
	}

	//set method to set value for private attribute email
	public void setEmail(String email) {
		this.email = email;
	}

	//get method to get private attribute subject
	public String getSubject() {
		return subject;
	}

	//set method to set value for private attribute subject
	public void setSubject(String subject) {
		this.subject = subject;
	}

	//get method to get private attribute comment
	public String getComment() {
		return comment;
	}

	//set method to set value for private attribute comment
	public void setComment(String comment) {
		this.comment = comment;
	}
 
	//convert in to strings
	@Override
	public String toString() {
		return "Feedback [feedbackID=" + feedbackID + ", email=" + email + ", subject=" + subject + ", comment="
				+ comment + "]";
	}
	
	
	
	
}
