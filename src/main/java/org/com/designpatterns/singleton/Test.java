package org.com.designpatterns.singleton;

public class Test {
    public static void main(String[] args) {
        Singleton singletonInstance = Singleton.INSTANCE;
        singletonInstance.printHashcode();

        Singleton singletonInstance1 = Singleton.INSTANCE;
        singletonInstance1.printHashcode();

        System.out.println(singletonInstance.hashCode() == singletonInstance1.hashCode());
    }
}
