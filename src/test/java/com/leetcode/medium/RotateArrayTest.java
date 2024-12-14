package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RotateArrayTest {

    @Test
    public void test() {
        // test case 1
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // test case 2
//        int[] nums = {-1,-100,3,99};
//        int k = 2;

        RotateArray rotateArray = new RotateArray();
        int [] answer = rotateArray.solution(nums, k);

        System.out.print(Arrays.toString(answer));

    }




}
