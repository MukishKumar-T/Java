package model;

import java.util.Date;

public class WithdrawTransaction extends Transaction {
	private String withdrawalMethod;

	public WithdrawTransaction(int transactionId, int accountId, String transactionType, double amount,
			Date transactionDate, String withdrawalMethod) {
		super(transactionId, accountId, transactionType, amount, transactionDate);
		this.withdrawalMethod = withdrawalMethod;
	}

	public String getWithdrawalMethod() {
		return withdrawalMethod;
	}

	public void setWithdrawalMethod(String withdrawalMethod) {
		this.withdrawalMethod = withdrawalMethod;
	}

	@Override
	public String getTransactionDetails() {
		// TODO Auto-generated method stub
		return "transcation type is:"+ this.withdrawalMethod;
	}
}
