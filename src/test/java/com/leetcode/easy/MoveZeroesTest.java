package com.leetcode.easy;

import org.junit.jupiter.api.Test;

public class MoveZeroesTest {

    @Test
    public void test() {

        // test case 1
        // Output: [1,3,12,0,0]
        // int [] nums = {0, 1, 0, 3, 12};

        // test case 2
        // Output: [2,1]
        int [] nums = {2, 1};

        MoveZeroes moveZeroes = new MoveZeroes();
        int [] results = moveZeroes.solution(nums);
        for (int result : results) {
            System.out.println(result);
        }
    }

}
