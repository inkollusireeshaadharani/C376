package com.bankingApp.bankAccount;

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
	@Override
	public double calculateInterest() {
		this.setInterestEarned((0.04) * this.getBalance());
		return getInterestEarned();
	}
	
}
