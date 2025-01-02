package org.com.java8.petproject1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final int id;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public Account(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdrawl(double amount) {
        balance -= amount;
    }
}
