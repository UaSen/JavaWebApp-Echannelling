package com.echannelling.model;

public class Booking {

	//declare private attributes
	private String bID;
	private String hID;
	private String sID;
	private String dID;
	private String cName;
	private String cEmail;
	private String cNIC;
	private String cardName;
	private String cardNo;
	private String expDate;
	private String cvc;
	private String fee;	
	private String noOfBooking;
	

	//create default constructor
	public Booking() {
		super();
	}

	//overloaded constructor for private attributes without bID
	public Booking(String hID, String sID, String dID, String cName, String cEmail, String cNIC, String cardName,
			String cardNo, String expDate, String cvc, String fee) {
		super();
		this.hID = hID;
		this.sID = sID;
		this.dID = dID;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cNIC = cNIC;
		this.cardName = cardName;
		this.cardNo = cardNo;
		this.expDate = expDate;
		this.cvc = cvc;
		this.fee = fee;
	}

	//overloaded constructor for all private attributes
	public Booking(String bID, String hID, String sID, String dID, String cName, String cEmail, String cNIC,
			String cardName, String cardNo, String expDate, String cvc, String fee) {
		super();
		this.bID = bID;
		this.hID = hID;
		this.sID = sID;
		this.dID = dID;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cNIC = cNIC;
		this.cardName = cardName;
		this.cardNo = cardNo;
		this.expDate = expDate;
		this.cvc = cvc;
		this.fee = fee;
	}

	//get method to get private attribute bID
	public String getbID() {
		return bID;
	}

	//set method to set value for private attribute bID
	public void setbID(String bID) {
		this.bID = bID;
	}

	//get method to get private attribute hID
	public String gethID() {
		return hID;
	}

	//set method to set value for private attribute hID
	public void sethID(String hID) {
		this.hID = hID;
	}

	//get method to get private attribute sID
	public String getsID() {
		return sID;
	}

	//set method to set value for private attribute sID
	public void setsID(String sID) {
		this.sID = sID;
	}

	//get method to get private attribute dID
	public String getdID() {
		return dID;
	}

	//set method to set value for private attribute dID
	public void setdID(String dID) {
		this.dID = dID;
	}

	//get method to get private attribute cName
	public String getcName() {
		return cName;
	}

	//set method to set value for private attribute cName
	public void setcName(String cName) {
		this.cName = cName;
	}

	//get method to get private attribute cEmail
	public String getcEmail() {
		return cEmail;
	}

	//set method to set value for private attribute cEmail
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	//get method to get private attribute cNIC
	public String getcNIC() {
		return cNIC;
	}

	//set method to set value for private attribute cNIC
	public void setcNIC(String cNIC) {
		this.cNIC = cNIC;
	}

	//get method to get private attribute cardName
	public String getCardName() {
		return cardName;
	}

	//set method to set value for private attribute cardName
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	//get method to get private attribute cardNo
	public String getCardNo() {
		return cardNo;
	}

	//set method to set value for private attribute cardNo
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	//get method to get private attribute expDate
	public String getExpDate() {
		return expDate;
	}

	//set method to set value for private attribute expDate
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	//get method to get private attribute cvc
	public String getCvc() {
		return cvc;
	}

	//set method to set value for private attribute cvc
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	//get method to get private attribute fee
	public String getFee() {
		return fee;
	}

	//set method to set value for private attribute fee
	public void setFee(String fee) {
		this.fee = fee;
	}

	//get method to get private attribute noOfBooking
	public String getNoOfBooking() {
		return noOfBooking;
	}

	//set method to set value for private attribute noOfBooking
	public void setNoOfBooking(String noOfBooking) {
		this.noOfBooking = noOfBooking;
	}
	
	//convert in to strings
	@Override
	public String toString() {
		return "Booking [bID=" + bID + ", hID=" + hID + ", sID=" + sID + ", dID=" + dID + ", cName=" + cName
				+ ", cEmail=" + cEmail + ", cNIC=" + cNIC + ", cardName=" + cardName + ", cardNo=" + cardNo
				+ ", expDate=" + expDate + ", cvc=" + cvc + ", fee=" + fee + "]";
	}

	
	
}
