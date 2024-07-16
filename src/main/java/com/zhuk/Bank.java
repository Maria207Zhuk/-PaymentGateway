package com.zhuk;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Transaction> transactions;
    private double currentBalance;

    public Bank() {
        this.transactions = new ArrayList<>();
        this.currentBalance = 0.0;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        currentBalance += transaction.getAmount();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}
