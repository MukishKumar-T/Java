package dao;

import java.sql.SQLException;

import exception.InvalidAccountTypeException;
import model.Account;

public interface AccountDAO {
	
	void createAccount(Account account) throws InvalidAccountTypeException;

	void updateAccount(int accId, int cusId, String accType, double bal) throws SQLException, InvalidAccountTypeException;

	public void deleteAccount(int accountId) throws SQLException;
}
