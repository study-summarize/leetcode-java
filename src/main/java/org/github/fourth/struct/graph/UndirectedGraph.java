package org.github.fourth.struct.graph;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jwang55
 * - 连接矩阵
 * - 连接表
 * 无向图
 */
public class UndirectedGraph {
    // 邻接表：key是当前节点；value是相邻节点集合
    private final Map<Node, List<Node>> adjacencyList;
    // 是否被访问过的节点标识
    private final boolean[] marked;
    // 统计联通分量
    private int connectComponentCount;

    // 构造器
    public UndirectedGraph(int vertexCount) {
        this.adjacencyList = new HashMap<>();
        this.marked = new boolean[vertexCount];
    }

    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public UndirectedGraph(Map<Node, List<Node>> adjacencyList, boolean[] marked) {
        this.adjacencyList = adjacencyList;
        this.marked = marked;
    }

    // method
    public void addVertex(Node v) {
        this.adjacencyList.put(v, new ArrayList<>());
    }

    public void addEdge(Node u, Node v) {
        // note: u、v是否都在？？？
        this.adjacencyList.get(u).add(v);
        this.adjacencyList.get(v).add(u);
    }

    public int getConnectComponentCount() {
        return connectComponentCount;
    }

    @SuppressFBWarnings("WMI_WRONG_MAP_ITERATOR")
    public void printGraph() {
        for (Node key : adjacencyList.keySet()) {
            List<Node> adjNodes = adjacencyList.get(key);
            String stringList = adjNodes.stream()
                    .map(Node::getNo).map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(key.getNo() + " : " + stringList);
        }
    }

    public void dfsInGraph() {
        Arrays.fill(marked, false);
        connectComponentCount = 0;
        for (Node startNode : adjacencyList.keySet()) {
            if (!marked[startNode.getNo()]) {
                this.dfs(startNode);
                this.connectComponentCount++;
            }
        }
    }

    public void dfsInComponent(Node start) {
        Arrays.fill(marked, false);
        this.dfs(start);
    }


    /**
     * dfs模板
     */
    private void dfs(Node start) {
        marked[start.getNo()] = true;
        System.out.println("DFS current node : " + start.no + " value: " + start.value);
        // 遍历连接表节点
        for (Node adjNode : adjacencyList.get(start)) {
            if (!marked[adjNode.no]) {
                dfs(adjNode);
            }
        }
    }

    // BFS模板：BFS全图
    public void bfsInGraph() {
        Arrays.fill(marked, false);
        connectComponentCount = 0;
        for (Node startNode : adjacencyList.keySet()) {
            if (!marked[startNode.getNo()]) {
                this.bfs(startNode);
                this.connectComponentCount++;
            }
        }
    }

    // BFS模板：以start节点为起点在某一连通分量上BFS
    public void bfsInComponent(Node start) {
        Arrays.fill(marked, false);
        bfs(start);
    }

    // BFS
    public void bfs(Node start) {
        // 创建队列
        Queue<Node> queue = new LinkedList<>();
        // 把start节点放入队列，并标记
        queue.offer(start);
        marked[start.getNo()] = true;
        // BFS遍历
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            System.out.println("BFS current node : " + curNode.no + " value: " + curNode.value);
            // 以curNode为圆心画圆：找邻接节点
            for (Node adjNode : adjacencyList.get(curNode)) {
                // 防止重复遍历
                if (!marked[adjNode.getNo()]) {
                    // 该节点已经放入队列中
                    marked[adjNode.getNo()] = true;
                    queue.offer(adjNode);
                }
            }
        }
    }


    public static void main(String[] args) {
        // 构造图
        UndirectedGraph graph = new UndirectedGraph(8);

        // add vertex
        Node node0 = new Node(0, 1);
        Node node1 = new Node(1, 2);
        Node node2 = new Node(2, 3);
        Node node3 = new Node(3, 4);
        Node node4 = new Node(4, 5);
        Node node5 = new Node(5, 6);
        Node node6 = new Node(6, 7);
        Node node7 = new Node(7, 8);
        graph.addVertex(node0);
        graph.addVertex(node1);
        graph.addVertex(node2);
        graph.addVertex(node3);
        graph.addVertex(node4);
        graph.addVertex(node5);
        graph.addVertex(node6);
        graph.addVertex(node7);
        // add edge
        graph.addEdge(node0, node1);
        graph.addEdge(node0, node2);
        graph.addEdge(node1, node4);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node4);
        graph.addEdge(node5, node6);

        // print graph
        graph.printGraph();

        // print dfs
        System.out.println("Starting from node0");
        graph.dfsInComponent(node0);
        System.out.println("Starting from node1");
        graph.dfsInComponent(node1);
        System.out.println("DFS in Graph:");
        graph.dfsInGraph();
        System.out.println("component count: " + graph.getConnectComponentCount());

        System.out.println("==================================");

        // print bfs
        System.out.println("BFS: Starting from node0");
        graph.bfsInComponent(node0);
        System.out.println("BFS: Starting from node1");
        graph.bfsInComponent(node1);
        System.out.println("BFS in Graph:");
        graph.bfsInGraph();
        System.out.println("BFS component count: " + graph.getConnectComponentCount());
    }
}
