package com.meritamerica.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public void setTerm(int i) {
		this.term = i;
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
	
	public static CDAccount readFromString(String accountData) throws ParseException{
		CDAccount fromStringAccount = new CDAccount();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String[] accountDataFormatter = accountData.split(",");
		if (accountDataFormatter.length != 5) {
			throw new NumberFormatException();
		} else {
			fromStringAccount.setAccountNumber(Long.parseLong(accountDataFormatter[0]));
			fromStringAccount.setBalance(Double.parseDouble(accountDataFormatter[1]));
			fromStringAccount.setInterestRate(Double.parseDouble(accountDataFormatter[2]));
			System.out.println(fromStringAccount.getInterestRate());
			fromStringAccount.accountOpenedOn = dateFormatter.parse(accountDataFormatter[3]);
			fromStringAccount.setTerm(Integer.parseInt(accountDataFormatter[4]));
			return fromStringAccount;
		}
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormatter.format(getOpenedOn());
		return getAccountNumber() + "," + getBalance() + "," + getInterestRate()
					+ "," + dateString + "," + term;
	}
}