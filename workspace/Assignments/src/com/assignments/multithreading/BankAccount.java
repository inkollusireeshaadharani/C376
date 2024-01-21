package com.assignments.multithreading;

class Withdraw implements Runnable{
	
	BankAccount ba;
	
	public Withdraw(BankAccount ba) {
		this.ba = ba;
	}
	
	@Override
	public void run() {
		System.out.println("after withdraw "+ba.withdraw(100));
	}

}
class Deposit implements Runnable{
	
	BankAccount ba;
	
	public Deposit(BankAccount ba) {
		this.ba = ba;
	}
	
	@Override
	public void run() {
		System.out.println("after deposit "+ba.deposit(100));
	}

}
public class BankAccount extends Thread{

	public double balance=1000;
	
	public double deposit(double amount) {
		return balance += amount;
	}
	
	public double withdraw(double amount) {
		return balance -= amount;
	}
	
	
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		
		Withdraw wd = new Withdraw(ba);
		Deposit dp = new Deposit(ba);
		
		Thread t1 = new Thread(wd);
		Thread t2 = new Thread(dp);
		
		t1.start();
		t2.start();
	}

}
