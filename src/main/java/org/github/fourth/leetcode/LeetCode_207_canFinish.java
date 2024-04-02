package org.github.fourth.leetcode;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * - 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class LeetCode_207_canFinish {

    /**
     * BFS：拓扑排序
     */
    public boolean canFinish01(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return false;
        }
        if (prerequisites[0].length == 0) {
            return true;
        }
        // 1、先转换成邻接表，并统计每个节点的入度
        List<List<Integer>> graphNodes = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graphNodes.add(new ArrayList<>());
        }
        for (int[] preRequest: prerequisites) {
            int start = preRequest[1];
            int end = preRequest[0];
            graphNodes.get(end).add(start);
        }
        // 1、计算每个节点的入度
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
        // 2、将入度为0的节点放入队列中
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegreeMap.containsKey(i)) {
                queue.offer(i);
            }
        }
        // 3、BFS遍历
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            result.add(curNode);
            List<Integer> adjNodes = graphNodes.get(curNode);
            for (Integer adjNode : adjNodes) {
                // 邻接节点入度减1
                int updatedIndegree = indegreeMap.get(adjNode) - 1;
                indegreeMap.put(adjNode, updatedIndegree);
                // 如果更新后节点入度为0，则入队
                if (updatedIndegree == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        return result.size() == numCourses;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean canFinishExample(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null || prerequisites.length == 0) {
            return false;
        }
        if (prerequisites[0].length == 0) {
            return true;
        }
        List<Integer> result = new ArrayList<>();
        // 转换成邻接表
        List<List<Integer>> graphNodes = new ArrayList<>();
        // (1)初始化各个节点的邻接节点
        for (int i = 0; i < numCourses; i++) {
            graphNodes.add(new ArrayList<>());
        }
        // (2)设置邻接节点
        for (int[] adjNodes : prerequisites) {
            int start = adjNodes[1];
            int end = adjNodes[0];
            graphNodes.get(start).add(end);
        }

        // 1、计算每个节点的入度
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
        // 2、将入度为0的节点放入队列中
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegreeMap.containsKey(i)) {
                queue.offer(i);
            }
        }
        // 3、BFS遍历
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            result.add(curNode);
            List<Integer> adjNodes = graphNodes.get(curNode);
            for (Integer adjNode : adjNodes) {
                // 邻接节点入度减1
                int updatedIndegree = indegreeMap.get(adjNode) - 1;
                indegreeMap.put(adjNode, updatedIndegree);
                // 如果更新后节点入度为0，则入队
                if (updatedIndegree == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        return result.size() == numCourses;
    }
}
