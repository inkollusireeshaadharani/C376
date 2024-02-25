package com.bankingApp.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import com.bankingApp.model.Customer;
import com.bankingApp.model.bankaccount.BankAccount;
import com.bankingApp.model.bankaccount.FixedDepositAccount;
import com.bankingApp.model.bankaccount.SavingsAccount;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseStorageDao {
	public static MysqlDataSource getDataSource() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        
        Properties properties = loadProperties();
        
        ds.setServerName(properties.getProperty("db.serverName"));
        ds.setPort(Integer.parseInt(properties.getProperty("db.port")));
        ds.setDatabaseName(properties.getProperty("db.databaseName"));
        ds.setUser(properties.getProperty("db.user"));
        ds.setPassword(properties.getProperty("db.password"));
        ds.setUseSSL(Boolean.parseBoolean(properties.getProperty("db.useSSL")));
        ds.setAllowPublicKeyRetrieval(Boolean.parseBoolean(properties.getProperty("db.allowPublicKeyRetrieval")));
        
        return ds;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = DatabaseStorageDao.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return null;
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
	
	public void insertCustomers(List<Customer> customers) {
        try (Connection connection = getDataSource().getConnection()) {
            for (Customer customer : customers) {
                insertCustomer(connection, customer);

                insertBankAccounts(connection, customer.getBankAccounts(), customer.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private void insertCustomer(Connection connection, Customer customer) throws SQLException {
        String insertCustomerSQL = "INSERT INTO customer (customerId, name, age, mobileNumber, passport, DOB) " +
                "VALUES (?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "name = VALUES(name), age = VALUES(age), mobileNumber = VALUES(mobileNumber), passport = VALUES(passport), DOB = VALUES(DOB)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertCustomerSQL)) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.setInt(4, customer.getMobileNumber());
            preparedStatement.setString(5, customer.getPassportNumber());

            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(customer.getDob(), inputFormatter);
            Date dob = Date.valueOf(localDate);
            preparedStatement.setDate(6, dob);

            preparedStatement.executeUpdate();
        }
    }
	
	
	private void insertBankAccounts(Connection connection, List<BankAccount> bankAccounts, int customerId) throws SQLException {
		for (BankAccount bankAccount : bankAccounts) {
	        if (bankAccount instanceof SavingsAccount) {
	            insertBankAccount(connection, (SavingsAccount) bankAccount, customerId, "SA");
	            insertSavingsAccount(connection, (SavingsAccount) bankAccount);
	        } else if (bankAccount instanceof FixedDepositAccount) {
	            insertBankAccount(connection, (FixedDepositAccount) bankAccount, customerId, "FD");
	            insertFixedDepositAccount(connection, (FixedDepositAccount) bankAccount);
	        }
	    }	    
	}

	private void insertBankAccount(Connection connection, BankAccount bankAccount, int customerId, String accountType) throws SQLException {
	    String insertBankAccountSQL = "INSERT INTO BankAccount (accountNo, bankName, ifscCode, balance, openingDate, customerId, accountType) " +
	            "VALUES (?, ?, ?, ?, ?, ?, ?) " +
	            "ON DUPLICATE KEY UPDATE " +
	            "bankName = VALUES(bankName), ifscCode = VALUES(ifscCode), balance = VALUES(balance), openingDate = VALUES(openingDate), customerId = VALUES(customerId), accountType = VALUES(accountType)";

	    try (PreparedStatement preparedStatement = connection.prepareStatement(insertBankAccountSQL)) {
	        preparedStatement.setLong(1, bankAccount.getAccountNumber());
	        preparedStatement.setString(2, bankAccount.getBankName());
	        preparedStatement.setLong(3, bankAccount.getBSBCode());
	        preparedStatement.setDouble(4, bankAccount.getBalance());
	        
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(bankAccount.getOpeningDate(), inputFormatter);
            Date opd = Date.valueOf(localDate);
            preparedStatement.setDate(5, opd);
            
	        preparedStatement.setInt(6, customerId);
	        preparedStatement.setString(7, accountType);

	        preparedStatement.executeUpdate();
	    }
	}


    private void insertSavingsAccount(Connection connection, SavingsAccount savingsAccount) throws SQLException {
        String insertSavingsAccountSQL = "INSERT INTO SavingsAccount (accountNo, isSalaryAccount, interestEarned) " +
                "VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "isSalaryAccount = VALUES(isSalaryAccount), interestEarned = VALUES(interestEarned)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSavingsAccountSQL)) {
            preparedStatement.setLong(1, savingsAccount.getAccountNumber());
            preparedStatement.setBoolean(2, savingsAccount.isSalaryAccount());
            preparedStatement.setDouble(3, savingsAccount.getInterestEarned());

            preparedStatement.executeUpdate();
        }
    }

    private void insertFixedDepositAccount(Connection connection, FixedDepositAccount fixedDepositAccount) throws SQLException {
        String insertFixedDepositAccountSQL = "INSERT INTO FixedDepositAccount (accountNo, tenure, interestEarned) " +
                "VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "tenure = VALUES(tenure), interestEarned = VALUES(interestEarned)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertFixedDepositAccountSQL)) {
            preparedStatement.setLong(1, fixedDepositAccount.getAccountNumber());
            preparedStatement.setInt(2, fixedDepositAccount.getTenure());
            preparedStatement.setDouble(3, fixedDepositAccount.getInterestEarned());

            preparedStatement.executeUpdate();
        }
    }

}
