package org.github.fourth.leetcode.common.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        this.neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    // 需要掌握的一些方法

    /**
     * 求的图的联通分量
     * 连接表
     * 二维矩阵
     * edge表示
     */
    public int countComponents() {
        return 0;
    }

    //


    public static Node build(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return new Node();
        }

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            int[] values = graph[i];
            Node node = map.getOrDefault(i, new Node(i));
            map.put(i, node);
            for (int j = 0; j < values.length; j++) {
                if (graph[i][j] == 1 && i != j) {
                    Node node2 = map.getOrDefault(j, new Node(j));
                    map.put(j, node2);
                    node.neighbors.add(node2);
                }
            }
        }
        return map.values().stream().findFirst().orElse(null);
    }

    public int[][] convert(int nodesCount) {
        int[][] graph = new int[nodesCount][nodesCount];
        if (nodesCount == 0) {
            return graph;
        }
        boolean[] visited = new boolean[nodesCount];
        convertDepth(graph, visited, this);
        return graph;
    }

    private void convertDepth(int[][] graph, boolean[] visited, Node node) {
        if (visited[node.val]) {
            return;
        }
        visited[node.val] = true;
        graph[node.val][node.val] = 1;

        for (Node neighbor : node.neighbors) {
            graph[node.val][neighbor.val] = 1;
            convertDepth(graph, visited, neighbor);
        }
    }
}
