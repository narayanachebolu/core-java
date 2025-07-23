package org.com.dsa.arraysstrings;

import java.util.Arrays;

public class TwoPointers {
    public static void main(String[] args) {
        String s = "racecar";
        // using StringBuilder
        System.out.println(new StringBuilder(s).reverse().toString().equals(s));

        System.out.println(s + (checkIfPalindrome(s) ? " is a Palindrome." : " is NOT a Palindrome."));

        /**-----------------------------*/
        int[] nums = {1, 2, 4, 6, 8, 9, 14, 15};
        int target = 30;
        System.out.println(target + (checkForTarget(nums, target) ? " found." : " not found."));


        /**----------------------------------*/
        target = 3;
        System.out.println(target + " found at indexs: " + Arrays.toString(twoSum(nums, target)));
    }

    public static boolean checkIfPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
     }

     public static boolean checkForTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int current = nums[left] + nums[right];

            if (current == target) {
                return true;
            }

            if (current > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
     }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
     * to target. You may assume that each input would have exactly one solution, and you may not use the same element
     * twice. You can return the answer in any order.
     *
     * @param num
     * @param target
     * @return
     */
     public static int[] twoSum(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;

        while (left < right) {
            int current = num[left] + num[right];

            if (current == target) {
                return new int[] {left, right};
            }

            if (current > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] {};
     }
}
