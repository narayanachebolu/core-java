package org.com.java8.concepts.custom;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

// write a custom ArrayList to not allow duplicate values.
public class CustomArrayList<T> extends ArrayList<T> {

    public Type getGenericType() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType parameterizedType) {
            return parameterizedType.getActualTypeArguments()[0];
        }

        return null;
    }

    @Override
    public boolean add(Object object) {
        if (this.contains(object) || object instanceof String) {
            return true;
        } else {
            return super.add((T) object);
        }
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(1);
        customArrayList.add("2");
        customArrayList.add("3"); // FIX ALLOW INTEGERS PASSED AS STRING

        System.out.println(customArrayList);
        //System.out.println(customArrayList.getGenericType());
    }
}
