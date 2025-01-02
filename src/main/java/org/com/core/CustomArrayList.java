package org.com.core;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayList extends ArrayList {
    @Override
    public boolean add(Object element) {
        return this.contains(element) || super.add(element);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        System.out.println(list);

        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add(1);
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        System.out.println(customArrayList);
    }
}
