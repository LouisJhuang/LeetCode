package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Example 3:
 *
 * Input: nums = [1,0,1,2]
 * Output: 3
 *
 * Input: nums = [9,1,4,7,3,-1,0,5,8,-1,6]
 * Output: 7
 *
 * Input: nums = [4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3]
 * Output: 5
 *
 * Constraints:
 * 0 <= nums.length <= Math.pow(10,5)
 * Math.pow(-10,9) <= nums[i] <= Math.pow(10,9)
 */
public class LongestConsecutiveSequence {

    public int solution(int[] nums) {

        // 儲存公差用
        int tolerance = 1;
        // 當前連續的數值
        int curConSequence = 0;
        // 儲存答案用, 最大共有多少連續數值
        int maxConSequence = 0;
        // 儲存不重複數值用
        HashSet<Integer> hashSetNums = new HashSet<>();

        // 先將重複的數值去除掉
        for(int num : nums) {
            hashSetNums.add(num);
        }

        // 將題目傳入的 nums 轉為不重複 array
        nums = hashSetNums.stream().mapToInt(num -> num).toArray();

        // 排序方便後續作業
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();

        // 記數用
        for (int j = 0; j < sortedNums.length - 1; j++) {
            if ( (sortedNums[j+1] - sortedNums[j]) ==  tolerance ) {
                curConSequence ++;
                // 若當前>最大連續, 則更新
                if (curConSequence > maxConSequence) {
                    maxConSequence = curConSequence;
                }
            } else {
                // 若沒有連續則終止計數, 並且歸0
                curConSequence = 0;
            }

        }

        // 若沒有傳入任何值情況
        if (sortedNums.length != 0) {
            maxConSequence += 1;
        }

        return maxConSequence;
    }

    /**
     * 不使用這邊的手刻排序
     * 這邊時間複雜度會變成 BigO(n2)
     */
    public int[] sort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                int tempNum = nums[j];
                if (nums[j+1] < tempNum) {
                    nums[j] = nums[j+1];
                    nums[j+1] = tempNum;
                }
            }
        }
        return nums;
    }

}
