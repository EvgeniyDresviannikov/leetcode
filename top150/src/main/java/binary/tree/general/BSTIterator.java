package binary.tree.general;

import java.util.Stack;

public class BSTIterator {

    Stack<Integer> stack;

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        node7.left = node3;
        node7.right = node15;

        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node15.left = node9;
        node15.right = node20;

        BSTIterator bstIterator = new BSTIterator(node7);
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());


    }

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs(root);
    }

    public int next() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }

        return -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            stack.push(node.val);
            return;
        }

        dfs(node.right);
        stack.push(node.val);
        dfs(node.left);


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