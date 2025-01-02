package org.com.java8.serial;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        Demo object = new Demo(1, "practicing java");
        String fileName = "file.ser";

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(object);

            oos.close();
            fos.close();

            System.out.println("Object has been serialized.");
        } catch (IOException iox) {
            iox.printStackTrace();
        }

        Demo object1 = null;

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            object1 = (Demo)ois.readObject();

            ois.close();
            fis.close();

            System.out.println("Object has be deserialized.");

            System.out.println(object1.a + ".." + object1.b + ".." + object1.x);
        } catch (IOException iox) {
            iox.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
}
