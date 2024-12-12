package service;

import java.sql.SQLException;

//import java.sql.SQLException;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import exception.InvalidAccountTypeException;
import model.Account;

public class AccountService {
	private final AccountDAO accountDAO ;
	
	public AccountService() {
		this.accountDAO = new AccountDAOImpl();
	}
	
	public void createAccount(Account account) throws InvalidAccountTypeException {
		accountDAO.createAccount(account);
	}

	public void updateAccount(int accId, int cusId, String accType, double bal) throws SQLException, InvalidAccountTypeException {
		// TODO Auto-generated method stub
		accountDAO.updateAccount(accId, cusId, accType, bal);
	}
	public void deleteAccount(int accId) throws SQLException{
		accountDAO.deleteAccount(accId);
	}
}