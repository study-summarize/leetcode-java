package org.github.fourth.leetcode;

import org.github.fourth.struct.bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode_257_BinaryTreePaths {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // 解集
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 单一解集
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(root.val));

        helper(result, list, root);

        return result;
    }

    public void helper(List<String> result, List<String> sb, TreeNode root) {
        // 递归何时退出：到达叶子节点
        if (root == null || (root.left == null && root.right == null)) {
            result.add(String.join("->", sb));
            return;
        }

        if (root.left != null) {
            sb.add(String.valueOf(root.left.val));
            helper(result, sb, root.left);
            // 回朔
            sb.remove(sb.size() - 1);
        }

        if (root.right != null) {
            sb.add(String.valueOf(root.right.val));
            helper(result, sb, root.right);
            sb.remove(sb.size() - 1);
        }
    }
}
