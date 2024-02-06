package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历：左子树 ----> 右子树 ----> 根节点
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class LeetCode_145_postorderTraversal {
    /**
     * 递归法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> postorderTraversal01(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorderTraversal01Helper(result, root);
        return result;
    }

    private void postorderTraversal01Helper(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal01Helper(result, root.left);
        postorderTraversal01Helper(result, root.right);
        result.add(root.val);
    }

    /**
     * 非递归：利用俩个栈
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> postorderTraversal02(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return result;
    }

    /**
     * 非递归：一个栈 + 标识
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> postorderTraversal03(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return result;
    }

}
