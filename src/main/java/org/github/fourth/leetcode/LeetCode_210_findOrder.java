package org.github.fourth.leetcode;

import java.util.*;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * - 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 */
public class LeetCode_210_findOrder {

    /**
     *
     */
    public int[] findOrder01(int numCourses, int[][] prerequisites) {
        return new int[0];
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int[] findOrderExample(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        int index = 0;
        // 构造邻接表 key：第几门课；value：邻接节点
        List<List<Integer>> graphNodes = new ArrayList<>();
        // (1)对所有节点构建key
        for (int i = 0; i < numCourses; i++) {
            graphNodes.add(new ArrayList<>());
        }
        // (2)构建邻接表
        for (int[] edge : prerequisites) {
            int start = edge[1];
            int end = edge[0];
            graphNodes.get(start).add(end);
        }

        // 1、遍历计算所有节点入度
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        for (List<Integer> adjNodes : graphNodes) {
            for (Integer adjNode : adjNodes) {
                if (indegreeMap.containsKey(adjNode)) {
                    indegreeMap.put(adjNode, indegreeMap.get(adjNode) + 1);
                } else {
                    indegreeMap.put(adjNode, 1);
                }
            }
        }
        // 2、入度为0的节点放入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegreeMap.containsKey(i)) {
                queue.add(i);
                result[index++] = i;
            }
        }
        // 3、BFS
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            List<Integer> adjNodes = graphNodes.get(curNode);
            for (Integer adjNode : adjNodes) {
                // 邻接节点入度减1
                int updatedIndegree = indegreeMap.get(adjNode) - 1;
                indegreeMap.put(adjNode, updatedIndegree);
                // 如果更新后节点入度为0，则入队
                if (updatedIndegree == 0) {
                    queue.offer(adjNode);
                    result[index++] = adjNode;
                }
            }
        }
        // 因为最后一个++
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
