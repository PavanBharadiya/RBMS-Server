package com.rbms.rest.model;

public class AccountAndTransaction 
{
    TransactionTable transaction_table;
    AccountTable account_table;
    public TransactionTable getTransaction_table() {
        return transaction_table;
    }
    public void setTransaction_table(TransactionTable transaction_table) {
        this.transaction_table = transaction_table;
    }
    public AccountTable getAccount_table() {
        return account_table;
    }
    public void setAccount_table(AccountTable account_table) {
        this.account_table = account_table;
    }
    public AccountAndTransaction(TransactionTable transaction_table, AccountTable account_table) {
        super();
        this.transaction_table = transaction_table;
        this.account_table = account_table;
    }
    public AccountAndTransaction() {
        super();
    }
    
}
