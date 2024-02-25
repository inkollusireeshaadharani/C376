package com.bankingApp.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.bankingApp.model.bankaccount.BankAccount;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	private static int count;
	
	private int id;
	private String name;
	private int age;
	private int mobileNumber;
	private String passportNumber;
	
//	private BankAccount bankAccount;
	public List<BankAccount> bankAccounts;
	
	private String dob;
	
	
	public Customer(String name, int age, int mobileNumber, String passportNumber, String dob) {
		this.id = count++ + 100;
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.passportNumber = passportNumber;
		this.dob = dob;
		this.bankAccounts = new LinkedList<>();
	}
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Customer.count = count;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

//	public BankAccount getBankAccount() {
//		return bankAccount;
//	}
//
//	public void setBankAccount(BankAccount bankAccount) {
//		this.bankAccount = bankAccount;
//	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}	

	@Override
	public String toString() {
		this.printCustomerData();
		return "";
	}
	
	public void printCustomerData() {
		System.out.println("CUSTOMER ");
		
		System.out.print(String.format("%-5s%-8s","Id:",id));
		System.out.print(String.format("%-7s%-15s","Name:",name));
		System.out.print(String.format("%-5s%-8s","Age:",age));
		System.out.print(String.format("%-8s%-15s","Mobile:",mobileNumber));
		System.out.print(String.format("%-9s%-11s","Passport:",passportNumber));
		System.out.println(String.format("%-5s%-15s","Dob:",dob));
		System.out.println();

		for(int i = 0; i<bankAccounts.size();i++) {
			System.out.println("Account "+(i+1)+":");
			BankAccount ba=bankAccounts.get(i);
			System.out.print(String.format("%-15s%-10s","AccountNumber:",ba.getAccountNumber()));
			System.out.print(String.format("%-11s%-9s","IFSC CODE:",ba.getBSBCode()));
			System.out.print(String.format("%-10s%-10s","BankName:",ba.getBankName()));
			System.out.print(String.format("%-10s%-10s","Balance:",ba.getBalance()));
			System.out.print(String.format("%-10s%-10s","Interest:",ba.getInterestEarned()));
			System.out.println(String.format("%-14s%-15s","OpeningDate:",ba.getOpeningDate()));
			System.out.println();
		}
		System.out.print("-----------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------");
	}
	
}
