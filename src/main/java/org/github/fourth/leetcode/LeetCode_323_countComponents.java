package org.github.fourth.leetcode;

import java.util.*;

/**
 * 你有一个包含 n 个节点的图。给定一个整数 n 和一个数组 edges ，其中 edges[i] = [ai, bi] 表示图中 ai 和 bi 之间有一条边。
 *
 * 返回 图中已连接分量的数目 。
 */
public class LeetCode_323_countComponents {

    /**
     * 使用BFS方式计算
     * 时间复杂度：
     * 空间复杂度：
     */
    public int countComponents(int n, int[][] edges) {
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
                bfs(adj, i, marked);
                result++;
            }
        }
        return result;
    }

    private void bfs(Map<Integer, List<Integer>> adj, int nodeNum, boolean[] marked) {
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
                dfs(adj, i, marked);
                count++;
            }
        }

        return count;
    }

    private void dfs(Map<Integer, List<Integer>> adj, int nodeNum, boolean[] marked) {
        marked[nodeNum] = true;
        for (Integer adjNode : adj.get(nodeNum)) {
            if (!marked[adjNode]) {
                dfs(adj, adjNode, marked);
            }
        }
    }
}
