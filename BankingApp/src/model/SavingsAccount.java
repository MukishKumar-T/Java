package model;

public class SavingsAccount extends Account{
	private double interestRate;
	
	public SavingsAccount(int accountId, int customerId, Bank bank, String accountType, double balance, double interestRate) {
		super(accountId, customerId, bank, accountType, balance);
		this.setInterestRate(interestRate);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String getAccountDetails() {
		// TODO Auto-generated method stub
		return "Savings class with interest rate "+this.interestRate; 
	}

	public String toString() {
		return "Savings Account Details : Account Id : "+this.getAccountId()+
				"Customer Id : "+this.getCustomerId()+
				"Bank : "+this.getBank()+
				"Account Type : "+this.getAccountType()+
				"Balance : "+this.getBalance()+
				"OverdraftLimit : "+this.getInterestRate();
	}	
}