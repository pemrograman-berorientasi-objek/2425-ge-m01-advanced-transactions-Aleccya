package fintech.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String owner;
    private String accountName;
    private double balance;
    private List<Transaction> transactions;

    public Account(String owner, String accountName) {
        this.owner = owner;
        this.accountName = accountName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        balance += transaction.getAmount();
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    
    
    @Override
    public String toString() {
        return accountName + "|" + owner + "|" + balance;
    }
}