package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LeetCode_236_lowestCommonAncestor {
    /**
     * 分治法
     * 时间复杂度：
     * 空间复杂度：
     */
    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 防止一开始就找到p或者q
        if(root == p || root == q) {
            return root;
        }

        // Divide
        TreeNode leftExist = lowestCommonAncestor01(root.left, p, q);
        TreeNode rightExits = lowestCommonAncestor01(root.right, p, q);

        // Combine
        if (leftExist != null && rightExits != null) {
            // 这种只可能是p、q、root是同一个节点
            return root;
        } else if (leftExist == null || rightExits == null) {
            return leftExist == null ? rightExits : leftExist;
        } else {
            // 为什么这里返回root节点？
            return root;
        }
    }

    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }
}
