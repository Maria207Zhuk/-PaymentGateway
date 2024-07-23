package com.zhuk;

public class Subscriber {
    private final String id;
    private double balance;

    public Subscriber(String id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }
}
