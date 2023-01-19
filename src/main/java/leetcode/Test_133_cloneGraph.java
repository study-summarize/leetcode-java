package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jwang55
 */
public class Test_133_cloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // key是原图节点，value是新图节点
        Map<Node, Node> map = new HashMap<>();

        return dfs(map, node);
    }

    // 对 startNode 进行克隆
    private Node dfs(Map<Node, Node> map, Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, node);
        // 求 newNode 的连接表
        for (Node neighbor : node.neighbors) {
            Node newNeighbor = dfs(map, neighbor);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
