package com.rbms.rest.model;

public class TransactionTable {
	
	private String Tx_Id;
	private String Branch_Code;
	private String Acc_No;
	private String Cust_ID;
	private String Tx_Type;
	private String Tx_time;
	private String Tx_desc;
	private String Acc_Balance;
	private String Tx_amount;
    public String getTx_Id() {
        return Tx_Id;
    }
    public void setTx_Id(String tx_Id) {
        Tx_Id = tx_Id;
    }
    public String getBranch_Code() {
        return Branch_Code;
    }
    public void setBranch_Code(String branch_Code) {
        Branch_Code = branch_Code;
    }
    public String getAcc_No() {
        return Acc_No;
    }
    public void setAcc_No(String acc_No) {
        Acc_No = acc_No;
    }
    public String getCust_ID() {
        return Cust_ID;
    }
    public void setCust_ID(String cust_ID) {
        Cust_ID = cust_ID;
    }
    public String getTx_Type() {
        return Tx_Type;
    }
    public void setTx_Type(String tx_Type) {
        Tx_Type = tx_Type;
    }
    public String getTx_time() {
        return Tx_time;
    }
    public void setTx_time(String tx_time) {
        Tx_time = tx_time;
    }
    public String getTx_desc() {
        return Tx_desc;
    }
    public void setTx_desc(String tx_desc) {
        Tx_desc = tx_desc;
    }
    public String getAcc_Balance() {
        return Acc_Balance;
    }
    public void setAcc_Balance(String acc_Balance) {
        Acc_Balance = acc_Balance;
    }
    public String getTx_amount() {
        return Tx_amount;
    }
    public void setTx_amount(String tx_amount) {
        Tx_amount = tx_amount;
    }
    
    public TransactionTable(String tx_Id, String branch_Code, String acc_No, String cust_ID, String tx_Type,
            String tx_time, String tx_desc, String acc_Balance, String tx_amount) {
        super();
        Tx_Id = tx_Id;
        Branch_Code = branch_Code;
        Acc_No = acc_No;
        Cust_ID = cust_ID;
        Tx_Type = tx_Type;
        Tx_time = tx_time;
        Tx_desc = tx_desc;
        Acc_Balance = acc_Balance;
        Tx_amount = tx_amount;
    }
    
    public TransactionTable() {
        super();
    }
	
    
}
