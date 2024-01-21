package com.bankingApp;

import com.bankingApp.bankAccount.BankAccount;

public class Customer {
	private static int count;
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

	public boolean isValidDob() {
		String[] words = dob.split("/");
		if(words.length > 3) return false;
		int date = Integer.parseInt(words[0]);
		int month = Integer.parseInt(words[1]);
		int year = Integer.parseInt(words[2]);
		
		if(year>2023 || month > 12 || month < 1 || date<1) return false;
		
		switch(month) {
		case 1:
			if(date>31) return false;
			break;
		case 2:
			if(date>29 || (date==29 && year%100 ==0 && year%400 !=0) || (date==29 && year%4 != 0)) return false;
			break;
		case 3:
			if(date>31) return false;
			break;
		case 5:
			if(date>31) return false;
			break;
		case 7:
			if(date>31) return false;
			break;
		case 8:
			if(date>31) return false;
			break;
		case 10:
			if(date>31) return false;
			break;
		case 12:
			if(date>31) return false;
			break;
		case 4:
			if(date>30) return false;
			break;
		case 6:
			if(date>30) return false;
			break;
		case 9:
			if(date>30) return false;
			break;
		case 11:
			if(date>30) return false;
			break;
		}
			
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", mobileNumber=" + mobileNumber
				+ ", passportNumber=" + passportNumber + ", bankAccount=" + bankAccount + ", dob=" + dob + "]";
	}
	
	
	
	
	

	
	
	
	
}
