package com.rbms.rest.model;

public class AccountAndTransaction 
{
    TransactionTable transactionTable;
    AccountTable accountTable;
    
    public TransactionTable getTransactionTable() {
        return transactionTable;
    }
    public void setTransactionTable(TransactionTable transactionTable) {
        this.transactionTable = transactionTable;
    }
    public AccountTable getAccountTable() {
        return accountTable;
    }
    public void setAccountTable(AccountTable accountTable) {
        this.accountTable = accountTable;
    }
    
    public AccountAndTransaction(TransactionTable transactionTable, AccountTable accountTable) {
        super();
        this.transactionTable = transactionTable;
        this.accountTable = accountTable;
    }
    public AccountAndTransaction() {
        super();
    }
    
}
