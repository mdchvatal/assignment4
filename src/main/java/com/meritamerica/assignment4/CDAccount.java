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
	
	static CDAccount readFromString(String accountData) {
		CDAccount fromStringAccount = new CDAccount();
		try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
			String[] accountDataFormatter = accountData.split(",");
			if (accountDataFormatter.length != 5) {
				throw new NumberFormatException();
			}else {
				fromStringAccount.setAccountNumber(Long.parseLong(accountDataFormatter[0]));
				fromStringAccount.balance = Double.parseDouble(accountDataFormatter[1]);
				fromStringAccount.setInterestRate(Double.parseDouble(accountDataFormatter[2]));
				fromStringAccount.setAccountOpenedOn(dateFormatter.parse(accountDataFormatter[3]));
				fromStringAccount.term = Integer.parseInt(accountDataFormatter[4]);
			}
		} catch (ParseException e) {
			System.out.println("That's not valid data input");
			e.printStackTrace();
		}
		return fromStringAccount;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormatter.format(getOpenedOn());
		return getAccountNumber() + "," + getBalance() + "," + getInterestRate()
					+ "," + dateString + "," + term;
	}
}