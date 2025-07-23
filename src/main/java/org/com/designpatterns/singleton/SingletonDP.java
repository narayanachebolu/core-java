package org.com.designpatterns.singleton;

// Singleton class: Goal is to create a single instance per JVM.
public class SingletonDP {
    // Step 1: create a private static instance
    private static SingletonDP singletonDPInstance;

    // Step 2: private constructor to prevent instantiation
    private SingletonDP() {
        // to prevent from creating instance using reflection
        if (singletonDPInstance != null) {
            throw new IllegalArgumentException("Singleton instance is already created.");
        }
    }

    // Step 3: provide a public static method to get the instance
    public static SingletonDP getInstance() {
        if (singletonDPInstance == null) {
            // when thread context switching happens, it should not create a new object.
            // for thread safety, apply double lock on SingletonDP class.
            synchronized (SingletonDP.class) {
                if (singletonDPInstance == null) {
                    singletonDPInstance = new SingletonDP();
                }
            }
        }
        return singletonDPInstance;
    }

    public void showMessage() {
        System.out.println("Singleton instance: " + this.hashCode());
    }

    // above code can still break the principal of Singleton Design Pattern
    // 1. Reflection (look at private constructor)
    // 2. Serialize and Deserialize the object
    // 3. Clone

    // to prevent from creating instance using serialization, override the readResolve method
    private Object readResolve() {
        return singletonDPInstance;
    }

    // to prevent from creating instance using clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton clone is not supported.");
    }

    // NOTE: There is a robust way to create a singleton class using ENUM.
}
