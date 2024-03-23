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

    public List<DirectedGraphNode> topologicalSort() {
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

    public static void main(String[] args) {
        DirectedGraphNode node1 = new DirectedGraphNode(1);
        DirectedGraphNode node2 = new DirectedGraphNode(2);
        DirectedGraphNode node3 = new DirectedGraphNode(3);
        DirectedGraphNode node4 = new DirectedGraphNode(4);
        DirectedGraphNode node5 = new DirectedGraphNode(5);
        DirectedGraphNode node6 = new DirectedGraphNode(6);

        List<DirectedGraphNode> adjList1 = new ArrayList<>();
        adjList1.add(node2);
        adjList1.add(node3);
        adjList1.add(node4);
        node1.setAdjNodeList(adjList1);

        List<DirectedGraphNode> adjList2 = new ArrayList<>();
        adjList2.add(node5);
        node2.setAdjNodeList(adjList2);

        List<DirectedGraphNode> adjList3 = new ArrayList<>();
        adjList3.add(node5);
        node3.setAdjNodeList(adjList3);

        List<DirectedGraphNode> adjList4 = new ArrayList<>();
        adjList4.add(node5);
        adjList4.add(node6);
        node4.setAdjNodeList(adjList4);

        List<DirectedGraphNode> adjList6 = new ArrayList<>();
        adjList6.add(node5);
        node6.setAdjNodeList(adjList6);

        List<DirectedGraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(node1);
        graphNodes.add(node2);
        graphNodes.add(node3);
        graphNodes.add(node4);
        graphNodes.add(node5);
        graphNodes.add(node6);
        DirectedGraph graph = new DirectedGraph(graphNodes);

        List<DirectedGraphNode> result = graph.topologicalSort();
        result.forEach(node -> {
            System.out.println("Thr cue node no: " + node.getNo());
        });

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
