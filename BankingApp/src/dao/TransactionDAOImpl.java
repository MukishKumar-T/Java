package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import exception.InvalidTransactionAmountException;
import exception.TransactionFailureException;
import utility.DBConnection;

public class TransactionDAOImpl implements TransactionDAO{

	@Override
	public void deposit(int accountId, double amount) throws InvalidTransactionAmountException, SQLException, TransactionFailureException {
		// TODO Auto-generated method stub
		if(amount <= 0) {
			throw new InvalidTransactionAmountException("Invalid amount to deposit");
		}
		try(Connection con  = DBConnection.getConnection()){
			CallableStatement st = con.prepareCall("{CALL depositFunds(?,?)}");
			st.setInt(1, accountId);
			st.setDouble(2, amount);
			st.execute();
		}
		catch(SQLException e) {
			throw new TransactionFailureException("Deposit Failed"+"e.getMessage()");
		}
	}

	@Override
	public void withdraw(int accountId, double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transactionFunds(int fromAccount, int toAccount, double amount) {
		// TODO Auto-generated method stub
		
	}
}