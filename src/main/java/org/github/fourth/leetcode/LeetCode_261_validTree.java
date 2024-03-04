package org.github.fourth.leetcode;

import java.util.*;

/**
 * 给定编号从 0 到 n - 1 的 n 个结点。给定一个整数 n 和一个 edges 列表，其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间存在一条无向边。
 * 如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。
 */
public class LeetCode_261_validTree {

    /**
     * 使用DFS计算联通分量
     */
    public boolean validTree01(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0) {
            return false;
        }

        // 1. 边数 = 节点数 - 1
        if (edges.length != n - 1) {
            return false;
        }

        // 2. 求联通分量 --> 转换成链接表
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                ++count;
            }
        }
        return count == 1;
    }

    private void dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int nodeNum) {
        if (visited[nodeNum]) {
            return;
        }
        visited[nodeNum] = true;
        List<Integer> values = adj.get(nodeNum);
        for (Integer node : values) {
            if (!visited[node]) {
                dfs(adj, visited, node);
            }
        }
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean validTreeBfsExample(int n, int[][] edges) {
        if (n == 0 || edges == null || edges.length == 0
                || edges[0] == null || edges[0].length == 0) {
            return false;
        }
        // 满足是树的条件
        // （1）边数等于节点数 - 1
        if (edges.length != n - 1) {
            return false;
        }

        // （2）图的连通分量为1
        int count = 0;
        // 从每个节点开始遍历
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 防止重复访问
            if (!visited[i]) {
                bfsExample(edges, visited, i);
                count++;
            }
        }
        return count == 1;
    }

    private void bfsExample(int[][] edges, boolean[] visited, int node) {
        // 1、构建队列
        Queue<Integer> queue = new LinkedList<>();
        // 2、将初始节点加入队列，并标记
        queue.offer(node);
        visited[node] = true;
        // 3、bfs遍历
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            // 在邻接矩阵中找到当前节点的邻接节点
            int length = edges[curNode].length;
            for (int i = 0; i < length; i++) {
                // 只有值为1时，才是节点；不能重复访问
                if (edges[curNode][i] == 1 && !visited[i]) {
                    // 加入队列，并标记
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * 通过DFS方式计算
     */
    public boolean validTreeWithDfsExample(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }

        // 边数 = 结点数 - 1
        if (edges.length != n - 1) {
            return false;
        }

        // 连通分量为 1
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
        return count == 1;
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
