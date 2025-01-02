package org.com.java8.concepts.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastList {
    public static void main(String[] args) {
        //List<String> stringList = new ArrayList<>();
        // in order to avoid the ConcurrentModificationException, use CopyOnWriteArrayList
        // this uses modcount.
        List<String> stringList = new CopyOnWriteArrayList<>();

        stringList.add("naren");
        stringList.add("kala");

        Iterator<String> iterator = stringList.iterator();

        while (iterator.hasNext()) {
            String nextValue = iterator.next();
            System.out.println(nextValue);
            stringList.add("yashu");
        }
    }
}
