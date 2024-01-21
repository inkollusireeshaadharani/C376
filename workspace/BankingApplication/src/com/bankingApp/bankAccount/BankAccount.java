package com.bankingApp.bankAccount;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class BankAccount implements Serializable{
	private long accountNumber;
	private long bSBCode;
	private String bankName;
	private transient double balance;
	private String openingDate;
	
	private double interestEarned;
	
	
	public BankAccount(long accountNumber, long bSBCode, String bankName, double balance, String openingDate) {
		this.accountNumber = accountNumber;
		this.bSBCode = bSBCode;
		this.bankName = bankName;
		this.balance = balance;
		this.openingDate = openingDate;
	}

	public abstract double calculateInterest();
	
	//getters and setters
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getBSBCode() {
		return bSBCode;
	}
	public void setBSBCode(long bSBCode) {
		this.bSBCode = bSBCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public double getInterestEarned() {
		return interestEarned;
	}

	public void setInterestEarned(double interestEarned) {
		this.interestEarned = interestEarned;
	}

	//toString
	@Override
	public String toString() {
		return "\t [accountNumber=" + accountNumber + "\t bSBCode=" + bSBCode + "\t bankName=" + bankName
				+ "\t balance=" + balance + "\t\t openingDate=" + openingDate + "\t interestEarned=" + interestEarned + "]";
	}
	
	
	
}
