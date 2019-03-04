package com.cg.banking.daoservices;

import java.util.List;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;

public interface TransactionDAO {
	Transaction save(Transaction transaction);
	boolean update(Transaction transaction);
	List<Transaction> findAll(long accountNo);
	Transaction findOne(long accountNo, int transactionId);
}
