package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Bank;
import utility.DBConnection;

public class BankDAOImpl implements BankDAO {

	
	@Override
	public Bank getBankById(int bankId) throws SQLException {
		String query = "select * from bank where bankId=?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, bankId);
			ResultSet rs = ps.executeQuery();
			String bankName="", bankBranch="";
			while(rs.next()) {
			bankName = rs.getString("bankName");
			bankBranch = rs.getString("bankBranch");
			}
			return new Bank(bankId, bankName, bankBranch);
		}
	}
}