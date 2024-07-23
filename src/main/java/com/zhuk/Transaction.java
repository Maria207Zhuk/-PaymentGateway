package com.zhuk;

import java.time.LocalDate;

public class Transaction {
    private final double amount;
    private final LocalDate date;
    private final String subscriberId;

    public Transaction(double amount, LocalDate date, String subscriberId) {
        this.amount = amount;
        this.date = date;
        this.subscriberId = subscriberId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", subscriberId='" + subscriberId + '\'' +
                '}';
    }
}
