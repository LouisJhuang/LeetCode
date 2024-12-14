package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TwoSumTest {

    @Test
    public void test() {
        int [] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum twoSum = new TwoSum();

        int [] answer = twoSum.solution(nums, target);
        System.out.println(Arrays.toString(answer));
    }


}
