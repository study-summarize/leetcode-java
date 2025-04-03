package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_662_widthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                Integer curIndex = list.removeFirst();
                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(curIndex * 2);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(curIndex * 2 + 1);
                }
            }
            // 此时list存放的是最新一层所放的节点值
            if (list.size() >= 2) {
                result = Math.max(result, list.getLast() - list.getFirst() + 1);
            }
        }
        return result;
    }
}
