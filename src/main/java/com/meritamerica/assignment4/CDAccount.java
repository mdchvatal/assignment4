package com.meritamerica.assignment4;

import java.util.Date;

public class CDAccount extends BankAccount {
	private int term;

	public CDAccount() {
	}

	public CDAccount(CDOffering offering, double balance) {
		super(balance, offering.getInterestRate());
		this.term = offering.getTerm();
		super.setAccountNumber(MeritBank.getNextAccountNumber());
	}

	public int getTerm() {
		return term;
	}
	
	@Override
	public boolean withdraw(double amount) {
			return false;
	}
	
	@Override
	public boolean deposit(double amount) {
			return false;
	}
	
	public double futureValue() {
		double total = (getBalance() * Math.pow((1+getInterestRate()), term));
		return total;
	}
	
	


}
