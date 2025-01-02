package org.com.designpatterns.singleton;

/**
 * robust way to create a singleton class using ENUM.
 *
 * Prevents a new instance from getting created using neither of below methods -
 * 1. Reflection (check ReflectionTest class)
 * 2. Serialization (check SerializationTest class)
 * 3. Clone (check CloneTest class)
  */
public enum Singleton {
    INSTANCE;

    public void printHashcode() {
        System.out.println("Print hash code: " + this.hashCode());
    }
}
