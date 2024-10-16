package hard.dfs;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

    int[][] MATRIX;
    int[][] DP;

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(new int[][]
                {
                        {9,9,4},
                        {6,6,8},
                        {2,1,1}
                }));
    }



    public int longestIncreasingPath(int[][] matrix) {
        MATRIX = matrix;
        DP = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[0].length; j++) {
                dfs(i, j, -1);
            }
        }

        int res = 0;
        for (int i = 0; i < DP.length; i++) {
            int[] arr = DP[i];
            int val = Arrays.stream(arr).max().getAsInt();
            res = Math.max(res, val);
        }

        return res;
    }

    private int dfs(int row, int col, int prevValue) {
        if (row < 0 || col < 0 || row > MATRIX.length-1 || col > MATRIX[0].length-1 || MATRIX[row][col] <= prevValue) {
            return 0;
        }

        if (DP[row][col] > 0) {
            return DP[row][col];
        }

        int res = 1;

        res = Math.max(res, 1 + dfs(row + 1, col, MATRIX[row][col]));
        res = Math.max(res, 1 + dfs(row - 1, col, MATRIX[row][col]));
        res = Math.max(res, 1 + dfs(row, col + 1, MATRIX[row][col]));
        res = Math.max(res, 1 + dfs(row, col - 1, MATRIX[row][col]));

        DP[row][col] = res;

        return res;
    }

}
