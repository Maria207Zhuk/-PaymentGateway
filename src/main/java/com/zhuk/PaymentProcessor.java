package com.zhuk;
public class PaymentProcessor {
    private Bank bank;

    public PaymentProcessor() {
        this.bank = new Bank();
    }

    public void processPurchase(Terminal terminal, double amount) {
        Transaction transaction = new Transaction(-amount);
        terminal.sendTransaction(transaction, bank);
    }

    public void processSale(Terminal terminal, double amount) {
        Transaction transaction = new Transaction(amount);
        terminal.sendTransaction(transaction, bank);
    }

    public Bank getBank() {
        return bank;
    }
}
