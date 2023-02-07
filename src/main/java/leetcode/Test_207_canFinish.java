package leetcode;

import java.util.*;

/**
 * @author jwang55
 */
public class Test_207_canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return false;
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
