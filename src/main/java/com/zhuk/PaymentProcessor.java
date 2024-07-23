package com.zhuk;

import java.time.LocalDate;

public class PaymentProcessor {
    private final Bank bank;

    public PaymentProcessor() {
        this.bank = new Bank();
    }

    public void processPurchase(String subscriberId, double amount) {
        Transaction transaction = new Transaction(-amount, LocalDate.now(), subscriberId);
        bank.addTransaction(transaction);
    }

    public void processSale(String subscriberId, double amount) {
        Transaction transaction = new Transaction(amount, LocalDate.now(), subscriberId);
        bank.addTransaction(transaction);
    }

    public Bank getBank() {
        return bank;
    }
}
