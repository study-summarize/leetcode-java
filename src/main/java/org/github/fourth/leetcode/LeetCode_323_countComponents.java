package org.github.fourth.leetcode;

import java.util.*;

/**
 * 你有一个包含 n 个节点的图。给定一个整数 n 和一个数组 edges ，其中 edges[i] = [ai, bi] 表示图中 ai 和 bi 之间有一条边。
 * 返回 图中已连接分量的数目 。
 */
public class LeetCode_323_countComponents {

    /**
     * 使用DFS方法
     */
    public int countComponents01(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0) {
            return 0;
        }

        // 先生成二维矩阵
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i][i] = 1;
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        int result = 0;
        boolean[] visited = new boolean[n];
        // DFS 遍历所有节点
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                ++result;
            }
        }
        return result;
    }

    private void dfs(int[][] graph, boolean[] visited, int nodeNum) {
        if (visited[nodeNum]) {
            return;
        }
        visited[nodeNum] = true;
        int[] values = graph[nodeNum];
        for (int i = 0; i < values.length; i++) {
            if (!visited[i] && values[i] == 1) {
                dfs(graph, visited, i);
            }
        }
    }

    /**
     * 使用BFS方式计算
     * 时间复杂度：
     * 空间复杂度：
     */
    public int countComponentsExample(int n, int[][] edges) {
        int result = 0;

        // 构建邻接表:防止一些孤立节点
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // BFS
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                bfsExample(adj, i, marked);
                result++;
            }
        }
        return result;
    }

    private void bfsExample(Map<Integer, List<Integer>> adj, int nodeNum, boolean[] marked) {
        // 1、构建队列
        Queue<Integer> queue = new LinkedList<>();
        // 2、加入初始节点，并标记
        queue.add(nodeNum);
        marked[nodeNum] = true;
        // 3、BFS遍历
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> adjList = adj.get(node);
            // 遍历邻接节点
            if (adjList != null) {
                for (Integer adjNode : adjList) {
                    if (!marked[adjNode]) {
                        queue.offer(adjNode);
                        marked[adjNode] = true;
                    }
                }
            }
        }
    }

    /**
     * 使用DFS方法计算
     * 时间复杂度：
     * 空间复杂度：
     */
    public int countComponentsWithDFS(int n, int[][] edges) {
        // 做了几次DFS
        int count = 0;

        // 构建邻接表
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // note：防止有一些孤立的节点
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // DFS
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfsExample(adj, i, marked);
                count++;
            }
        }

        return count;
    }

    private void dfsExample(Map<Integer, List<Integer>> adj, int nodeNum, boolean[] marked) {
        marked[nodeNum] = true;
        for (Integer adjNode : adj.get(nodeNum)) {
            if (!marked[adjNode]) {
                dfsExample(adj, adjNode, marked);
            }
        }
    }
}
