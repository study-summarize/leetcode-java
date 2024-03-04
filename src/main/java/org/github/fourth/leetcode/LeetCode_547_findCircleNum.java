package org.github.fourth.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 */
public class LeetCode_547_findCircleNum {

    /**
     * 使用DFS的方式
     */
    public int findCircleNum01(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        int result = 0;

        // 无向图的标记只需要用到一维？
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            // 依次遍历节点，但只遍历未经过的节点
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                ++result;
            }
        }
        return result;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int cityNum) {
        // 把当前节点置为以访问
        visited[cityNum] = true;
        // 以该行，依次对各个节点进行标记
        int[] value = isConnected[cityNum];
        for (int i = 0; i < value.length; i++) {
            if (value[i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }

    /**
     * 使用BFS方式
     * 时间复杂度：
     * 空间复杂度：
     */
    public int findCircleNumExample(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0
                || isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }
        int count = 0;

        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                bfsExample(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void bfsExample(int[][] isConnected, boolean[] visited, int cityNum) {
        // 1、构建队列
        Queue<Integer> queue = new LinkedList<>();
        // 2、加入初始节点，并标记
        queue.offer(cityNum);
        visited[cityNum] = true;
        // 3、bfs遍历
        while (!queue.isEmpty()) {
            Integer curCityNum = queue.poll();
            // 获取当前城市的邻接节点
            int size = isConnected[curCityNum].length;
            for (int adjCityNum = 0; adjCityNum < size; adjCityNum++) {
                // 去除重复遍历点
                if (isConnected[curCityNum][adjCityNum] == 1) {
                    // 去除重复遍历点
                    if (!visited[adjCityNum]) {
                        visited[adjCityNum] = true;
                        queue.offer(adjCityNum);
                    }
                }
            }
        }
    }

    /**
     * 使用DFS方式
     * 时间复杂度：
     * 空间复杂度：
     */
    public int findCircleNumWithDfsExample(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        // 图的连通分量
        int count = 0;

        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfsExample(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfsExample(int[][] isConnected, boolean[] visited, int cityNum) {
        visited[cityNum] = true;
        int[] values = isConnected[cityNum];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 1 && !visited[i]) {
                dfsExample(isConnected, visited, i);
            }
        }
    }
}
