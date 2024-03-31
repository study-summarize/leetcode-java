package org.github.fourth.struct.graph;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.*;

/**
 * 有向图
 */
public class DirectedGraph {

    private final List<DirectedGraphNode> graphNodes;

    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public DirectedGraph(List<DirectedGraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    /**
     * 拓扑排序
     */
    public List<DirectedGraphNode> topologicalSortExample() {
        List<DirectedGraphNode> result = new ArrayList<>();
        // 1、计算每个节点的入度，用map维护；key是当前图节点，value是入度值
        Map<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        for (DirectedGraphNode node : graphNodes) {
            // 入度：谁指向我
            for (DirectedGraphNode adjNode : node.getAdjNodeList()) {
                if (!indegreeMap.containsKey(adjNode)) {
                    indegreeMap.put(adjNode, 1);
                } else {
                    indegreeMap.put(adjNode, indegreeMap.get(adjNode) + 1);
                }
            }
        }
        // 2、将入度为0的节点，加入队列
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graphNodes) {
            if (!indegreeMap.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        // 3、BFS
        while (!queue.isEmpty()) {
            DirectedGraphNode curNode = queue.poll();
            for (DirectedGraphNode adjNode : curNode.getAdjNodeList()) {
                // 邻接节点入度减1
                int indegree = indegreeMap.get(adjNode) - 1;
                indegreeMap.put(adjNode, indegree);
                if (indegree == 0) {
                    queue.offer(adjNode);
                    result.add(adjNode);
                }
            }
        }
        return result;
    }

    public List<DirectedGraphNode> topologicalSort() {
        List<DirectedGraphNode> result = new ArrayList<>();
        // 1、遍历整个图所有节点的入度
        Map<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        for (DirectedGraphNode node : graphNodes) {
            // 入度：谁指向我
            for (DirectedGraphNode adjNode : node.getAdjNodeList()) {
                if (!indegreeMap.containsKey(adjNode)) {
                    indegreeMap.put(adjNode, 1);
                } else {
                    indegreeMap.put(adjNode, indegreeMap.get(adjNode) + 1);
                }
            }
        }
        // 2、找到入度为0的，加入队列
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graphNodes) {
            if (!indegreeMap.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }
        // 3、只要队列不为空时
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            result.add(node);
            // 3.1 将和当前节点相关的入度都减1
            for (DirectedGraphNode adjNode : node.getAdjNodeList()) {
                // 邻接节点入度减1
                int indegree = indegreeMap.get(adjNode) - 1;
                indegreeMap.put(adjNode, indegree);
                if (indegree == 0) {
                    queue.offer(adjNode);
                    result.add(adjNode);
                }
            }
        }
        return result;
    }

}

class DirectedGraphNode {
    private int no;
    private List<DirectedGraphNode> adjNodeList;

    public DirectedGraphNode(int no) {
        this.no = no;
        this.adjNodeList = new ArrayList<>();
    }

    public DirectedGraphNode() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<DirectedGraphNode> getAdjNodeList() {
        return adjNodeList;
    }

    public void setAdjNodeList(List<DirectedGraphNode> adjNodeList) {
        this.adjNodeList = adjNodeList;
    }
}
