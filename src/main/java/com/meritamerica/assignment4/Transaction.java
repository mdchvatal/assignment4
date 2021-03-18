package com.meritamerica.assignment4;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
	private BankAccount sourceAccount;
	private BankAccount targetAccount;
	private double amount = 0.0;
	private Date transactionDate;
	private int fraudStatus = 1;
	private boolean processedByFraudTeam;
	private String rejectionReason;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	public BankAccount getSourceAccount() {
		return sourceAccount;
	}

	public BankAccount getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(BankAccount targetAccount) {
		this.targetAccount = targetAccount;
	}
	
	public void setSourceAccount(BankAccount sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public void setFraudStatus() {
		if (amount >= 1000) {
			this.fraudStatus = -1;
		} else {this.fraudStatus = 1;}
	}
	
	public void setFraudStatus(int i) {
		this.fraudStatus = i;
	}
	
	public int getFraudStatus() {
		return this.fraudStatus;
	}
	
	public String writeToString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormatter.format(this.transactionDate);
		return getFraudStatus() + "," + getTargetAccount().getAccountNumber() + "," + getAmount()
				+ "," + dateString;
	}
	
	
	
	public abstract void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException;

	public boolean isProcessedByFraudTeam() {
		if (getFraudStatus() == -1) {
			return true;
		} else {return false;}
	}
	
	public void setProcessedByFraudTeam(boolean isProcessed) {
		if (isProcessed == true) {
			processedByFraudTeam = true;
		} else {processedByFraudTeam = false;}
	}
	
	public String getRejectionReason() {
		return rejectionReason;
	}
	
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
	
	

}
