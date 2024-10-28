package medium.binarytree;

public class BinaryTreeMaximumPathSum {

    private int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(-10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;

        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(node3));
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);

        int max = node.val + Math.max(leftSum , rightSum);
        result = Math.max(result, node.val + leftSum + rightSum);

        return max;
    }
}
