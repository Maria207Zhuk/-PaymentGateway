package com.zhuk;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Bank {
    private final List<Transaction> transactions;
    private final Map<String, Subscriber> subscribers;

    public Bank() {
        this.transactions = new ArrayList<>();
        this.subscribers = new HashMap<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        Subscriber subscriber = subscribers.get(transaction.getSubscriberId());
        if (subscriber != null) {
            subscriber.updateBalance(transaction.getAmount());
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transaction> getTransactionsBySubscriberId(String subscriberId) {
        return transactions.stream()
                .filter(t -> t.getSubscriberId().equals(subscriberId))
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactionsByDate(LocalDate date) {
        return transactions.stream()
                .filter(t -> t.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public void printTransactionSummary() {
        double totalPurchase = transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalSale = transactions.stream()
                .filter(t -> t.getAmount() > 0)
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("Total Purchases: " + totalPurchase);
        System.out.println("Total Sales: " + totalSale);
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.put(subscriber.getId(), subscriber);
    }

    public Map<String, Subscriber> getSubscribers() {
        return subscribers;
    }
}
