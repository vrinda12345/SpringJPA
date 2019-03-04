package com.cg.banking.client;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;


public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bankingBeans.xml");
		BankingServices services=(BankingServices) context.getBean("bankingServices");

		int totalTries = 3, pinNumber;
		long accountNo;
		float amount, currBalance;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Services: ");
			System.out.println("1. Open Account");
			System.out.println("2. Cash Withdrawl");
			System.out.println("3. Cash Deposit");
			System.out.println("4. Fund Transfer");
			System.out.println("5. Account Details");
			System.out.println("6. All Account Details");
			System.out.println("7. e-Passbook");
			System.out.println("8. find Transaction");
			System.out.println("9. exit");
			System.out.println("Enter your Choice");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter Account type");
				String accountType = sc.next().toLowerCase();
				System.out.println("Deposit cash for initial balance");
				float initBalance = sc.nextFloat();
				
				try {
					Account account = services.openAccount(accountType, initBalance);
					System.out.println("Account Number: " + account.getAccountNo());
					System.out.println("Pin Number: " + account.getPinNumber());
					System.out.println(account.getTransaction().values());
				} catch (InvalidAccountTypeException | InvalidAmountException | BankingServicesDownException e) {
					e.printStackTrace();
				}
				
				break;
			
			case 2:
				System.out.println("Enter Account Number");
				accountNo = sc.nextLong();
				System.out.println("Enter Withdrawl Amount");
				amount = sc.nextFloat();
				System.out.println("Enter Pin Number");
				pinNumber = sc.nextInt();
				int tries = 0;
				
				while(++tries <= totalTries) {
					try {
						System.out.println("Current Balance: " + services.withdrawAmount(accountNo, amount, pinNumber));
						break;
					} catch (InsufficientAmountException | AccountNotFoundException
							| BankingServicesDownException | AccountBlockedException e) {
						e.printStackTrace();
					} catch(InvalidPinNumberException e) {
						System.out.println(e.getMessage());
						System.out.println("Tries left: " + (totalTries-tries));
						pinNumber = sc.nextInt();
					}
				}
				if(tries>totalTries) {
					try {
						services.getAccountDetails(accountNo).setAccountStatus("blocked");
					} catch (AccountNotFoundException | BankingServicesDownException e) {
						e.printStackTrace();
					}
				}
				break;
				
			case 3:
				System.out.println("Enter Account Number");
				accountNo = sc.nextLong();
				System.out.println("Enter Deposit Amount");
				amount = sc.nextFloat();
				
				try {
					System.out.println("Current Balance: " + services.depositAmount(accountNo, amount));
				} catch (AccountNotFoundException | BankingServicesDownException | AccountBlockedException e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Enter account from which you want to transfer amount");
				long accountFrom = sc.nextLong();
				System.out.println("Enter account to which you want to transfer amount ");
				long accountTo = sc.nextLong();
				System.out.println("Enter Transfer Amount");
				amount = sc.nextFloat();
				System.out.println("Enter Pin Number");
				pinNumber = sc.nextInt();
				
				try {
					services.fundTransfer(accountTo, accountFrom, amount, pinNumber);
				} catch (InsufficientAmountException | AccountNotFoundException | InvalidPinNumberException
						| BankingServicesDownException | AccountBlockedException e) {
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.out.println("Enter Account Number: ");
				accountNo = sc.nextLong();
				try {
					System.out.println(services.getAccountDetails(accountNo).toString());
				} catch (AccountNotFoundException | BankingServicesDownException e) {
					e.printStackTrace();
				}
				break;
				
			case 6:
				try {
					System.out.println(services.getAllAccountDetails());
				} catch (BankingServicesDownException e) {
					e.printStackTrace();
				}
				break;
				
			case 7:
				System.out.println("Enter Account Number: ");
				accountNo = sc.nextLong();
				try {
					List<Transaction> transactions = services.getAccountAllTransaction(accountNo);
					for(int i=0; i<transactions.size(); i++) {
						System.out.println(transactions.get(i).toString());
					}
				} catch (BankingServicesDownException | AccountNotFoundException e) {
					e.printStackTrace();
				}
				break;
			
			case 8:
				System.out.println("Enter account number");
				accountNo = sc.nextLong();
				System.out.println("Transaction Id");
				int transId = sc.nextInt();
				System.out.println(services.getAccountTransaction(accountNo, transId));
				break;
			case 9:
				System.exit(0);
			}
		}
	}
}


