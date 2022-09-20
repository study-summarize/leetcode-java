package bst;

public class BinarySearchTree {

    TreeNode root;

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
            if (node.getValue() == value) {
                return true;
            } else if (node.getValue() > value) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return false;
    }

    /**
     * 添加节点
     *
     * @param value
     * @return
     */
    public boolean add(int value) {
        if (root == null) {
            this.root = new TreeNode(value);
            return true;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.getValue() == value) {
                return false;
            } else if (node.getValue() > value) {
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

        if (root.getValue() > value) {
            // 要删除的节点只可能在左子树
            root.setLeft(deleteAndReturn(root.getLeft(), value));
        } else if(root.getValue() < value) {
            // 要删除的节点只可能在右子树
            root.setRight(deleteAndReturn(root.getRight(), value));
        } else {
            // 准备删除该节点
            if(root.getLeft() == null && root.getRight() == null) {
                // 1、直接删除该节点即可
                root = null;
            } else if(root.getLeft() == null) {
                // 2-a、要删除的节点无左子树
                root = root.getRight();
            } else if(root.getRight() == null) {
                // 2-b、要删除的节点无右子树
                root = root.getLeft();
            } else {
                // 3、节点左右子树都有节点
                TreeNode newRightNode = getMinNode(root.getRight());
                root.setValue(newRightNode.getValue());
                root.setRight(deleteAndReturn(root.getRight(), newRightNode.getValue()));
            }
        }
        return root;
    }

    public static TreeNode getMinNode(TreeNode root) {
        if(root == null) {
            return null;
        }
        while(root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        TreeNode node1 = new TreeNode(19);
        TreeNode node2 = new TreeNode(34);
        root.setLeft(node1);
        root.setRight(node2);

        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(22);
        TreeNode node5 = new TreeNode(31);
        TreeNode node6 = new TreeNode(42);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);

        TreeNode node7 = new TreeNode(20);
        TreeNode node8 = new TreeNode(28);
        TreeNode node9 = new TreeNode(36);
        TreeNode node10 = new TreeNode(47);
        node4.setLeft(node7);
        node4.setRight(node8);
        node6.setLeft(node9);
        node6.setRight(node10);

        BinarySearchTree bst = new BinarySearchTree(root);

        // find 22
        System.out.println("find 22: " + bst.find(22));
        System.out.println("find 45: " + bst.find(45));

        // add 45
        bst.add(45);
        System.out.println("find 45 after adding: " + bst.find(45));
        System.out.println("add 22: " + bst.add(22));
    }

}
