package org.github.fourth.leetcode.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressFBWarnings({"URF_UNREAD_FIELD", "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<Integer> preIntegerList() {
        List<Integer> result = new ArrayList<>();
        preIntegerListHelper(result, this);
        return result;
    }

    private void preIntegerListHelper(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        result.add(treeNode.val);
        preIntegerListHelper(result, treeNode.left);
        preIntegerListHelper(result, treeNode.right);
    }

    /**
     * 层序遍历
     * 根据节点i(i>=0)的左节点是2*i + 1, 2*i + 2
     */
    public static TreeNode build(List<Integer> list) {
        if (list == null) {
            return null;
        }
        return new TreeNode().buildTree(list, 0, list.size());
    }

    private TreeNode buildTree(List<Integer> list, int i, int n) {
        if (i >= n || list.get(i) == null) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(i));

        root.left = buildTree(list, 2 * i + 1, n);
        root.right = buildTree(list, 2 * i + 2, n);

        return root;
    }

    public static TreeNode build(Integer... list) {
        return build(Arrays.stream(list).toList());
    }
}
