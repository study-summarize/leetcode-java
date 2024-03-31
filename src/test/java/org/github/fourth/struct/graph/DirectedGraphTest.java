package org.github.fourth.struct.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


@DisplayName("有向图-归并排序")
class DirectedGraphTest {

    @Test
    public void testExample() {
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

        List<DirectedGraphNode> result = graph.topologicalSortExample();
        result.forEach(node -> {
            System.out.println("Thr cue node no: " + node.getNo());
        });
    }

}