package com.cg.banking.services;

import java.util.List;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.exceptions.InsufficientAmountException;

public interface BankingServices {
	Account openAccount(String accountType, float initBalance)
			throws InvalidAccountTypeException, InvalidAmountException, BankingServicesDownException;
	
	float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException;
	
	float withdrawAmount(long accountNo, float amount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException;
	
	boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException;
	
	Account getAccountDetails(long accountNo)
			throws AccountNotFoundException, BankingServicesDownException;
	
	List<Account> getAllAccountDetails() throws BankingServicesDownException;
	
	List<Transaction> getAccountAllTransaction (long accountNo)
			throws BankingServicesDownException, AccountNotFoundException;
	
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException;
	
	public Transaction getAccountTransaction(long accountNo, int transId);
}
