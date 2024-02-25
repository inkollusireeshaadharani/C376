package com.bankingApp;

import java.util.*;
import com.bankingApp.utils.Validator;
import com.bankingApp.dao.DatabaseStorageDao;
import com.bankingApp.dao.FileStorageDao;
import com.bankingApp.exp.CustomerNotFoundException;
import com.bankingApp.exp.InsufficientFundsException;
import com.bankingApp.model.Customer;
import com.bankingApp.model.bankaccount.BankAccount;
import com.bankingApp.model.bankaccount.FixedDepositAccount;
import com.bankingApp.model.bankaccount.SavingsAccount;

public class BankAccountTest {
	
	private List<Customer> list;
	
	public BankAccountTest(){
		list = new ArrayList<>();
		FileStorageDao fd = new FileStorageDao();
		list = fd.deSerialize(list);

		Customer.setCount(list.size());
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
				System.out.println("Enter an id. ");
				int id = s.nextInt();
				System.out.println("Enter type of bank account.");
				System.out.println("1. Savings Account \n2. Fixed Deposit Account");
				int type = s.nextInt();
				try {
					bt.assignBankAccount(s,id,type);
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (InsufficientFundsException e) {
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
				bt.sortCustomerData(s);
				break;
			case 5:
				try {
					bt.persistCustomerData();
					bt.persistCustomerDataDB();
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				bt.showAllCustomers();
				break;
			case 7:
				System.out.println("Enter a name. ");
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
//		bt.persistCustomerData();
		System.out.println("Thank you for banking with us, have a nice day".toUpperCase());
	}
	
	//create customer	
	public void createCustomer(Scanner s) {
		System.out.print("Enter a name: ");
		s.nextLine();
		String name = s.nextLine();
		System.out.print("Enter age: ");
		int age = s.nextInt();
		System.out.print("Enter mobile number(9 digits): ");
		int mobile = s.nextInt();
		System.out.print("Enter passport number: ");
		s.nextLine();
		String passportNumber = s.nextLine();
		System.out.print("Enter Date Of Birth(DD/MM/YYYY) : ");
		String dob = s.nextLine();
		Customer c = new Customer(name, age, mobile, passportNumber, dob);
		
		while(!Validator.isValidDob(c.getDob())) {
			System.out.print("Enter a Valid Date Of Birth(DD/MM/YYYY) : ");
			dob = s.nextLine();
			c.setDob(dob);
		}
		list.add(c);

		System.out.println("Customer created successfully");
		c.printCustomerData();
	}
	
	//assign bank account
	public void assignBankAccount(Scanner s, int id, int type) throws CustomerNotFoundException,InsufficientFundsException{
		Customer c = null;
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getId()==id) 
			{
				c = list.get(i);
				break;
			}
			if(i==list.size()-1) {
				throw new CustomerNotFoundException("Customer with ID "+id+" not found");
			}
		}
		
		if(c.bankAccounts.size()>3) {
			System.out.println("Sorry you have reached your maximum limit for bank accounts");
			return;
		}
		
		System.out.print("Enter the Account Number: ");
		long accountNumber = s.nextLong();
		System.out.print("Enter IFSC Code: ");
		long BSBCode = s.nextLong();
		System.out.print("Enter Bank name: ");
		s.nextLine();
		String bankName = s.nextLine();
		System.out.print("Enter balance: ");
		double balance=s.nextDouble();
		
		System.out.print("Enter Opening Date(DD/MM/YYYY) : ");
		s.nextLine();
		String opDate = s.nextLine();
		
		BankAccount ba;
		if(type==1) {
			System.out.println("Is this a salary account?");
			System.out.println("1. Yes \n2. No");
			int choice = s.nextInt();
			boolean isSalaryAccount = (choice==1);
			if(!isSalaryAccount && balance<SavingsAccount.DEFAULT_BALANCE) {
				throw new InsufficientFundsException("Ensure minimum balance for savings account ");
			}
			ba = new SavingsAccount(accountNumber, BSBCode, bankName, balance, opDate, isSalaryAccount);
			ba.calculateInterest();
			System.out.println("Bank Account Set Successfully");
		}
		else
		{
			int tenure = 0;
			do{
				System.out.println("Enter tenure between " + FixedDepositAccount.MIN_TENURE + " and "+ FixedDepositAccount.MAX_TENURE);
				tenure = s.nextInt();
			}while(tenure < FixedDepositAccount.MIN_TENURE || tenure > FixedDepositAccount.MAX_TENURE) ;
			
			
			while(balance < FixedDepositAccount.MINIMUM_DEPOSIT_AMOUNT){
				System.out.println("Enter balance again: must be greater than "+FixedDepositAccount.MINIMUM_DEPOSIT_AMOUNT);
				balance = s.nextDouble();
			}
			
			ba = new FixedDepositAccount(accountNumber, BSBCode, bankName, balance, opDate,tenure);
			ba.calculateInterest();
			System.out.println("Bank Account Set Successfully");
		}
//		c.setBankAccount(ba);
		c.bankAccounts.add(ba);
		
	}
	
	public  void displayBalance(int id) throws CustomerNotFoundException{
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getId()==id) 
			{
				Customer c = list.get(i);
				for(BankAccount ba : c.bankAccounts) {
					System.out.println("Balance is "+ba.getBalance());
					System.out.println("Interest Earned is "+ba.calculateInterest());
				}
				
				return;
			}
		}
		throw new CustomerNotFoundException("Customer with ID "+id+" not found");
	}

	public  void sortCustomerData(Scanner s) {
		
		Comparator<Customer> comName = new Comparator<>() {

			@Override
			public int compare(Customer c1, Customer c2) {
				return c1.getName().compareTo(c2.getName());
			}
			
		};
		Comparator<Customer> comId = new Comparator<>() {

			@Override
			public int compare(Customer c1, Customer c2) {
				Integer c1Id = c1.getId();
				Integer c2Id = c2.getId();
				return c1Id.compareTo(c2Id);
			}
			
		};
		Comparator<Customer> comBalance = new Comparator<>() {

			@Override
			public int compare(Customer c1, Customer c2) {
				Double total1 = 0.0,total2=0.0;
				for(BankAccount ba : c1.bankAccounts) {
					total1+=ba.getBalance();
				}
				for(BankAccount ba : c2.bankAccounts) {
					total2+=ba.getBalance();
				}
				return total1.compareTo(total2);
			}
			
		};
		System.out.println("On what basis do you want to sort the customers.\n1.Name\n2.ID\n3.Balance");
		int choice = s.nextInt();
		if(choice==1) {
			Collections.sort(list,comName);
		}
		else if(choice==2){
			Collections.sort(list,comId);
		}
		else {
			Collections.sort(list,comBalance);
		}
		for(int i = 0 ; i < list.size(); i++) {
			list.get(i).printCustomerData();
		}
	}
	
	public  void persistCustomerData() {
		FileStorageDao fd = new FileStorageDao();
		fd.serialize(list);
	}
	public  void persistCustomerDataDB() {
		DatabaseStorageDao db = new DatabaseStorageDao();
		db.insertCustomers(list);
		System.out.println("Successfully updated Database");
	}
	
	public  void showAllCustomers() {
		for(int i = 0 ; i < list.size(); i++) {
			list.get(i).printCustomerData();
		}
	}
	
	public  void searchCustomerByName(String name) throws CustomerNotFoundException{
		boolean flag = false;
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).getName().equals(name)) 
			{
				list.get(i).printCustomerData();
				flag = true;			
			}
		}
		if(flag) return;
		throw new CustomerNotFoundException("Customer with name "+name+" not found");
	}
	
}
