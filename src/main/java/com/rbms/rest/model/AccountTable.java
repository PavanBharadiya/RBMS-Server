package com.rbms.rest.model;

public class AccountTable 
{
	private String Acc_No;
	private String Branch_Code;
	private String Cust_ID;
	private String Acc_Type;
	private String Acc_Balance;
	private String LastTransactionTime;
	private String LastQrtrFeeDeductDate;
	private String Transaction_count;
	private String credit_score;
	
	public String getAcc_No() {
		return Acc_No;
	}
	public void setAcc_No(String acc_No) {
		Acc_No = acc_No;
	}
	public String getBranch_Code() {
		return Branch_Code;
	}
	public void setBranch_Code(String branch_Code) {
		Branch_Code = branch_Code;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	public String getAcc_Type() {
		return Acc_Type;
	}
	public void setAcc_Type(String acc_Type) {
		Acc_Type = acc_Type;
	}
	public String getAcc_Balance() {
		return Acc_Balance;
	}
	public void setAcc_Balance(String acc_Balance) {
		Acc_Balance = acc_Balance;
	}
	public String getLastTransactionTime() {
		return LastTransactionTime;
	}
	public void setLastTransactionTime(String lastTransactionTime) {
		LastTransactionTime = lastTransactionTime;
	}
	public String getLastQrtrFeeDeductDate() {
		return LastQrtrFeeDeductDate;
	}
	public void setLastQrtrFeeDeductDate(String lastQrtrFeeDeductDate) {
		LastQrtrFeeDeductDate = lastQrtrFeeDeductDate;
	}
	public String getTransaction_count() {
		return Transaction_count;
	}
	public void setTransaction_count(String transaction_count) {
		Transaction_count = transaction_count;
	}
	public String getCredit_score() {
		return credit_score;
	}
	public void setCredit_score(String credit_score) {
		this.credit_score = credit_score;
	}
	
	public AccountTable() 
	{
		super();
	}
	public AccountTable(String acc_No, String branch_Code, String cust_ID, String acc_Type, String acc_Balance,
			String lastTransactionTime, String lastQrtrFeeDeductDate, String transaction_count, String credit_score) {
		super();
		Acc_No = acc_No;
		Branch_Code = branch_Code;
		Cust_ID = cust_ID;
		Acc_Type = acc_Type;
		Acc_Balance = acc_Balance;
		LastTransactionTime = lastTransactionTime;
		LastQrtrFeeDeductDate = lastQrtrFeeDeductDate;
		Transaction_count = transaction_count;
		this.credit_score = credit_score;
	}
	
	
	
}
