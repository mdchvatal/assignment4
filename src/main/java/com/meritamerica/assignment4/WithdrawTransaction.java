package com.meritamerica.assignment4;

import java.text.SimpleDateFormat;

public class WithdrawTransaction extends Transaction {

	public WithdrawTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	public WithdrawTransaction(double amount) {
		this.setAmount(amount);
	}

	public WithdrawTransaction(BankAccount targetAccount, double amount) {
		this.setSourceAccount(targetAccount);
		this.setTargetAccount(targetAccount);
		this.setAmount(amount);
	}
	
	
	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		// TODO Auto-generated method stub

	}
	
	public String writeToString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormatter.format(this.getTransactionDate());
		return -1 + "," + getTargetAccount().getAccountNumber() + "," + getAmount()
				+ "," + dateString;
	}

}
