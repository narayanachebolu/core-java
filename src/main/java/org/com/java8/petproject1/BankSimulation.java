package org.com.java8.petproject1;

public class BankSimulation {
    public static void main(String[] args) {
        Bank yesBank = new Bank();

        // Create accounts
        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 1500);
        Account account3 = new Account(3, 2000);

        yesBank.addAccount(account1);
        yesBank.addAccount(account2);
        yesBank.addAccount(account3);

        Thread t1 = new Thread(() -> yesBank.deposit(1, 500));
        Thread t8 = new Thread(() -> yesBank.amountTransfer(2, 3, 5500));
        Thread t2 = new Thread(() -> yesBank.deposit(2, 1500));
        Thread t3 = new Thread(() -> yesBank.withdraw(3, 4000));
        Thread t4 = new Thread(() -> yesBank.withdraw(1, 888));
        Thread t10 = new Thread(() -> yesBank.amountTransfer(1, 2, 6500));
        Thread t5 = new Thread(() -> yesBank.withdraw(2, 1234));
        Thread t6 = new Thread(() -> yesBank.deposit(3, 2500));
        Thread t7 = new Thread(() -> yesBank.deposit(2, 5500));
        Thread t9 = new Thread(() -> yesBank.amountTransfer(3, 1, 500));


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        yesBank.printAccountBalances();
    }
}
