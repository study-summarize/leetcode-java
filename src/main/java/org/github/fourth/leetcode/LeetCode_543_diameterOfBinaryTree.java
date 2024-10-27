package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
@Top100
public class LeetCode_543_diameterOfBinaryTree {
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = 1;
        deepSize(root);
        return result - 1;
    }

    public int deepSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deepSize(root.left);
        int right = deepSize(root.right);
        result = Math.max(result, left + right + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(left, right) + 1;
    }
}
