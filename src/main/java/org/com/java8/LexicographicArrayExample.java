package org.com.java8;

import java.util.Arrays;

public class LexicographicArrayExample {

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3},
                {2, 3, 4, 5},
                {1, 3, 5, 7, 9, 11},
                {2, 4, 6, 8, 10},
                {3, 4, 5},
                {0, 2}
        };

        // Sort the array of arrays Lexicographically
        Arrays.sort(arrays, (a, b) -> {
            for (int i = 0; i < Math.min(a.length, b.length); i++) {
                if (a[i] != b[i]) {
                   return Integer.compare(a[i], b[i]);
                }
            }
            return Integer.compare(a.length, b.length);
        });

        // Print the sorted arrays
        for (int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }

        System.out.println("-----------------");

        // arrange the 2 dimensional array in the order of array length of inner array
        Arrays.sort(arrays, (a, b) -> Integer.compare(b.length, a.length));

        for(int[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
}
