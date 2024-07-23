package com.zhuk;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Bank bank = paymentProcessor.getBank();

        Subscriber alice = new Subscriber("349010ab-a8fb-495e-b636-129835092838", 0);
        Subscriber bob = new Subscriber("b7e13512-17cc-4346-a498-bf4f6ab92d7d", 0);

        bank.addSubscriber(alice);
        bank.addSubscriber(bob);

        // Виконання транзакцій
        paymentProcessor.processPurchase("349010ab-a8fb-495e-b636-129835092838", 100.0);
        paymentProcessor.processSale("b7e13512-17cc-4346-a498-bf4f6ab92d7d", 200.0);
        paymentProcessor.processPurchase("349010ab-a8fb-495e-b636-129835092838", 50.0);
        paymentProcessor.processSale("b7e13512-17cc-4346-a498-bf4f6ab92d7d", 150.0);
        paymentProcessor.processPurchase("349010ab-a8fb-495e-b636-129835092838", 300.0);
        paymentProcessor.processSale("b7e13512-17cc-4346-a498-bf4f6ab92d7d", 50.0);
        paymentProcessor.processPurchase("349010ab-a8fb-495e-b636-129835092838", 200.0);
        paymentProcessor.processSale("b7e13512-17cc-4346-a498-bf4f6ab92d7d", 100.0);
        paymentProcessor.processPurchase("349010ab-a8fb-495e-b636-129835092838", 75.0);
        paymentProcessor.processSale("b7e13512-17cc-4346-a498-bf4f6ab92d7d", 173.0);

        System.out.println("All Transactions:");
        bank.getTransactions().forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Transactions by Subscriber ID '349010ab-a8fb-495e-b636-129835092838':");
        bank.getTransactionsBySubscriberId("349010ab-a8fb-495e-b636-129835092838").forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Transactions by Date 2024-07-23:");
        bank.getTransactionsByDate(LocalDate.of(2024, 7, 23)).forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------");
        bank.printTransactionSummary();

        System.out.println("Subscribers' Balances:");
        bank.getSubscribers().forEach((id, subscriber) ->
                System.out.println(subscriber.getId() + ": " + subscriber.getBalance()));
    }
}
