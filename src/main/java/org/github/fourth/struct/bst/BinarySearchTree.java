package org.github.fourth.struct.bst;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class BinarySearchTree {

    TreeNode root;

    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public BinarySearchTree(int value) {
        this.root = new TreeNode(value);
    }


    /**
     * judge target value is or not exist root
     *
     * @param value
     * @return
     */
    public boolean find(int value) {
        TreeNode node = root;
        while (node != null) {
            if (node.getVal() == value) {
                return true;
            } else if (node.getVal() > value) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return false;
    }

    /**
     * 添加节点
     * note：二叉搜索树的插入，不会涉及到二叉搜索树的重新变化
     */
    public boolean add(int value) {
        if (root == null) {
            this.root = new TreeNode(value);
            return true;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.getVal() == value) {
                // 节点已经存在，无法插入
                return false;
            } else if (node.getVal() > value) {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode(value));
                    return true;
                }
                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode(value));
                    return true;
                }
                node = node.getRight();
            }
        }
        return false;
    }

    public boolean delete(int value) {
        if (root == null) {
            return false;
        }
        if (deleteAndReturn(root, value) != null) {
            return true;
        }
        return false;
    }

    private static TreeNode deleteAndReturn(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.getVal() > value) {
            // 要删除的节点只可能在左子树
            root.setLeft(deleteAndReturn(root.getLeft(), value));
        } else if (root.getVal() < value) {
            // 要删除的节点只可能在右子树
            root.setRight(deleteAndReturn(root.getRight(), value));
        } else {
            // 准备删除该节点
            if (root.getLeft() == null && root.getRight() == null) {
                // 1、直接删除该节点即可
                root = null;
            } else if (root.getLeft() == null) {
                // 2-a、要删除的节点无左子树
                root = root.getRight();
            } else if (root.getRight() == null) {
                // 2-b、要删除的节点无右子树
                root = root.getLeft();
            } else {
                // 3、节点左右子树都有节点
                TreeNode newRightNode = getMinNode(root.getRight());
                root.setVal(newRightNode.getVal());
                root.setRight(deleteAndReturn(root.getRight(), newRightNode.getVal()));
            }
        }
        return root;
    }

    public static TreeNode getMinNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

}
