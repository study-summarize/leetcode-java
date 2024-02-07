package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class LeetCode_106_buildTree {
    /**
     * 思路：
     * - 根据后序遍历确定根节点值
     * - 再到中序，确定左右子树的位置
     * 时间复杂度：
     * 空间复杂度：
     */
    public TreeNode buildTreeExample(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0
                || postorder == null || postorder.length == 0) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        // 防止越界
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        // 1. 根据后序序列得到根节点值
        TreeNode root = new TreeNode(postorder[pEnd]);

        // 2. 找到中序根节点的位置
        int iRootPos = findRootPos(inorder, root.val);
        /*
         * 2.a 遍历左子树
         * 中序左子树[iStart, iRootPos - 1]
         * 后序左子树[pStart, pStart + (iRootPos - 1 - iStart)]
         */
        root.left = helper(inorder, iStart, iRootPos - 1, postorder, pStart, pStart + iRootPos - 1 - iStart);
        /*
         * 2.b 遍历右子树
         * 中序右子树[iRootPos + 1, iEnd]
         * 后序右子树[pStart - iStart + iRootPos, pEnd - 1]
         */
        root.right = helper(inorder, iRootPos + 1, iEnd, postorder, pStart - iStart + iRootPos, pEnd - 1);
        return root;
    }

    private int findRootPos(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
