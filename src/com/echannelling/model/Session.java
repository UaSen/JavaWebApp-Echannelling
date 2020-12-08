package com.echannelling.model;

public class Session {

	//declare private attributes
	private String sID;
	private String hID;
	private String dID;
	private String docName;
	private String day;
	private String time;
	private String avalability;
	private String fee;
	
	//create default constructor
	public Session() {
		super();
	}

	//overloaded constructor for all private attributes
	public Session(String sID, String hID, String dID, String docName, String day, String time, String avalability,
			String fee) {
		super();
		this.sID = sID;
		this.hID = hID;
		this.dID = dID;
		this.docName = docName;
		this.day = day;
		this.time = time;
		this.avalability = avalability;
		this.fee = fee;
	}

	//overloaded constructor for private attributes without sID
	public Session(String hID, String dID, String docName, String day, String time, String avalability, String fee) {
		super();
		this.hID = hID;
		this.dID = dID;
		this.docName = docName;
		this.day = day;
		this.time = time;
		this.avalability = avalability;
		this.fee = fee;
	}

	//get method to get private attribute sID
	public String getsID() {
		return sID;
	}

	//set method to set value for private attribute sID
	public void setsID(String sID) {
		this.sID = sID;
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

	//get method to get private attribute day
	public String getDay() {
		return day;
	}

	//set method to set value for private attribute day
	public void setDay(String day) {
		this.day = day;
	}

	//get method to get private attribute time
	public String getTime() {
		return time;
	}

	//set method to set value for private attribute time
	public void setTime(String time) {
		this.time = time;
	}

	//get method to get private attribute avalability
	public String getAvalability() {
		return avalability;
	}

	//set method to set value for private attribute avalability
	public void setAvalability(String avalability) {
		this.avalability = avalability;
	}

	//get method to get private attribute fee
	public String getFee() {
		return fee;
	}

	//set method to set value for private attribute fee
	public void setFee(String fee) {
		this.fee = fee;
	}

	//convert in to strings
	@Override
	public String toString() {
		return "Session [sID=" + sID + ", hID=" + hID + ", dID=" + dID + ", docName=" + docName + ", day=" + day
				+ ", time=" + time + ", avalability=" + avalability + ", fee=" + fee + "]";
	}

	
	
	
	
	
}
