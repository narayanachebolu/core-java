package org.com.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) {
        Singleton singletonInstance = Singleton.INSTANCE;
        singletonInstance.printHashcode();

        try {
            Constructor<?>[] declaredConstructors = Singleton.class.getDeclaredConstructors();
            for(Constructor<?> constructor : declaredConstructors) {
                constructor.setAccessible(true); // TRUE: giving permissions to reflection API to create an object.
                Singleton singletonReflectionInstance = (Singleton)constructor.newInstance();
                singletonReflectionInstance.printHashcode();
            }
        } catch (Exception e) {
            System.out.println("Exception while creating instance: " + e.getMessage());
        }
    }
}
