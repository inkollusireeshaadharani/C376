create database bankingapp;
use bankingapp;
create table customer(
	customerId int primary key,
    name varchar(50),
    age int,
    mobileNumber int,
    passport varchar(10) unique,
    DOB date
);


create table bankAccountType(
typeName VARCHAR(20) primary key
);

insert into bankAccountType values('SA');
insert into bankAccountType values('FD');

create table BankAccount (
 accountNo int primary key,
 bankName varchar(15),
 ifscCode int,
 balance double,
 openingDate date,
 customerId int,
 FOREIGN KEY (customerId) REFERENCES Customer(customerId),
 accountType varchar(20),
 FOREIGN KEY (accountType) REFERENCES bankAccountType(typeName)
);

create table SavingsAccount(
	accountNo INT primary key,
    FOREIGN KEY (accountNo) REFERENCES bankAccount(accountNo),
    isSalaryAccount BOOL,
    interestEarned DOUBLE
);

create table FixedDepositAccount(
	accountNo INT primary key,
    FOREIGN KEY (accountNo) REFERENCES bankAccount(accountNo),
    tenure INT,
	interestEarned DOUBLE
);

show tables;

desc customer;
desc bankAccount;
desc FixedDepositAccount;
desc SavingsAccount;
desc bankAccountType;

select * from customer;
select * from bankAccount;
select * from SavingsAccount;
select * from FixedDepositAccount;

-- ------ SAMPLE QUERIES --------
select b.accountno, customerid, b.balance, accounttype, isSalaryAccount, interestEarned
from bankAccount b
join savingsaccount s
on b.accountno = s.accountno;

select b.accountno, customerid, b.balance, accounttype, tenure, interestEarned
from bankAccount b
join FixedDepositAccount f
on b.accountno = f.accountno;
 
drop table bankAccount;
drop table SavingsAccount;
drop table FixedDepositAccount;