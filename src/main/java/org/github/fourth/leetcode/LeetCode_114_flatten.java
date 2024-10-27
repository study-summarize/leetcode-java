package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * - 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * - 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
@Top100
public class LeetCode_114_flatten {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                // 左子树为空时，直接进入右子树开始
                root = root.right;
            } else {
                // 找到左子树的最右节点，将原来的右子树放置该节点下

                // 找到左子树最右节点
                TreeNode leftRoot = root.left;
                while (leftRoot.right != null) {
                    leftRoot = leftRoot.right;
                }

                // 先将root右子树放到最右节点
                leftRoot.right = root.right;
                // 将左子树放到root的右子树下
                root.right = root.left;
                root.left = null;

                root = root.right;
            }
        }
    }
}
