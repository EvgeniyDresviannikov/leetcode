package binary.tree.general;

import java.util.*;

public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {
        TreeNode res = new BinaryTreeFromInorderAndPostorder().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println("left = " + res.left.val);
        System.out.println("right = " + res.right.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Queue<Integer> postorderQueue = new ArrayDeque<>();
        for (int i = postorder.length-1; i > -1; i--) {
            postorderQueue.add(postorder[i]);
        }

        return backtrack(0, inorder.length-1, postorderQueue, map);
    }

    private TreeNode backtrack(int left, int right, Queue<Integer> postorder, Map<Integer, Integer> map) {
        if (left > right) return null;

        int rootValue = postorder.poll();
        TreeNode root = new TreeNode(rootValue);

        int idx = map.get(rootValue);

        root.right = backtrack(idx+1, right, postorder, map);
        root.left = backtrack(left, idx-1, postorder, map);

        return root;
    }


}

