package com.rbms.rest.model;

public class Account 
{
	private String acc_no;
	private String branch_code;
	private String cust_id;
	private String acc_type;
	private String acc_balance;
	private String lasttransactiontime;
	private String lastqrtrfeedeductdate;
	private String transaction_count;
	private String credit_score;
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public String getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(String acc_balance) {
		this.acc_balance = acc_balance;
	}
	public String getLasttransactiontime() {
		return lasttransactiontime;
	}
	public void setLasttransactiontime(String lasttransactiontime) {
		this.lasttransactiontime = lasttransactiontime;
	}
	public String getLastqrtrfeedeductdate() {
		return lastqrtrfeedeductdate;
	}
	public void setLastqrtrfeedeductdate(String lastqrtrfeedeductdate) {
		this.lastqrtrfeedeductdate = lastqrtrfeedeductdate;
	}
	public String getTransaction_count() {
		return transaction_count;
	}
	public void setTransaction_count(String transaction_count) {
		this.transaction_count = transaction_count;
	}
	public String getCredit_score() {
		return credit_score;
	}
	public void setCredit_score(String credit_score) {
		this.credit_score = credit_score;
	}
	public Account(String acc_balance, String acc_no, String acc_type, String branch_code, String cust_id,  
			String lastqrtrfeedeductdate, String lasttransactiontime, String transaction_count, String credit_score) {
		
		this.acc_no = acc_no;
		this.branch_code = branch_code;
		this.cust_id = cust_id;
		this.acc_type = acc_type;
		this.acc_balance = acc_balance;
		this.lasttransactiontime = lasttransactiontime;
		this.lastqrtrfeedeductdate = lastqrtrfeedeductdate;
		this.transaction_count = transaction_count;
		this.credit_score = credit_score;
	}

	
	
}
