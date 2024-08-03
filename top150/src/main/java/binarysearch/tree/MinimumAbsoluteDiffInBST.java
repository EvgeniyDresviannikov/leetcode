package binarysearch.tree;


public class MinimumAbsoluteDiffInBST {

    TreeNode prev;
    int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        node4.left = node2;
        node4.right = node6;
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;

        System.out.println(new MinimumAbsoluteDiffInBST().getMinimumDifference(node4));

    }

    public int getMinimumDifference(TreeNode root) {
        dfs(root);

        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.left);

        if (prev != null) {
            res = Math.min(res, node.val - prev.val);
        }

        prev = node;

        dfs(node.right);


    }




}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
