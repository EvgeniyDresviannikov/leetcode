package medium.divide.and.conquer;


public class MaximumBinaryTree {

    public static void main(String[] args) {
        System.out.println(new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}).left.right.val);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(0, nums.length, nums);
    }

    private TreeNode helper(int start, int end, int[] nums) {
        if (end - start == 0) return null;

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = helper(start, maxIdx, nums);
        node.right = helper(maxIdx + 1, end, nums);
        return node;
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