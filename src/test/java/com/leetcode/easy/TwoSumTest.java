package com.leetcode.easy;

import org.junit.jupiter.api.Test;

public class TwoSumTest {

    @Test
    public void test() {
        int [] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum twoSum = new TwoSum();

        int [] answer = twoSum.solution(nums, target);
        for(int num : answer) {
            System.out.println("answer: " + num);
        }
    }


}
