package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历：根节点 ----> 左子树 ----> 右子树
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LeetCode_144_preorderTraversal {
    /**
     * 非递归法：用栈模拟递归
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> preorderTraversal01(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        // 先放右节点，再放左节点
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            result.add(currentNode.val);
        }
        return result;
    }

    /**
     * 非递归法：找出最左子树
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> preorderTraversal02(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        // 模拟递归，一直找到最左字数
        while (!stack.isEmpty() || root != null) {
            // 找出最左子树
            while (root != null) {
                result.add(root.val);
                // 右子树放在栈里
                if (root.right != null) {
                    stack.push(root.right);
                }
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return result;
    }

    /**
     * 递归法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<Integer> preorderTraversal03(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        preorderTraversal03Helper(result, root);
        return result;
    }

    private void preorderTraversal03Helper(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversal03Helper(result, root.left);
        preorderTraversal03Helper(result, root.right);
    }
}
