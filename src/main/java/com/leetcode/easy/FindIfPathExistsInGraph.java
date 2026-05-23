package com.leetcode.easy;

import java.util.*;

public class FindIfPathExistsInGraph {

    public boolean solution(int n, int[][] edges, int source, int destination) {
        // 1. 如果起點 = 終點, 直接結束
        if (source == destination) {
            return true;
        }

        // 2. 準備好 graph map, 並將題目給的 edges 存入裡面
        // 2.1. 用 Map 來儲存圖, key 是節點, value 是該節點的所有鄰居
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 2.2. 先將 graph 設立好空間
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 3. 將 edges 2d array 放入 graph
        // 3.1. 這邊因為 2d array, 只要使用 2 個get即可滿足所有情況
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 4. 將所有的 graph 走訪
        // 4.1. 判斷下一輪要走訪的 node
        Stack <Integer> stack = new Stack<>();
        // 4.2. 儲存已經走訪過的 node
        boolean[] visited = new boolean[n];
        // 4.3. 先從 source 開始走, 所以 stack 放入起點, 並且 visited = true
        stack.push(source);
        visited[source] = true;

        // 5. 當 stack 裡面有值就繼續走訪
        while(!stack.empty()) {
            // 5.1. 先取出 stack, 當作目前的 node
            Integer currentNode = stack.pop();
            // 5.2. 假如走到終點了, 那就視為有連通, 不需要繼續走下去
            if (currentNode ==  destination) {
                return true;
            }
            // 5.3. 走訪 graph 裡面的所有 value, 也就是相鄰 list
            for (Integer list : graph.get(currentNode)) {
                // 如果這個 node 沒有走訪過, 那這裡就要標記為走訪過, 並且更新 stack, 做為下一輪的內容
                if (!visited[list]) {
                    visited[list] = true;
                    stack.push(list);
                }
            }
        }

        // 6. 如果上述graph 都走訪完了, 依然沒找到, 視為不連通
        return false;
    }

}
