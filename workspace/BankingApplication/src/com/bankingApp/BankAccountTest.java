package com.bankingApp;

import java.util.Scanner;

import com.bankingApp.bankAccount.BankAccount;
import com.bankingApp.bankAccount.FixedDepositAccount;
import com.bankingApp.bankAccount.SavingsAccount;
import com.bankingApp.exp.CustomerNotFoundException;

public class BankAccountTest {
	
	private Customer[] custArray;
	private int custCount;
	
	public BankAccountTest(){
		this.custArray = new Customer[100];
		this.custCount = 0;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int choice = 0;
		BankAccountTest bt = new BankAccountTest();
		do {
			//menu
			System.out.println("Enter your choice.");
			System.out.println("1. Create New Customer Data");
			System.out.println("2. Assign a Bank Account to a Customer");
			System.out.println("3. Display balance or interest earned of a Customer");
			System.out.println("4. Sort Customer Data");
			System.out.println("5. Persist Customer Data");
			System.out.println("6. Show All Customers");
			System.out.println("7. Search Customers by Name");
			System.out.println("8. Exit");
			
			//take choice
			choice = s.nextInt();
			
			//perform operation
			switch(choice) {
			case 1:
				bt.createCustomer(s);
				break;
			case 2:
				System.out.println("Enter an id.");
				int id = s.nextInt();
				System.out.println("Enter type of bank account.");
				System.out.println("1. Savings Account \n2. Fixed Deposit Account");
				int type = s.nextInt();
				try {
					bt.assignBankAccount(s,id,type);
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter an id.");
				id = s.nextInt();
				try {
					bt.displayBalance(id);
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				catch(NullPointerException e) {
					System.out.println("Create Bank account of customer first!!!");
				}
				break;
			case 4:
				bt.sortCustomerData();
				break;
			case 5:
				bt.persistCustomerData();
				break;
			case 6:
				bt.showAllCustomers();
				break;
			case 7:
				System.out.println("Enter a name.");
				s.nextLine();
				String name = s.nextLine();
				try {
					bt.searchCustomerByName(name);
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			}
		}while(choice!=8);
	}
	
	//create customer	
	public void createCustomer(Scanner s) {
		System.out.println("Enter a name.");
		s.nextLine();
		String name = s.nextLine();
		System.out.println("Enter age");
		int age = s.nextInt();
		System.out.println("Enter mobile number");
		int mobile = s.nextInt();
		System.out.println("Enter passport number");
		s.nextLine();
		String passportNumber = s.nextLine();
		System.out.println("Enter Date Of Birth");
		String dob = s.nextLine();
		Customer c = new Customer(name, age, mobile, passportNumber, dob);
		
		while(!c.isValidDob()) {
			System.out.println("Enter a Valid Date Of Birth");
			dob = s.nextLine();
			c.setDob(dob);
		}
		
		if(custCount<100) {
			custArray[custCount++] = c;	
		}
		System.out.println("Customer created successfully");
		System.out.println(c);
	}
	
	//assign bank account
	public void assignBankAccount(Scanner s, int id, int type) throws CustomerNotFoundException{
		
		System.out.println("Enter the Account Number.");
		long accountNumber = s.nextLong();
		System.out.println("Enter BSB Code");
		long BSBCode = s.nextLong();
		System.out.println("Enter Bank name");
		s.nextLine();
		String bankName = s.nextLine();
		
		System.out.println("Enter Opening Date (DD/MM/YYYY)");
		String opDate = s.nextLine();
		
		BankAccount ba;
		if(type==1) {
			System.out.println("Is this a salary account?");
			System.out.println("1. Yes \n2. No");
			int choice = s.nextInt();
			boolean isSalaryAccount = (choice==1);
			ba = new SavingsAccount(accountNumber, BSBCode, bankName, SavingsAccount.DEFAULT_BALANCE, opDate, isSalaryAccount);
		}
		else
		{
			int tenure = 0;
			do{
				System.out.println("Enter tenure between " + FixedDepositAccount.MIN_TENURE + " and "+ FixedDepositAccount.MAX_TENURE);
				tenure = s.nextInt();
			}while(tenure < FixedDepositAccount.MIN_TENURE || tenure > FixedDepositAccount.MAX_TENURE) ;
			
			double balance=0;
			do{
				System.out.println("Enter amount: must be greater than "+FixedDepositAccount.MINIMUM_DEPOSIT_AMOUNT);
				balance = s.nextDouble();
			}while(balance < FixedDepositAccount.MINIMUM_DEPOSIT_AMOUNT) ;
			
			ba = new FixedDepositAccount(accountNumber, BSBCode, bankName, balance, opDate,tenure);
		}
		for(int i = 0 ; i < custCount; i++) {
			if(custArray[i].getId()==id) 
			{
				custArray[i].setBankAccount(ba);
				System.out.println("Bank account added successfully");
				System.out.println(custArray[i]);
				return;
			}
		}
		throw new CustomerNotFoundException("Customer with ID "+id+" not found");
	}
	
	public  void displayBalance(int id) throws CustomerNotFoundException{
		for(int i = 0 ; i < custCount; i++) {
			if(custArray[i].getId()==id) 
			{
				Customer c = custArray[i];
				System.out.println("Balance is "+c.getBankAccount().getBalance());
				System.out.println("Interest Earned is "+c.getBankAccount().calculateInterest());
				return;
			}
		}
		throw new CustomerNotFoundException("Customer with ID "+id+" not found");
	}
	// TO-DO
	public  void sortCustomerData() {
		
	}
	// TO-DO
	public  void persistCustomerData() {
		
	}
	
	public  void showAllCustomers() {
		for(int i = 0 ; i < custCount; i++) {
			System.out.println(custArray[i]);
		}
	}
	
	public  void searchCustomerByName(String name) throws CustomerNotFoundException{
		boolean flag = false;
		for(int i = 0 ; i < custCount; i++) {
			if(custArray[i].getName().equals(name)) 
			{
				System.out.println(custArray[i]);
				flag = true;			
			}
		}
		if(flag) return;
		throw new CustomerNotFoundException("Customer with name "+name+" not found");
	}
	
}
