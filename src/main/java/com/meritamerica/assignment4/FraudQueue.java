package com.meritamerica.assignment4;

import java.util.ArrayList;

public class FraudQueue {
	private ArrayList<Transaction> fraudQueue = new ArrayList<Transaction>();
	

	public FraudQueue() {
		// TODO Auto-generated constructor stub
	}
	
	public void addTransaction(Transaction transaction) {
		fraudQueue.add(transaction);
	}
	
	public Transaction getTransaction() {
		return fraudQueue.get(0);
	}

}
