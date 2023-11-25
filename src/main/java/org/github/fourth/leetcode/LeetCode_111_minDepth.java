package org.github.fourth.leetcode;


import org.github.fourth.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class LeetCode_111_minDepth {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        // step 1:创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // step 2:将根节点加入队列
        queue.offer(root);
        // step 3:层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 如果是叶子节点就返回
                if (node.left == null && node.right == null) {
                    return result;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

}
