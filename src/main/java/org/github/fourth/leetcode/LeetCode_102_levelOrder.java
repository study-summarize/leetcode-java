package org.github.fourth.leetcode;


import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
@Top100
public class LeetCode_102_levelOrder {

    /**
     * BFS
     */
    public List<List<Integer>> levelOrder01(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 1. 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 2. 根据队列，bfs扩散遍历
        while (!queue.isEmpty()) {
            int breadth = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < breadth; i++) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }


    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> levelOrderExample(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // step1: 构建队列
        Queue<TreeNode> queue = new LinkedList<>();

        // step2: 把根节点加入队列
        queue.add(root);

        // step3：层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            // for循环层级遍历：需要分层必须要有for循环
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
