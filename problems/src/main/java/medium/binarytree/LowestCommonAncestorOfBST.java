package medium.binarytree;

public class LowestCommonAncestorOfBST {

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);

        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node6.left = node2;
        node6.right = node8;

        node2.left = node0;
        node2.right = node4;

        node4.left = node3;
        node4.right = node5;

        node8.left = node7;
        node8.right = node9;

        System.out.println(new LowestCommonAncestorOfBST().lowestCommonAncestor(node6, node4, node2).val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node.val > p.val && node.val < q.val) return node;
        if (node == p || node == q) return node;

        if (node.val > p.val && node.val > q.val) {
            return dfs(node.left, p, q);
        } else {
            return dfs(node.right, p, q);
        }
    }
}
