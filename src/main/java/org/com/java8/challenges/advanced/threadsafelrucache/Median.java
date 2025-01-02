package org.com.java8.challenges.advanced.threadsafelrucache;

import java.util.Arrays;

public class Median {
    public static void main(String[] args) {
        int[] mergedArray = mergeNumArrays(new int[]{}, new int[]{});

        System.out.println(medianOfSortedArray(mergedArray));
    }

    public static double medianOfSortedArray(int[] num) {
        int arrLength = num.length;
        if (arrLength == 0) {
            return 0;
        } else if ( arrLength % 2 == 0) {
            return (double) (num[arrLength / 2] + num[(arrLength / 2) - 1]) / 2;
        } else {
            return (double) num[arrLength / 2];
        }
    }

    public static int[] mergeNumArrays(int[] num1, int[] num2) {
        int[] mergedNumArray = new int[num1.length + num2.length];

        int mergeCounter = 0,
                i = 0,
                j = 0;

        while(i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                mergedNumArray[mergeCounter] = num1[i];
                mergeCounter++;
                i++;
            } else if (num1[i] > num2[j]) {
                mergedNumArray[mergeCounter] = num2[j];
                mergeCounter++;
                j++;
            } else {
                mergedNumArray[mergeCounter] = num1[i];
                mergeCounter++;
                i++;

                mergedNumArray[mergeCounter] = num2[j];
                mergeCounter++;
                j++;
            }
        }

        while(i < num1.length) {
            mergedNumArray[mergeCounter] = num1[i];
            mergeCounter++;
            i++;
        }

        while(j < num2.length) {
            mergedNumArray[mergeCounter] = num2[j];
            mergeCounter++;
            j++;
        }

        //System.out.println(Arrays.toString(mergedNumArray));
        return mergedNumArray;
    }
}
