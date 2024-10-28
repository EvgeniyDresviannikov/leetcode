package medium.binarytree;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;

        new FlattenBinaryTreeToLinkedList().flatten(node3);

    }

    public void flatten(TreeNode root) {

        dfs(root);

    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) return null;

        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);

        if (node.left != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail != null ? rightTail : (leftTail != null) ? leftTail : node;
    }


}
