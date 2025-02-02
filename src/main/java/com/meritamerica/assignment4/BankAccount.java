package com.meritamerica.assignment4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.NumberFormatException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class BankAccount {
	protected double futureBalance;
	protected long accountNumber;
	protected double balance;
	protected Date accountOpenedOn; 
	protected double interestRate;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public BankAccount() {
	}
	
	public BankAccount(double openingBalance) {
		this.balance = openingBalance;
		this.futureBalance = openingBalance;
	}
	
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		MeritBank.getNextAccountNumber();
	}
	
	public BankAccount(double balance, double interestRate, Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		MeritBank.getNextAccountNumber();
		this.accountOpenedOn = accountOpenedOn;
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNum) {
		accountNumber = accountNum;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double intRate) {
		interestRate = intRate;
	}
	
	public Date getOpenedOn() {
		return accountOpenedOn;
	}
	
	public void setAccountOpenedOn(Date date) {
		accountOpenedOn = date;
	}
	
	public boolean withdraw(double amount) {
		if (amount <= balance && amount > 0) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			return true;
		} else return false;
	}
	
	/*public double futureValue(double years) {
		if (years == 1) {
			return 1;
		}
		return (getBalance() * Math.pow((1+interestRate), years));
	}*/
	
	public double futureValue(int years) {
	    if (years == 0) {
	    	double tempBalance;
	    	tempBalance = futureBalance;
	    	resetFutureBalance();
	        return tempBalance;
	    } else {
	        futureBalance = futureBalance * (1 + getInterestRate());
	        return futureValue(--years);
	    }
	}
	    
	public double getFutureBalance() {
		futureBalance = balance;
		return futureBalance;
	}
	public void resetFutureBalance() {
		futureBalance = getBalance();
	}

	@Override
	public String toString() {SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormatter.format(accountOpenedOn);
		return accountNumber + "," + balance + "," + interestRate
				+ "," + dateString;
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
}