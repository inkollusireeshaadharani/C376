package com.bankingApp.model.bankaccount;

@SuppressWarnings("serial")
public class FixedDepositAccount extends BankAccount {
	public static final double MINIMUM_DEPOSIT_AMOUNT=1000;
	public static final int MIN_TENURE=1;
	public static final int MAX_TENURE=7;
	private int tenure;
	
	
	public FixedDepositAccount(long accountNumber, long bSBCode, String bankName, 
			double balance, String openingDate, int tenure) {
		super(accountNumber, bSBCode, bankName, balance, openingDate);
		this.tenure = tenure;
	}
	@Override
	public double calculateInterest() {
		this.setInterestEarned((0.08) * tenure * this.getBalance());
		return getInterestEarned();
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

}
