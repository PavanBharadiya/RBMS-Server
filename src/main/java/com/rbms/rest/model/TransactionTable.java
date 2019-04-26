package com.rbms.rest.model;

public class TransactionTable 
{	
	private String tx_id;
	private String branch_code;
	private String acc_no;
	private String cust_id;
	private String tx_type;
	private String tx_time;
	private String tx_desc;
	private String acc_balance;
	private String tx_amount;
    public String getTx_id() {
        return tx_id;
    }
    public void setTx_id(String tx_id) {
        this.tx_id = tx_id;
    }
    public String getBranch_code() {
        return branch_code;
    }
    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }
    public String getAcc_no() {
        return acc_no;
    }
    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }
    public String getCust_id() {
        return cust_id;
    }
    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }
    public String getTx_type() {
        return tx_type;
    }
    public void setTx_type(String tx_type) {
        this.tx_type = tx_type;
    }
    public String getTx_time() {
        return tx_time;
    }
    public void setTx_time(String tx_time) {
        this.tx_time = tx_time;
    }
    public String getTx_desc() {
        return tx_desc;
    }
    public void setTx_desc(String tx_desc) {
        this.tx_desc = tx_desc;
    }
    public String getAcc_balance() {
        return acc_balance;
    }
    public void setAcc_balance(String acc_balance) {
        this.acc_balance = acc_balance;
    }
    public String getTx_amount() {
        return tx_amount;
    }
    public void setTx_amount(String tx_amount) {
        this.tx_amount = tx_amount;
    }
    
    public TransactionTable(String tx_id, String branch_code, String acc_no, String cust_id, String tx_type,
            String tx_time, String tx_desc, String acc_balance, String tx_amount) {
        super();
        this.tx_id = tx_id;
        this.branch_code = branch_code;
        this.acc_no = acc_no;
        this.cust_id = cust_id;
        this.tx_type = tx_type;
        this.tx_time = tx_time;
        this.tx_desc = tx_desc;
        this.acc_balance = acc_balance;
        this.tx_amount = tx_amount;
    }
    public TransactionTable() {
        super();
    }
}
