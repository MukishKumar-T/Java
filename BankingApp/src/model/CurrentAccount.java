package model;

public class CurrentAccount extends Account{
	private double overDraftLimit;

	public CurrentAccount(int accountId, int customerId, Bank bank, String accountType, double balance,
			double overDraftLimit) {
		super(accountId, customerId, bank, accountType, balance);
		this.overDraftLimit = overDraftLimit;
	}

	public double getOverdraftLimit() {
		return overDraftLimit;
	}

	public void setOverdraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public String getAccountDetails() {
		return "Current Account with overdraft limit: "+this.overDraftLimit;
	}

	@Override
	public String toString() {
		return "Current Account Details : Account Id : "+this.getAccountId()+
				"Customer Id : "+this.getCustomerId()+
				"Bank : "+this.getBank()+
				"Account Type : "+this.getAccountType()+
				"Balance : "+this.getBalance()+
				"OverdraftLimit : "+this.getOverdraftLimit();
	}	
}
