package org.com.java8.serial;

import java.io.Serializable;

public class Demo implements Serializable {
    public int a;
    public String b;
    public transient final int x = 111;

    public Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}