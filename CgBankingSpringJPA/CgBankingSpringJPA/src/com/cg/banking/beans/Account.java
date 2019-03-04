package com.cg.banking.beans;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountNo;
	private int pinNumber;
	private String accountType, accountStatus;
	private float accountBalanace;
	
	@OneToMany(mappedBy="account")
	@MapKey
	public Map<Long, Transaction> transaction =  new HashMap<Long, Transaction>();
	
	public void setTransaction(Map<Long, Transaction> transaction) {
		this.transaction = transaction;
	}

	public Account(String accountType, float accountBalanace) {
		super();
		this.accountType = accountType;
		this.accountBalanace = accountBalanace;
		this.transaction = new HashMap<Long, Transaction>();
	}

	public Account() {}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public float getAccountBalanace() {
		return accountBalanace;
	}

	public void setAccountBalanace(float accountBalanace) {
		this.accountBalanace = accountBalanace;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Map<Long, Transaction> getTransaction() {
		return transaction;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo +  ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", accountBalanace=" + accountBalanace + "]";
	}

	public Account(long accountNo, int pinNumber, String accountType, String accountStatus, float accountBalanace,
			Map<Long, Transaction> transaction) {
		super();
		this.accountNo = accountNo;
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalanace = accountBalanace;
		this.transaction = transaction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountBalanace);
		result = prime * result + (int) (accountNo ^ (accountNo >>> 32));
		result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + pinNumber;
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Float.floatToIntBits(accountBalanace) != Float.floatToIntBits(other.accountBalanace))
			return false;
		if (accountNo != other.accountNo)
			return false;
		if (accountStatus == null) {
			if (other.accountStatus != null)
				return false;
		} else if (!accountStatus.equals(other.accountStatus))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (pinNumber != other.pinNumber)
			return false;
		if (transaction == null) {
			if (other.transaction != null)
				return false;
		} else if (!transaction.equals(other.transaction))
			return false;
		return true;
	}	
	
}
