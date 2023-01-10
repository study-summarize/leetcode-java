
public class DepthFirstSearch {

    public static class TreeNode<T> {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int rootData) {
            this.val = rootData;
        }
    }

//    public void dfs(TreeNode node) {
//        doSomething(node);
//        dfs(node.left);
//        dfs(node.right);
//    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        divideAndConquer(root);
        return max;
    }

    public int divideAndConquer(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        // divide: 求pathSum
        int left = Math.max(divideAndConquer(root.left), 0);
        int right = Math.max(divideAndConquer(root.right), 0);

        // combine计算当前的pathSum
        // (1)root (2)left + root (3)right + root
        int pathSum = Math.max(left, right) + root.val;

        // 再重新计算max
        // left、right、root｜root+left｜root+right、left+root+right
        // 为什么老师说左右都被选择过了？
        // 为什么这里不需要考虑溢出？因为上面做了0处理
        int currentMax = Math.max(pathSum, (left + root.val + right));
        max = Math.max(max, currentMax);

        return pathSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode left = new TreeNode(500);
        root.left = left;
        int result = new DepthFirstSearch().maxPathSum(root);
        System.out.println("result = " + result);
    }
}
