package model;

import java.util.Date;

public abstract class Transaction {
	private int transactionId;
	public int getTransactionId() {
		return transactionId;
	}

	private int accountId;
	private String transactionType;
	private double amount;
	private Date transactionDate;
	
	public Transaction(int transactionId, int accountId, String transactionType, double amount, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}
	
	public abstract String getTransactionDetails();
	

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}
