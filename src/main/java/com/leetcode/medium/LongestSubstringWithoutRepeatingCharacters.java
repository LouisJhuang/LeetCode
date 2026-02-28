package com.leetcode.medium;

import java.util.*;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int solution(String s) {
        // 儲存所有結果的 List
        List<Integer> resultList = new ArrayList<>();
        // 轉換成 Character List
        List<Character> cleanCharList = ToCharList(s);
        // 設定初始起始點
        final int startIndex = 0;
        // 設定初始結束點
        int endIndex = 0;

        // 取得起始點
        endIndex = GetEndIndex(cleanCharList);
        // 取出 List 的區間
        List<Character> answerCharList = cleanCharList.subList(startIndex, endIndex);
        // 儲存此次 Substring 長度
        resultList.add(answerCharList.size());

        // 計算所有排列組合的可能結果：因為不知道有幾種組合, 所以所有排列組合都要做到
        // 每一次迴圈都會往右偏移一格起始點
        int newStartIndex = 0;
        // 迴圈直到 startIndex == endIndex
        while (startIndex != endIndex) {
            // 因為前面已經做過 0, 這邊從 1 開始去找
            newStartIndex ++;
            // 取得全部 List size 當作結束點
            endIndex = cleanCharList.size();
            // 取出 List 的區間
            List<Character> newCharList = cleanCharList.subList(newStartIndex, endIndex);
            // 取得結束點
            endIndex = GetEndIndex(newCharList);
            List<Character> newAnswerCharList = newCharList.subList(startIndex, endIndex);
            // 儲存此次 Substring 長度
            resultList.add(newAnswerCharList.size());
        }

        return Collections.max(resultList);
    }

    /**
     * 轉換成 Character List
     */
    private List<Character> ToCharList(String originString) {
        List<Character> cleanStringList = new ArrayList<>();

        for(char s : originString.toCharArray()) {
            cleanStringList.add(s);
        }

        return cleanStringList;
    }

    /**
     * 取得結束點 index
     */
    private int GetEndIndex(List<Character> cleanCharList) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int endIndex = 0;

        for (Character c : cleanCharList) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, 1);
                endIndex ++;
            } else {
                int duplicateValue = charMap.get(c);
                charMap.replace(c, duplicateValue+1);
            }
            if (charMap.get(c) == 2) {
                // 一旦遇到有重複的就直接將這裡設為結束點
                return endIndex;
            }
        }

        return endIndex;
    }

    /**
     * 清除特殊符號
     */
    private List<Character> RemoveSymbols(String originString) {

        List<Character> cleanStringList = new ArrayList<>();

        for(char s : originString.toCharArray()) {
            if (s != '!' && s != '@' && s != '#' && s != '$' && s != '%' &&
                    s != '^' && s != '&' && s != '*' && s != '(' && s != ')' &&
                    s != '-' && s != '=' && s != ',' && s != '.' && s != '?' &&
                    s != ' ') {
                cleanStringList.add(s);
            }
        }

        return cleanStringList;
    }

    /**
     * 取得起始點 index
     */
    private int GetStartIndex(List<Character> cleanCharList, int endIndex) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int startIndex = 0;

        // 前面已經取得新的起始點, 接下來只需要知道結尾在那裡就好
        List<Character> newCharList = cleanCharList.subList(startIndex, endIndex);

        for (Character c : newCharList) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, 1);
                endIndex ++;
            }
            if (charMap.get(c) == 2) {
                // 一旦發現有重複, 就將那理設為結束點
                return endIndex;
            }
        }

        return endIndex;
    }
}
