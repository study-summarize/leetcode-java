package org.github.fourth.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jwang55
 */
public class LeetCode_429_levelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 1、构建队列
        Queue<Node> queue = new LinkedList<>();

        // 2、头结点加入队列
        queue.offer(root);

        // 3、层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                levelList.add(node.val);
                for (Node childNode : node.children) {
                    queue.offer(childNode);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
