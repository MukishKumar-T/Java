
package model;

public abstract class Account {
	private int accountId;
	private int customerId;
	private Bank bank;
	private String accountType;
	private double balance;
	
	public Account(int accountId, int customerId, Bank bank, String accountType, double balance) {
		super();
		this.setAccountId(accountId);
		this.setCustomerId(customerId);
		this.setBank(bank);
		this.setAccountType(accountType);
		this.setBalance(balance);
	}
	
	public abstract String getAccountDetails();
	public abstract String toString();
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
