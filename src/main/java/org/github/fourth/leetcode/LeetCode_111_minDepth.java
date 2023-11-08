package org.github.fourth.leetcode;

import org.github.fourth.struct.bst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_111_minDepth {

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
