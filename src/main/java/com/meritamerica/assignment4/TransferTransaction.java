package com.meritamerica.assignment4;

import java.text.SimpleDateFormat;

public class TransferTransaction extends Transaction {

	public TransferTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	public TransferTransaction(double amount) {
		this.setAmount(amount);
	}
	
	public TransferTransaction(BankAccount targetAccount, double amount) {
		this.setTargetAccount(targetAccount);
		this.setAmount(amount);
	}
	
	public TransferTransaction(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
		this.setSourceAccount(sourceAccount);
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
		return 1 + "," + getTargetAccount().getAccountNumber() + "," + getAmount()
				+ "," + dateString;
	}

}
