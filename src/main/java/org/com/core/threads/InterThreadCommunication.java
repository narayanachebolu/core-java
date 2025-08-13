package org.com.core.threads;

import lombok.Getter;

public class InterThreadCommunication {
    public static void main(String[] args) {
        final Customer customer = new Customer();
        System.out.println("Current balance: " + customer.getCurrentBalance());
        new Thread(() -> {
            customer.cashWithdraw(25000);
        }).start();

        new Thread(() -> {
            customer.cashDeposit(50000);
        }).start();
    }
}

@Getter
class Customer {
    int currentBalance = 10000;

    synchronized void cashWithdraw(int withdrawableAmount) {
        System.out.println("Withdrawal of " + withdrawableAmount + " has be initiated.");
        if (withdrawableAmount > currentBalance) {
            System.out.println("Insufficient funds.. Waiting for deposits.");
            try {
                wait();
            } catch (InterruptedException ix) {
                ix.printStackTrace();
            }
            currentBalance -= withdrawableAmount;
            System.out.println("Withdrawal of " + withdrawableAmount + " is complete.");
            System.out.println("Current balance after withdrawal is: " + currentBalance);
        }
    }

    synchronized void cashDeposit(int depositAmount) {
        System.out.println("Deposit of " + depositAmount + " initiated.");
        currentBalance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " is completed.");
        System.out.println("Current balance after deposit is: " + currentBalance);
        notify();
    }

}
