package com.meritamerica.assignment4;

import java.util.Date;

public class CheckingAccount extends BankAccount {
	private double interestRate = 0.0001;
	

	public CheckingAccount() {
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(double openingBalance) {
		super(openingBalance);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(double balance, double interestRate) {
		super(balance, interestRate);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(double balance, double interestRate, Date accountOpenedOn) {
		super(balance, interestRate, accountOpenedOn);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(long accountNumber, double balance, double interestRate) {
		super(accountNumber, balance, interestRate);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, balance, interestRate, accountOpenedOn);
		// TODO Auto-generated constructor stub
	}

}
