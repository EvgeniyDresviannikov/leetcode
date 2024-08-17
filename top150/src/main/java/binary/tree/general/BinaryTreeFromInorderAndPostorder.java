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

        return backtrack(inorder, postorderQueue, map);
    }

    private TreeNode backtrack(int[] inorder, Queue<Integer> postorder, Map<Integer, Integer> map) {
        if (inorder.length == 0) return null;

        int rootValue = postorder.poll();
        TreeNode root = new TreeNode(rootValue);

        int idx = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                idx = i;
                break;
            }
        }


        if (idx+1 < inorder.length) {
            root.right = backtrack(Arrays.copyOfRange(inorder, idx+1, inorder.length),  postorder, map);
        }

        if (idx > 0) {
            root.left = backtrack(Arrays.copyOfRange(inorder, 0, idx), postorder, map);
        }


        return root;
    }


}

