package divide.and.conquer;

import java.util.Arrays;

public class ConstructQuadTree {

    public static void main(String[] args) {
        Node res = new ConstructQuadTree().construct(new int[][]{
                {0, 1},
                {1, 0}
        }
);

        System.out.println(res.topRight.isLeaf);
        System.out.println(res.bottomLeft.isLeaf);
    }

    public Node construct(int[][] grid) {
        return backtrack(grid.length, 0, 0, grid);
    }

    private Node backtrack(int n, int r, int c, int[][] grid) {
        if (isLeaf(n, r, c, grid)) return new Node(grid[r][c] == 1, true);

        Node node = new Node(true, false);
        n = n / 2;

        node.topLeft = backtrack(n, r, c, grid);
        node.topRight = backtrack(n, r, c + n, grid);
        node.bottomLeft = backtrack(n, r+n, c, grid);
        node.bottomRight = backtrack(n, r+n, c+n, grid);

        return node;
    }

    private boolean isLeaf(int n, int r, int c, int[][] grid) {
        boolean isOne = false;
        boolean isZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[r+i][c+j] == 0) {
                    isZero = true;
                } else {
                    isOne = true;
                }

                if (isZero && isOne) return false;

            }
        }

        return true;

    }
}



class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}