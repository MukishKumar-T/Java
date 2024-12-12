package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.InvalidAccountTypeException;
import model.Account;
import utility.DBConnection;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public void createAccount(Account account) throws InvalidAccountTypeException {
		String sql ="Insert into Account(customerId, bankId, accountType, balance) values(?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
					ps.setInt(1, account.getCustomerId());
					ps.setInt(2, account.getBank().getBankId());
					ps.setString(3, account.getAccountType());
					ps.setDouble(4, account.getBalance());
					
					int result = ps.executeUpdate();
					if(result == 0) {
						throw new InvalidAccountTypeException(""+"Account type not recognized");
					}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//AccountDAOImpl
	public void updateAccount(int accId, int cusId, String accType, double bal) throws SQLException, InvalidAccountTypeException {
		String sql = "update Account set customerId = ?,accountType = ?,balance = ? where accountId = ?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			if(!("Savings".equalsIgnoreCase(accType) || "Current".equalsIgnoreCase(accType))) {
				throw new InvalidAccountTypeException("Account type not recognized");
			}
			ps.setInt(1,cusId);
			ps.setString(2,accType);
			ps.setDouble(3, bal);
			ps.setInt(4,accId);
				
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("Updated Successfully");
			}		
		}
	}
	public void deleteAccount(int accId) throws SQLException {
		String sql="delete  from Account where accountId = ?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			    ps.setInt(1,accId);
			    int result=ps.executeUpdate();
			    if(result>0) {
			    	System.out.println("Deleted Successfully");
			    }
		}
	}
}
