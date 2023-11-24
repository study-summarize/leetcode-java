package org.github.fourth.leetcode;

import org.github.fourth.struct.bst.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class LeetCode_103_zigzagLevelOrder {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 1、构建队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 2、根节点进入队列
        queue.offer(root);

        // 3、层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 != 0) {
                List<Integer> list = result.get(i);
                Collections.reverse(list);
            }
        }
        return result;
    }

}
