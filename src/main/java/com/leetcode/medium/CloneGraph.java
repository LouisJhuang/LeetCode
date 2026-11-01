package com.leetcode.medium;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 */

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    // 建立一個 HashMap 作為「舊節點 -> 新節點」的對應字典
    private final Map<Node, Node> visited = new HashMap<>();

    public Node solution(Node node) {
        // 1. 邊界條件：如果傳進來的節點是空的, 直接回傳 null
        if (node == null) {
            return null;
        }

        // 2. 查 map：如果這個舊節點已經被複製過了, 直接回傳對應的新分身
        // 這邊會在遞迴的最底開始返回當下的 node
        if (visited.containsKey(node)) {
            // 回傳 map 中對應的「新分身 (Value)」 而不是舊節點
            return visited.get(node);
        }

        // 3. 建立當前節點的全新分身 (複製 val)
        // 先建立一個空殼, 此時只有先放 val, 還沒放 neighbors
        Node cloneNode = new Node(node.val);

        // 4. 把「舊節點 -> 新分身」記錄到 map 裡
        // 避免走訪到同一個舊節點時陷入無窮迴圈
        visited.put(node, cloneNode);

        // 5. 走訪舊節點的所有鄰居, 遞迴呼叫複製方法, 並把複製好的鄰居加入新分身的 neighbors 列表中
        // 到最底之後才開始一層一層返回
        for (Node neighbor : node.neighbors) {
            // 等到走到最底之後, 加進去的就是 visited 新分身
            // 對應 key(舊) ==> value(新)
            cloneNode.neighbors.add(solution(neighbor));
        }

        // 6. 回傳這個完整複製好的新節點
        return cloneNode;
    }

}
