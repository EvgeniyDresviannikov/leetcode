package binarytree.bfs;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

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

        System.out.println(new AverageOfLevelsInBinaryTree().averageOfLevels(node4));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        int cnt = 0;
        long sum = 0;

        Queue<TreeNode> current = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();

        current.add(root);

        while (!current.isEmpty()) {
            TreeNode pop = current.poll();
            cnt++;
            sum += pop.val;

            if (pop.left != null) {
                next.add(pop.left);
            }

            if (pop.right != null) {
                next.add(pop.right);
            }

            if (current.isEmpty()) {
                res.add((double) sum / cnt);
                cnt = 0;
                sum = 0;

                while (!next.isEmpty()) {
                    current.add(next.poll());
                }
            }
        }

        return res;
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