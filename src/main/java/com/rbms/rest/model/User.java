package com.rbms.rest.model;

public class User {
	
	private String fname;
	private String mname;
	private String lname;
	private String phone;
	private String email;
	private String dob;
	private String add;
	private String pan;
	private String pin;
	private String aadhar;
	private String acc_type;
	private String acc_num;
	private String amt;
	private String city;
	private String state;
	
	public User() {}
	
	public User(String fname, String mname, String lname, String phone, String email, String dob, String add,
			String pan, String pin, String aadhar, String acc_type, String acc_num, String amt, String city,
			String state) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.add = add;
		this.pan = pan;
		this.pin = pin;
		this.aadhar = aadhar;
		this.acc_type = acc_type;
		this.acc_num = acc_num;
		this.amt = amt;
		this.city = city;
		this.state = state;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getAcc_num() {
		return acc_num;
	}

	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
