package dao;

import java.sql.SQLException;

import model.Bank;

public interface BankDAO {
	public Bank getBankById(int bankID) throws SQLException;
}