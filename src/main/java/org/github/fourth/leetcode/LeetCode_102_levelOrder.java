package org.github.fourth.leetcode;

import org.github.fourth.struct.bst.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LeetCode_102_levelOrder {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
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
