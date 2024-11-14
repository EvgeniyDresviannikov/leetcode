package medium.dfs;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        TreeNode node0 = new TreeNode(0);
        node4.left = node9;
        node4.right = node0;
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node9.left = node5;
        node9.right = node1;

        System.out.println(new SumRootToLeafNumbers().sumNumbers(node4));
    }

    public int sumNumbers(TreeNode root) {
        return dfs(0, root);
    }

    private int dfs(int num, TreeNode node) {
        num = num * 10 + node.val;

        if (node.left == null && node.right == null) return num;


        if (node.right == null) {
            return dfs(num, node.left);
        }

        if (node.left == null) {
            return dfs(num, node.right);
        }

        return dfs(num, node.left) + dfs(num, node.right);
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