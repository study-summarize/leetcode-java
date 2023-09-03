package leetcode;

import java.util.*;

/**
 * @author jwang55
 */
public class Test_261_validTree {

    public boolean validTree(int n, int[][] edges) {
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
                bfs(edges, visited, i);
                count++;
            }
        }
        return count == 1;
    }

    private void bfs(int[][] edges, boolean[] visited, int node) {
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
    public boolean validTreeWithDfs(int n, int[][] edges) {
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
                dfs(adj, i, marked);
                count++;
            }
        }
        return count == 1;
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
