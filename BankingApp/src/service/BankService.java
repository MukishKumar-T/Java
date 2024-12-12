package service;

import java.sql.SQLException;

import dao.AccountDAOImpl;
import dao.BankDAO;
import dao.BankDAOImpl;
import exception.BankingException;
import model.Bank;

public class BankService {
	private final BankDAO bankDAO;
	public BankService() {
		this.bankDAO = new BankDAOImpl();
		new AccountDAOImpl();
	}
	
	public Bank getBankById(int bankId) throws SQLException,BankingException{
		return bankDAO.getBankById(bankId);
	}
}
