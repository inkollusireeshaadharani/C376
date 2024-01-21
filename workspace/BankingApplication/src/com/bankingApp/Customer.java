package com.bankingApp;

import java.io.Serializable;

import com.bankingApp.bankAccount.BankAccount;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	private static int count;
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Customer.count = count;
	}

	private int id;
	private String name;
	private int age;
	private int mobileNumber;
	private String passportNumber;
	private BankAccount bankAccount;
	private String dob;
	
	
	public Customer(String name, int age, int mobileNumber, String passportNumber, String dob) {
		this.id = count++ + 100;
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.passportNumber = passportNumber;
		this.dob = dob;
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

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {

		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		return "Customer \t [id=" + id + "\t\t name=" + name + "\t age=" + age + "\t\t mobileNumber=" + mobileNumber
				+ "\t passportNumber=" + passportNumber + "\t dob=" + dob +"]"+"\n---------------------------------------------------------------------------------------------------------------------------------------\nBankAccount   " + bankAccount ;
	}
	
	
	
	
	

	
	
	
	
}
