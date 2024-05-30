package easy.arrays;


public class ConvertSortedArrToBiTree {

    public static void main(String[] args) {
        ConvertSortedArrToBiTree convertSortedArrToBiTree = new ConvertSortedArrToBiTree();

        TreeNode treeNode = convertSortedArrToBiTree.sortedArrayToBST(new int[]{-10,-3,0,5,9});

        convertSortedArrToBiTree.printTree(treeNode);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) return new TreeNode(nums[0]);

        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] numbers, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        if ((left + right) % 2 == 1) {
            mid++;
        }

        TreeNode root = new TreeNode(numbers[mid]);
        root.left = helper(numbers, left, mid-1);
        root.right = helper(numbers, mid+1, right);
        return root;

    }

    public void printTree(TreeNode node) {
        if (node.left != null) {
            printTree(node.left);
        }

        if (node.right != null) {
            printTree(node.right);
        }

        System.out.println(node.val);
    }
}
