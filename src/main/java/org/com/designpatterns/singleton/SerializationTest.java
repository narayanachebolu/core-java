package org.com.designpatterns.singleton;

import java.io.*;

public class SerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton singletonInstance = Singleton.INSTANCE;
        // serialize the singleton instance
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.file"))) {
            oos.writeObject(singletonInstance);
        }

        Singleton singletonInstance1;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.file"))) {
            singletonInstance1 = (Singleton)ois.readObject();
        }

        System.out.println(singletonInstance.hashCode());
        System.out.println(singletonInstance1.hashCode());
        System.out.println("Are both objects same? " + (singletonInstance.hashCode() == singletonInstance1.hashCode()));
    }
}
