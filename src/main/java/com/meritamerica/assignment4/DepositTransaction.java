package com.meritamerica.assignment4;

import java.text.SimpleDateFormat;

public class DepositTransaction extends Transaction {

	public DepositTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	public DepositTransaction(double amount) {
		this.setAmount(amount);
	}
	
	public DepositTransaction(BankAccount targetAccount, double amount) {
		this.setTargetAccount(targetAccount);
		this.setAmount(amount);
	}

	@Override
	public void process()
			throws NegativeAmountException, ExceedsAvailableBalanceException, ExceedsFraudSuspicionLimitException {
		// TODO Auto-generated method stub

	}
	
	/*public static DepositTransaction readFromString(String transactionDataString) {
		DepositTransaction tempTransaction = new DepositTransaction();
		String[] tempTransactionArray = transactionDataString.split(",");
		if (tempTransactionArray.length == 4) {
			tempTransaction.setFraudStatus(Integer.parseInt(tempTransactionArray[0]));
			tempTransaction.setTargetAccount(getAccountNumberFromStringArray(Long.parseLong(tempTransactionArray[1])));
			
		}
	}*/
	
	/*public static BankAccount getAccountNumberFromStringArray(long stringNumber) {
		AccountHolder[] tempAccHoldArray = MeritBank.getAccountHolders();
		for (int i = 0; i < tempAccHoldArray.length; i++) {
			CheckingAccount[] tempCheckArr = tempAccHoldArray[i].getCheckingAccounts();
			for (int j = 0; j < tempCheckArr.length; j++) {
				if (stringNumber == tempCheckArr[j].getAccountNumber()) {
					return tempCheckArr[j];
				}
			}
			SavingsAccount[] tempSavArr = tempAccHoldArray[i].getSavingsAccounts();
			for (int k = 0; k < tempSavArr.length; k++) {
				if (stringNumber == tempSavArr[k].getAccountNumber()) {
					return tempSavArr[k];
				} else {return null;}
			}
		}*/
		

	public String writeToString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = dateFormatter.format(this.getTransactionDate());
		return -1 + "," + getTargetAccount().getAccountNumber() + "," + "-" + getAmount()
				+ "," + dateString;
	}

}
