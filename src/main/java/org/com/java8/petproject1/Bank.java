package org.com.java8.petproject1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Bank {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public void deposit(int accountId, double amount) {
        Account account = accounts.get(accountId);

        if (account != null) {
            Lock lock = account.getLock();
            lock.lock();
            try {
                account.deposit(amount);
                System.out.println("Deposited: " + amount + " to account: " + accountId);
            } finally {
                lock.unlock();
            }
        }
    }

    public void withdraw(int accountId, double amount) {
        Account account = accounts.get(accountId);

        if (account != null) {
            Lock lock = account.getLock();
            lock.lock();
            try {
                if (account.getBalance() >= amount) {
                    account.withdrawl(amount);
                    System.out.println("Withdrew " + amount + " from account: " + accountId);
                } else {
                    System.out.println("Unable to withdraw, insufficient funds in account: " + account.getId());
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void amountTransfer(int fromAccountId, int toAccountId, double amount) {
        System.out.println("Initiating money transfer from account: " + fromAccountId + " to account: " + toAccountId);
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount != null && toAccount != null) {
            Lock firstLock, secondLock;

            // Avoid deadLock by always locking in same order
            if (fromAccountId < toAccountId) { // lock strategy: check with some dummy condition and follow the order or locking
                firstLock = fromAccount.getLock();
                secondLock = toAccount.getLock();
            } else {
                firstLock = toAccount.getLock();
                secondLock = fromAccount.getLock();
            }

            boolean locksAcquired = false;

            try {
                boolean firstLockAcquired = firstLock.tryLock(100, TimeUnit.MILLISECONDS);
                if (firstLockAcquired) {
                    try {
                        boolean secondLockAcquired = secondLock.tryLock(100, TimeUnit.MILLISECONDS);
                        if (secondLockAcquired) {
                            locksAcquired = true;
                            if (fromAccount.getBalance() >= amount) {
                                fromAccount.withdrawl(amount);
                                toAccount.deposit(amount);
                                System.out.println("Transferred " + amount + " from account: " + fromAccountId + " to account: " + toAccountId);
                            } else {
                                System.out.println("Unable to transfer, insufficient funds in account: " + fromAccountId);
                            }
                        }
                    } finally {
                        if (!locksAcquired) {
                            firstLock.unlock();
                        }
                    }
                }
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                if (locksAcquired) {
                    secondLock.unlock();
                    firstLock.unlock();
                }
            }
        }
    }

    public void printAccountBalances() {
        accounts.values().forEach(account -> {
            System.out.println("Account " + account.getId() + " has a balance of: " + account.getBalance());
        });
    }
}
