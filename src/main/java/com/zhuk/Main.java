package com.zhuk;
public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Terminal terminal = new Terminal();

        // Виконання транзакцій через paymentProcessor
        paymentProcessor.processPurchase(terminal, 100.0);
        paymentProcessor.processSale(terminal, 200.0);
        paymentProcessor.processPurchase(terminal, 50.0);
        paymentProcessor.processSale(terminal, 150.0);
        paymentProcessor.processPurchase(terminal, 300.0);
        paymentProcessor.processSale(terminal, 50.0);
        paymentProcessor.processPurchase(terminal, 200.0);
        paymentProcessor.processSale(terminal, 100.0);
        paymentProcessor.processPurchase(terminal, 75.0);
        paymentProcessor.processSale(terminal, 125.0);

        // Виведення інформації про транзакції та поточний баланс
        System.out.println("All Transactions:");
        for (Transaction transaction : paymentProcessor.getBank().getTransactions()) {
            System.out.println(transaction);
        }
        System.out.println("Current Balance: " + paymentProcessor.getBank().getCurrentBalance());
    }
}
