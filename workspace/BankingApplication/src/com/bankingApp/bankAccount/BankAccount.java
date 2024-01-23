package com.bankingApp.bankAccount;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class BankAccount implements Serializable{
	private long accountNumber;
	private long bSBCode;
	private String bankName;
//	private transient double balance;
	private double balance;
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
		System.out.print(String.format("%-15s%-10s","accountNumber:",this.getAccountNumber()));
		System.out.print(String.format("%-11s%-9s","IFSC CODE:",this.getBSBCode()));
		System.out.print(String.format("%-10s%-10s","bankName:",this.getBankName()));
		System.out.print(String.format("%-10s%-10s","balance:",this.getBalance()));
		System.out.print(String.format("%-10s%-10s","balance:",this.getInterestEarned()));
		System.out.println(String.format("%-14s%-15s","openingDate:",this.getOpeningDate()));
		System.out.println();
		return "";
	}
	
	
	
}
