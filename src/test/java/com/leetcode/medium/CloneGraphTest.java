package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CloneGraphTest {

    @Test
    public void test() {
        // test case 1
        // Output: [[2,4],[1,3],[2,4],[1,3]]
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};

        // test case 2
        // Output: [[]]
        // int[][] adjList = { {} };

        // test case 3
        // Output: []
        // int[][] adjList = {};

        // 1. 將二維陣列測資轉為圖的 Node 結構
        Node node = buildGraph(adjList);

        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.solution(node);

        // 3. 將複製後的圖轉回列表格式並列印出來
        List<List<Integer>> answer = graphToAdjList(clonedNode);
        System.out.println(answer);
    }

    /**
     * 將 LeetCode 的 adjList (二維陣列) 轉成 Node 物件
     */
    private Node buildGraph(int[][] adjList) {
        if (adjList == null || adjList.length == 0) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= adjList.length; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 0; i < adjList.length; i++) {
            Node curr = map.get(i + 1);
            for (int neighborVal : adjList[i]) {
                curr.neighbors.add(map.get(neighborVal));
            }
        }
        return map.get(1);
    }

    /**
     * 將複製後的 Node 轉回鄰接串列格式, 方便直接用 System.out.print 看結果
     */
    private List<List<Integer>> graphToAdjList(Node node) {
        if (node == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            List<Integer> neighbors = new ArrayList<>();
            for (Node neighbor : curr.neighbors) {
                neighbors.add(neighbor.val);
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            Collections.sort(neighbors);
            map.put(curr.val, neighbors);
        }

        return new ArrayList<>(map.values());
    }
}
