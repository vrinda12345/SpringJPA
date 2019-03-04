package com.cg.banking.test;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
import org.junit.Assert;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BankingServicesTestClass {
//	Account account=new Account();
//
//private static BankingServices service;
//	
//@BeforeClass
//public static void setUpTestEnv() {
//	service= new BankingServicesImpl();
//}
//@Before
//public void setUpTestData() {
//	
//	Account account1 = new Account(101,201,"Savings","Active",1000, account.transaction);
//	Account account2 = new Account( 102,202,"Savings","Active",1000, account.transaction);
//	BankingDBUtil.accounts.put(account1.getAccountNo(), account1);
//	BankingDBUtil.accounts.put(account2.getAccountNo(), account2);
//	
//	BankingDBUtil.ACCOUNT_NO=102;
//}
//@Test(expected= AccountNotFoundException.class)
//public void getAccountDetailsForInvalidData()throws InvalidAccountTypeException, 
//AccountNotFoundException, BankingServicesDownException{
//	service.getAccountDetails(458);
//}
//@Test
//public void getAccountDetailsForValidData() throws InvalidAccountTypeException, 
//BankingServicesDownException, AccountNotFoundException {
//	Account expectedAccount= new Account(101,201,"Savings","Active",1000, account.transaction);
//	Account actualAccount =service.getAccountDetails(101);
//	Assert.assertEquals(expectedAccount, actualAccount);
//}
//@Test(expected=AccountNotFoundException.class)
//public void testDepositForInvalidData() throws InvalidAccountTypeException, 
//AccountNotFoundException, BankingServicesDownException{
//	service.getAccountDetails(564);
//}
//@Test
//public void testDepositForValidData() throws InvalidAmountException, AccountNotFoundException,
//InvalidAccountTypeException, AccountBlockedException, com.cg.banking.exceptions.AccountNotFoundException, 
//BankingServicesDownException{
//	int expectedBalance =2000;
//    int actualBalance=  (int) service.depositAmount(101, 1000);
//    Assert.assertEquals(expectedBalance,actualBalance);
//}
//@Test
//public void testWithdrawForValidData() throws InsufficientAmountException, AccountNotFoundException,
//InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
//	long expectedBalance =500;
//	long actualBalance= (long)service.withdrawAmount(101, 500, 201);
//	Assert.assertEquals(expectedBalance, actualBalance);
//}
//@Test(expected=AccountNotFoundException.class)
//public void testWithdrawForInvalidData() throws AccountNotFoundException, InvalidAccountTypeException,
//InvalidAmountException, InvalidPinNumberException, AccountBlockedException, InsufficientAmountException, 
//AccountNotFoundException, BankingServicesDownException{
//	service.withdrawAmount(456, 622, 201);
//}
//@Test(expected=AccountNotFoundException.class)
//public void testFundTransferForInvalidData()throws AccountNotFoundException, InvalidAccountTypeException, 
//InvalidAmountException, InvalidPinNumberException, AccountBlockedException, InvalidAccountTypeException, 
//InsufficientAmountException, AccountNotFoundException, BankingServicesDownException{
//	service.fundTransfer(402, 506, 5000, 208);
//}
//@Test
//public void testfundTransferForValidData() throws AccountNotFoundException, InvalidAccountTypeException,
//InvalidAmountException, InvalidPinNumberException, AccountBlockedException, InvalidAccountTypeException,
//InsufficientAmountException,AccountNotFoundException, BankingServicesDownException{
//	long expectedDepositAccBal =1500;
//	long actualDepositAccBal=(long)service.depositAmount(102,500 );
//	Assert.assertEquals(expectedDepositAccBal, actualDepositAccBal);
//}
//@After
//public void tearDownTestData() {
//	BankingDBUtil.accounts.clear();
//	BankingDBUtil.ACCOUNT_NO=100;
//}
}