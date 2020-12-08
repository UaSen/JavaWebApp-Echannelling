package com.echannelling.model;

public class Doctor {

	//declare private attributes
	private String dID;
	private String docName;
	private String NIC;
	private String phone;
	private String email;
	private String userName;
	private String password;
	private String specialization;
	
	//create default constructor
	public Doctor() {
		
	}

	//overloaded constructor for all private attributes
	public Doctor(String dID, String docName, String nIC, String phone, String email, String userName, String password,
			String specialization) {
		super();
		this.dID = dID;
		this.docName = docName;
		NIC = nIC;
		this.phone = phone;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.specialization = specialization;
	}

	//overloaded constructor for private attributes without dID
	public Doctor(String docName, String nIC, String phone, String email, String userName, String password,
			String specialization) {
		super();
		this.docName = docName;
		NIC = nIC;
		this.phone = phone;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.specialization = specialization;
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

	//get method to get private attribute NIC
	public String getNIC() {
		return NIC;
	}

	//set method to set value for private attribute NIC
	public void setNIC(String nIC) {
		NIC = nIC;
	}

	//get method to get private attribute phone
	public String getPhone() {
		return phone;
	}

	//set method to set value for private attribute phone
	public void setPhone(String phone) {
		this.phone = phone;
	}

	//get method to get private attribute email
	public String getEmail() {
		return email;
	}

	//set method to set value for private attribute email
	public void setEmail(String email) {
		this.email = email;
	}

	//get method to get private attribute userName
	public String getUserName() {
		return userName;
	}

	//set method to set value for private attribute userName
	public void setUserName(String userName) {
		this.userName = userName;
	}

	//get method to get private attribute password
	public String getPassword() {
		return password;
	}

	//set method to set value for private attribute password
	public void setPassword(String password) {
		this.password = password;
	}

	//get method to get private attribute specialization
	public String getSpecialization() {
		return specialization;
	}

	//set method to set value for private attribute specialization
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	//convert in to strings
	@Override
	public String toString() {
		return "Doctor [dID=" + dID + ", docName=" + docName + ", NIC=" + NIC + ", phone=" + phone + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + ", specialization=" + specialization + "]";
	}
	
	
	
	
	
	
}
