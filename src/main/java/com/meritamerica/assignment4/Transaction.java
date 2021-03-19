package com.meritamerica.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
	private BankAccount sourceAccount;
	private BankAccount targetAccount;
	private double amount = 0.0;
	private Date transactionDate;
	private boolean processedByFraudTeam;
	private String rejectionReason;
	private long targetAccountNumber;
	private long sourceAccountNumber;

	public Transaction() {
	}
	
	public Transaction(double amount) {
		setAmount(amount);
	}
	
	public Transaction(BankAccount account, double amount) {
		setTargetAccount(account);
		setAmount(amount);
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

	public long getTargetAccountNumber() {
		return targetAccountNumber;
	}
	
	public void setTargetAccountNumber(long accNum) {
		targetAccountNumber = accNum;
	}
	
	public long getSourceAccountNumber() {
		return sourceAccountNumber;
	}
	
	public void setSourceAccountNumber(long accNum) {
		sourceAccountNumber = accNum;
	}
	
	/*public String writeToString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormatter.format(this.transactionDate);
		return getFraudStatus() + "," + getTargetAccount().getAccountNumber() + "," + getAmount()
				+ "," + dateString;
	}*/
	
	public static Transaction readFromString(String transactionDataString) throws ParseException {
		Transaction stringTrans;
		String[] stringArr = transactionDataString.split(",");
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		if (Integer.parseInt(stringArr[0]) == -1) {
			if (Double.parseDouble(stringArr[2]) > 0) {
				stringTrans = new DepositTransaction(Double.parseDouble(stringArr[2]));
				stringTrans.setTransactionDate(dateFormatter.parse(stringArr[3]));
				stringTrans.setSourceAccountNumber(Long.parseLong(stringArr[1]));
				return stringTrans;
			} else {
				stringTrans = new WithdrawTransaction((Double.parseDouble(stringArr[2])*-1));
				stringTrans.setTransactionDate(dateFormatter.parse(stringArr[3]));
				stringTrans.setSourceAccountNumber(Long.parseLong(stringArr[1]));
				return stringTrans;
			}
		} else {
			stringTrans = new TransferTransaction(Double.parseDouble(stringArr[2]));
			stringTrans.setTransactionDate(dateFormatter.parse(stringArr[3]));
			stringTrans.setTargetAccountNumber(Long.parseLong(stringArr[1]));
			return stringTrans;
		}
	}
	
	
	
	public abstract void process() throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException;

	
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
