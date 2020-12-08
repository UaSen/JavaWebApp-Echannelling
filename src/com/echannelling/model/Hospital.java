package com.echannelling.model;

public class Hospital {

	//declare private attributes
	private String hID;
	private String dID;
	private String docName;
	private String specialization;
	private String hName;
	
	//create default constructor
	public Hospital() {
		super();
	}

	//overloaded constructor for all private attributes
	public Hospital(String hID, String dID, String docName, String specialization, String hName) {
		super();
		this.hID = hID;
		this.dID = dID;
		this.docName = docName;
		this.specialization = specialization;
		this.hName = hName;
	}

	//overloaded constructor for private attributes without hID
	public Hospital(String dID, String docName, String specialization, String hName) {
		super();
		this.dID = dID;
		this.docName = docName;
		this.specialization = specialization;
		this.hName = hName;
	}

	//get method to get private attribute hID
	public String gethID() {
		return hID;
	}

	//set method to set value for private attribute hID
	public void sethID(String hID) {
		this.hID = hID;
	}

	//get method to get private attribute dID
	public String getdID() {
		return dID;
	}

	//set method to set value for private attribute dID
	public void setdID(String dID) {
		this.dID = dID;
	}

	//get method to get private attribute docName
	public String getDocName() {
		return docName;
	}

	//set method to set value for private attribute docName
	public void setDocName(String docName) {
		this.docName = docName;
	}

	//get method to get private attribute specialization
	public String getSpecialization() {
		return specialization;
	}

	//set method to set value for private attribute specialization
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	//get method to get private attribute hName
	public String gethName() {
		return hName;
	}

	//set method to set value for private attribute hName
	public void sethName(String hName) {
		this.hName = hName;
	}

	//convert in to strings
	@Override
	public String toString() {
		return "Hospital [hID=" + hID + ", dID=" + dID + ", docName=" + docName + ", specialization=" + specialization
				+ ", hName=" + hName + "]";
	}

	

	
	
}
