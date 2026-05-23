package com.leetcode.easy;

import org.junit.jupiter.api.Test;

public class FindIfPathExistsInGraphTest {

    @Test
    public void test() {
        // test case 1
        // int n = 3;
        // int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        // int source = 0;
        // int destination = 2;

        // test case2
        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source = 0;
        int destination = 5;


        FindIfPathExistsInGraph findIfPathExistsInGraph = new FindIfPathExistsInGraph();
        boolean answer = findIfPathExistsInGraph.solution(n, edges, source, destination);
        System.out.println("answer: " + answer);
    }

}
