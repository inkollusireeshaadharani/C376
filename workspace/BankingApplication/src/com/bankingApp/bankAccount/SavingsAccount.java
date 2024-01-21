package com.bankingApp.bankAccount;

import com.bankingApp.exp.InsufficientFundsException;

@SuppressWarnings("serial")
public class SavingsAccount extends BankAccount {
	private boolean isSalaryAccount;
	public static final double DEFAULT_BALANCE = 100; 
	
	
	public SavingsAccount(long accountNumber, long bSBCode, String bankName, 
			double balance, String openingDate, boolean isSalaryAccount) {
		super(accountNumber, bSBCode, bankName, balance, openingDate);
		this.isSalaryAccount = isSalaryAccount;
	}
	public boolean isSalaryAccount() {
		return isSalaryAccount;
	}
	public void setSalaryAccount(boolean isSalaryAccount) {
		this.isSalaryAccount = isSalaryAccount;
	}
	public double withdraw(double amount) throws InsufficientFundsException {
		if(!this.isSalaryAccount && this.getBalance()< DEFAULT_BALANCE) {
			throw new InsufficientFundsException("Insufficient funds");
		}
		else if(this.getBalance()< amount) {
			throw new InsufficientFundsException("Insufficient funds");
		}
		this.setBalance(this.getBalance()-amount);
		return this.getBalance();
	}
	public double deposit(double amount){
		this.setBalance(this.getBalance()+amount);
		return this.getBalance();
	}
	@Override
	public double calculateInterest() {
		this.setInterestEarned((0.04) * this.getBalance());
		return getInterestEarned();
	}
	
}
