package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历：左子树 ----> 根节点 ----> 右子树
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
@Top100
public class LeetCode_094_inorderTraversal {
    /**
     * 递归法：
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> inorderTraversal01(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderTraversal01Helper(result, root);
        return result;
    }

    private void inorderTraversal01Helper(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal01Helper(result, root.left);
        result.add(root.val);
        inorderTraversal01Helper(result, root.right);
    }

    /**
     * 非递归：用栈模拟递归
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> inorderTraversal02(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            // 先找到当前根节点的最左子树
            while (root != null) {
                // 先把根节点放进来，等左子树遍历完，就开始遍历这个
                stack.push(root);
                root = root.left;
            }
            // 此时已经到root跟节点的最左底端
            TreeNode currentNode = stack.pop();
            // currentNode其实就变成根节点了
            result.add(currentNode.val);
            // 开始右节点遍历
            root = currentNode.right;
        }
        return result;
    }
}
