package medium.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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

        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(node3));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {

            int size = queue.size();
            int i = 0;
            List<Integer> lst = new ArrayList<>();
            while (i < size) {
                TreeNode top = queue.poll();
                lst.add(top.val);
                if (top.left != null) {
                    queue.add(top.left);
                }

                if (top.right != null) {
                    queue.add(top.right);
                }
                i++;
            }

            result.add(lst);
        }

        return result;
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
