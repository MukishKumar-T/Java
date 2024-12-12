package service;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import dao.TransactionDAO;
import dao.TransactionDAOImpl;
import exception.InvalidTransactionAmountException;
import exception.TransactionFailureException;
import utility.TransactionHistoryUtil;

public class TransactionService {
	private final TransactionDAO transactionDAO;
	private final ExecutorService executorService;
	
	public TransactionService() {
		this.transactionDAO = new TransactionDAOImpl();
		this.executorService = Executors.newFixedThreadPool(5);
	}
//	future can return any data type 
	public Future<?> deposit(int accountId, double amount){
		return executorService.submit((Runnable) ()->{
		try {
		transactionDAO.deposit(accountId,amount);
		TransactionHistoryUtil.saveTransaction("Deposit", accountId, amount);
		System.out.println("Deposit Successful!");
		}
		catch(InvalidTransactionAmountException | SQLException | TransactionFailureException e) {
			System.err.println("Error during Deposit: "+e.getMessage());
		}
	});
	}
	public void shutDownExecutorService() {
		executorService.shutdown();
	}
}