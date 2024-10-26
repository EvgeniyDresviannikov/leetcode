package medium.binarytree;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(8);
        TreeNode node3 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);

        node5.left = node1;
        node5.right = node4;

        node4.left = node3;
        node4.right = node6;

        System.out.println(new ValidateBinarySearchTree().isValidBST(node5));
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long leftBoundary, long rightBoundary) {
        if (node == null) return true;

        if (node.val <= leftBoundary || node.val >= rightBoundary) {
            return false;
        }

        return dfs(node.left, leftBoundary, node.val)
                && dfs(node.right, node.val, rightBoundary);
    }

}
