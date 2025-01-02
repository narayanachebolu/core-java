package org.com.java8.challenges.advanced.threadsafelrucache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianTest {

    @Test
    void testMergeTwoNumArraysCase1() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{1, 3, 5, 7, 9, 11}, new int[]{0, 2, 4, 6, 8, 10});
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, mergedArray);
    }

    @Test
    void testMergeTwoNumArraysCase2() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{1, 3, 5, 7, 9, 11}, new int[]{});
        assertArrayEquals(new int[]{1, 3, 5, 7, 9, 11}, mergedArray);
    }

    @Test
    void testMergeTwoNumArraysCase3() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{}, new int[]{0, 2, 4, 6, 8, 10});
        assertArrayEquals(new int[]{0, 2, 4, 6, 8, 10}, mergedArray);
    }

    @Test
    void testMergeTwoNumArraysCase4() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{}, new int[]{});
        assertArrayEquals(new int[]{}, mergedArray);
    }

    @Test
    void testMergeTwoNumArraysCase5() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{1, 1, 1}, new int[]{1, 1, 1});
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1}, mergedArray);
    }

    @Test
    void testMergeTwoNumArraysCase6() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{1, 1, 1}, new int[]{1, 1, 1});
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1}, mergedArray);
    }

    @Test
    void testMergeTwoNumArraysCase7() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{2, 2, 4}, new int[]{2, 1, 3});
        assertArrayEquals(new int[]{2, 2, 1, 2, 3, 4}, mergedArray);
    }

    @Test
    void testMergeTwoNumArraysCase8() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{0, 0}, new int[]{0, 0});
        assertArrayEquals(new int[]{0, 0, 0, 0}, mergedArray);
    }

    @Test
    void testMedianOfArrayCase1() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{2, 2, 4}, new int[]{1, 3, 5});

        assertEquals(2.5, Median.medianOfSortedArray(mergedArray));
    }

    @Test
    void testMedianOfArrayCase2() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{2, 2, 4, 8}, new int[]{1, 3, 5}); // {1, 2, 2, 3, 4, 5, 8}

        assertEquals(3, Median.medianOfSortedArray(mergedArray));
    }

    @Test
    void testMedianOfArrayCase3() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{0, 0, 1}, new int[]{0, 0, 2}); // {0, 0, 0, 0, 1, 2}

        assertEquals(0, Median.medianOfSortedArray(mergedArray));
    }

    @Test
    void testMedianOfArrayCase4() {
        int[] mergedArray = Median.mergeNumArrays(new int[]{}, new int[]{});

        assertEquals(0, Median.medianOfSortedArray(mergedArray));
    }
}