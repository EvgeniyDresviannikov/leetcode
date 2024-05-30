package easy.binarysearch;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();

        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        System.out.println(countCompleteTreeNodes.countNodes(root));

    }
    public int countNodes(TreeNode node) {
        if (node == null) return 0;
        if (node.right != null) {
            return 1 + countNodes(node.right) + countNodes(node.left);
        } else if (node.left != null) {
            return 1 + countNodes(node.left);
        } else {
            return 1;
        }
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
