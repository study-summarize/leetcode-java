package org.github.fourth.leetcode;


import org.github.fourth.leetcode.common.TreeNode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */
public class LeetCode_429_levelOrder {

    /**
     * BFS
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> levelOrder01(TreeNode2 root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 1、创建队列，放入根结点
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.add(root);

        // 2、层序遍历
        while (!queue.isEmpty()) {
            int breadthSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < breadthSize; i++) {
                TreeNode2 node = queue.poll();
                list.add(node.val);
                for (TreeNode2 childNode : node.children) {
                    queue.add(childNode);
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
    public List<List<Integer>> levelOrderExample(TreeNode2 root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 1、构建队列
        Queue<TreeNode2> queue = new LinkedList<>();

        // 2、头结点加入队列
        queue.offer(root);

        // 3、层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode2 node = queue.poll();
                levelList.add(node.val);
                for (TreeNode2 childNode : node.children) {
                    queue.offer(childNode);
                }
            }
            result.add(levelList);
        }
        return result;
    }
}
