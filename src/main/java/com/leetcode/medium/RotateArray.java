package com.leetcode.medium;

import java.util.HashMap;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * *
 * Follow up:
 *
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    public int [] solution(int[] nums, int k) {

        // solution 1
        // Wrong Answer
        // 此種 array 操作不被接受
        /*
        int [] newArray = new int[nums.length];

        for (int i = 0; i < k ; i++) {
            int oldTempInt = 0;
            int newTempInt = 0;

            if (i == 0) {
                int lastInt = nums[nums.length - 1];
                newArray[0] = lastInt;
            } else {
                int lastInt = newArray[nums.length - 1];
                oldTempInt = newArray[0];
                newArray[0] = lastInt;
            }

            for (int j = 0; j < nums.length - 1; j++) {
                if (i == 0) {
                    newArray[j + 1] = nums[j];
                } else {
                    newTempInt = newArray[j + 1];
                    newArray[j + 1] = oldTempInt;
                    oldTempInt = newTempInt;
                }
            }

        }

        return newArray;
        */


        // solution 2
        // Time Limit Exceeded
        // 在大數據測試下，時間複雜度爆掉
        /*
        HashMap<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < k ; i++) {
            tempMap.put("NEW", nums[0]);
            tempMap.put("OLD", nums[nums.length - 1]);
            tempMap.put("LAST", nums[nums.length - 1]);

            for (int j = 0; j < nums.length; j++) {

                if (j == 0) {
                    nums[j] = tempMap.get("LAST");
                } else {
                    tempMap.put("OLD", nums[j]);
                    nums[j] = tempMap.get("NEW");
                    tempMap.put("NEW", tempMap.get("OLD"));
                }

            }
        }
        return nums;
        */

        // solution 3
        int n = nums.length;
        // 用來放翻轉後的 array 應該要有的 index & element
        HashMap<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            System.out.println((i + k) % n);
            // (i + k) % n 計算元素在旋轉後的位置
            tempMap.put((i + k) % n, nums[i]);
        }
        // update array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tempMap.get(i);
        }
        return nums;

    }

}
