package dao;

import java.sql.SQLException;

import exception.InvalidTransactionAmountException;
import exception.TransactionFailureException;

public interface TransactionDAO {
	void deposit(int acccountId,double amount) throws InvalidTransactionAmountException, SQLException, TransactionFailureException;
	void withdraw(int accountId,double amount);
	void transactionFunds(int fromAccount,int toAccount, double amount );
}