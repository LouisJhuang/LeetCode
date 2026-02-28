package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void test() {
        // test case 1
        // Output: 3
        String testString1 = "abcabcbb";

        // test case 2
        // Output: 1
        String testString2 = "bbbbb";

        // test case 3
        // Output: 3
        String testString3 = "pwwkew";

        // test case 4
        // Output: 1
        String testString4 = " ";

        // test case 5
        // Output: 2
        String testString5 = "cdd";

        // test case 6
        // Output: 3
        String testString6 = "dvdf";

        // testing
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();

        // 一次測試多筆
        List<String> testStringList = List.of(testString1, testString2, testString3, testString4, testString5, testString6);
        // List<String> testStringList = List.of(testString6);

        List<Integer> allTestResult = new ArrayList<>();
        for (String testString : testStringList) {
            int answer = test.solution(testString);
            allTestResult.add(answer);
        }

        System.out.print(allTestResult);
    }

}
