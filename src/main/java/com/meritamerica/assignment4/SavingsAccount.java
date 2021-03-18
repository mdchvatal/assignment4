package com.meritamerica.assignment4;

import java.util.Date;

public class SavingsAccount extends BankAccount {
	private double interestRate = 0.1;

	public SavingsAccount() {
		this.interestRate = 0.1;
	}

	public SavingsAccount(double openingBalance) {
		super(openingBalance);
		this.interestRate = 0.1;
	}

	public SavingsAccount(double balance, double interestRate) {
		super(balance, interestRate);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(double balance, double interestRate, Date accountOpenedOn) {
		super(balance, interestRate, accountOpenedOn);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(long accountNumber, double balance, double interestRate) {
		super(accountNumber, balance, interestRate);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
		// TODO Auto-generated constructor stub
	}
	
	

}
