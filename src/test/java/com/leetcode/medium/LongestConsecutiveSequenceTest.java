package com.leetcode.medium;

import org.junit.jupiter.api.Test;

public class LongestConsecutiveSequenceTest {

    @Test
    public void test() {
        // test case 1
        // Output: 4
        // int[] nums = {100, 4, 200, 1, 3, 2};

        // test case 2
        // Output: 9
        // int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        // test case 3
        // Output: 3
        // int[] nums = {1, 0, 1, 2};

        // test case 4
        // Output: 7
        // int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

        // test case 5
        // Output: 5
        int[] nums = {4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};

        LongestConsecutiveSequence longConSeq = new LongestConsecutiveSequence();
        int answer = longConSeq.solution(nums);

        System.out.print(answer);
    }

}
