package org.com.core.classloader;

import java.sql.DriverManager;
import java.util.ArrayList;

public class PrintClassLoaders {

    public static void main(String[] args) {
        System.out.println("Classloader of this class: " + PrintClassLoaders.class.getClassLoader());
        // Classloader of this class: jdk.internal.loader.ClassLoaders$AppClassLoader@76ed5528 aka System classloader.

        System.out.println("Classloader of DriverManager: " + DriverManager.class.getClassLoader());
        // Classloader of DriverManager: jdk.internal.loader.ClassLoaders$PlatformClassLoader@5b6f7412

        System.out.println("Classloader of ArrayList: " + ArrayList.class.getClassLoader());
        // Classloader of ArrayList: null. aka BootStrap or primordial classloader.
        // we can see that for the ArrayList, it displays null in the output. This is because the bootstrap class
        // loader is written in native code, not Java, so it doesn’t show up as a Java class. As a result, the
        // behavior of the bootstrap class loader will differ across JVMs.
    }
}
