package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import exception.BankingException;
import exception.InvalidAccountTypeException;
import model.Account;
import model.Bank;
import model.CurrentAccount;
import model.SavingsAccount;
import service.AccountService;
import service.BankService;
import service.TransactionService;

public class BankController {{
}
   private final AccountService accountService;
   private final BufferedReader br;
   private final BankService bankservice;
   private final TransactionService transactionService;
   
   public BankController() {
	   this.accountService = new AccountService();
	   this.br  = new BufferedReader(new InputStreamReader(System.in));
	   this.bankservice=new BankService();
	   this.transactionService = new TransactionService();
   }
   
   public void start() throws NumberFormatException, IOException, SQLException, BankingException, InvalidAccountTypeException, InterruptedException, ExecutionException {
	   boolean running  = true;
	   
	   while(running) {
		   displayMenu();
		   int choice  = Integer.parseInt(br.readLine());
		   
		   switch(choice) {
		   	case 1:
		   		createAccount();
		   		break;
		   	case 2:
		   		updateAccount();
		   		break;
		   	case 3:
				this.deleteAccount();
				break;
		   	case 4:
		   		this.Deposit();
		   		break;
			case 0:
				running = false;
				transactionService.shutDownExecutorService();
				System.out.println("Exiting application.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
		   }
	   }         
   }
 

public void displayMenu() {
	   System.out.println("--------Banking Application---------");
	   System.out.println("1. Create Account");
	   System.out.println("2. Update");
	   System.out.println("3. Delete Account");
	   System.out.println("4. Deposit");
	   System.out.println("0. Exit");
	   System.out.println("Enter your choice: ");
   }
   

	private Account createAccount() throws NumberFormatException, IOException, SQLException, BankingException, InvalidAccountTypeException {
	   System.out.println("Enter customer ID: ");
	   int cusId = Integer.parseInt(br.readLine());
	   System.out.println("enter Bank Id: ");
	   int bankId = Integer.parseInt(br.readLine());
	   Bank bank=bankservice.getBankById(bankId);
	   System.out.println("Enter Account Type(Savings /Current");
	   String accountType = br.readLine();
	   System.out.println("Enter Initial Balance");
	   double bal = Double.parseDouble(br.readLine());
	   
	   if("Savings".equalsIgnoreCase(accountType)) {
		   System.out.println("Enter Interest Rate: ");
		   double interest = Double.parseDouble(br.readLine());
		   accountService.createAccount(new SavingsAccount(0,cusId,bank,accountType,bal,interest));
	   }
	   else if("Current".equalsIgnoreCase(accountType)) {
		   System.out.println("Enter OverldraftLimit");
		   double overdraft = Double.parseDouble(br.readLine());
		   accountService.createAccount(new CurrentAccount(0,cusId,bank,accountType,bal,overdraft));
	   }
	   else {
		   System.out.println("Invalid Account Type");
	   }
	   return null;
	}
	public void updateAccount() throws NumberFormatException, IOException, SQLException, InvalidAccountTypeException {
		System.out.println("Enter Account Id: ");
		int accId = Integer.parseInt(br.readLine());
		System.out.print("Enter Customer Id: ");
		int cusId  = Integer.parseInt(br.readLine());
		System.out.print("Enter Account Type: ");
		String accType = br.readLine();
		System.err.print("Enter Initial Balance: ");
		double bal = Double.parseDouble(br.readLine());
	
		accountService.updateAccount(accId,cusId,accType,bal);
	}
	public void deleteAccount() throws NumberFormatException, IOException, SQLException {
		System.out.println("Enter the Account Id : ");
		int accId=Integer.parseInt(br.readLine());
		accountService.deleteAccount(accId);
	}
	public void Deposit() throws NumberFormatException, IOException, InterruptedException, ExecutionException {
		System.out.println("Enter Account Id");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter Amount to be Deposited");
		double amount = Double.parseDouble(br.readLine());
//		TransactionService transactionService = null;
		Future<?> future = transactionService.deposit(id,amount);
		future.get();
	}
}