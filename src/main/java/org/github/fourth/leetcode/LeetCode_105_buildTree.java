package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
@Top100
public class LeetCode_105_buildTree {
    /**
     * 思路：
     * - 前序找到root节点
     * - 根据root节点，在中序找到root的左右子树
     * - 在根据前序节点，知道左子树区间、右子树区间的root
     * 时间复杂度：
     * 空间复杂度：
     */
    public TreeNode buildTreeExample(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * @param preorder 二叉树的前序序列
     * @param pStart   此次递归的有效起点
     * @param pEnd     此次递归的有效终点
     * @param inorder  二叉树的中序序列
     * @param iStart   此次递归的有效起点
     * @param iEnd     此次递归的有效终点
     */
    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // 如果越界，表示已经结束
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        // 1.根据前序知道root节点
        TreeNode root = new TreeNode(preorder[pStart]);

        // 2.先找到在中序节点的跟节点位置
        int iRootPos = findRootPos(inorder, root.val);
        /*
         * 2.a 找到此时节点的左子树
         * 前序左子树[pStart + 1, pStart + 1 + (iRootPos - iStart -1)]
         * 中序左子树[iStart, iRootPos - 1]
         */
        root.left = helper(preorder, pStart + 1, pStart + iRootPos - iStart, inorder, iStart, iRootPos - 1);
        /*
         * 2.b 找出此时节点的右子树
         * 前序右子树：[pStart + iRootPos - iStart + 1, pEnd]
         * 中序右子树：[iRootPos + 1, iEnd]
         */
        root.right = helper(preorder, pStart + iRootPos - iStart + 1, pEnd, inorder, iRootPos + 1, iEnd);
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
