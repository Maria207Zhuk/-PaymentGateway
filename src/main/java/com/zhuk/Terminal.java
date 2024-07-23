package com.zhuk;

public class Terminal {
    public void sendTransaction(Transaction transaction, Bank bank) {
        bank.addTransaction(transaction);
    }
}
