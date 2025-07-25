package org.com.dsa.arraysstrings;

public class SlidingWindow {
    public static void main(String[] args) {
        //int[] nums = {3, 2, 1, 3, 1, 1}; target 5
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int target = 8;

        System.out.println("Length of sliding window: " + findLength(nums, target));
    }

    /**
     * Example 1: Given an array of positive integers nums and an integer k, find the length of the longest subarray
     * whose sum is less than or equal to k.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findLength(int[] nums, int target) {
        int left = 0;;
        int curr = 0;
        int length = 0;
        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while(curr > target) {
                curr -= nums[left];
                left++;
            }
            length = Math.max(length, (right - left + 1));
        }

        return length;
    }

    /**
     * You are given a binary string s (a string containing only "0" and "1"). You may choose up to one "0" and flip
     * it to a "1". What is the length of the longest substring achievable that contains only "1"?
     *
     * For example: given s = "1101100111", the answer is 5. If you perform the flip at index 2, the string
     * becomes 1111100111.
     *
     * Another way to look at this problem is "what is the longest substring that contains at most one "0"?"
     *
     * @param binaryString
     * @param flipChar
     * @return
     */
    public static int findLongestSubString(String binaryString, char flipChar) {

    }
}
