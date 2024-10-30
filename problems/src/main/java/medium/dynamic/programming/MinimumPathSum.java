package medium.dynamic.programming;

public class MinimumPathSum {

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        int sum = 0;
        for (int i = n-1; i > -1 ; i--) {
            sum += grid[m-1][i];
            dp[m-1][i] = sum;
        }

        sum = 0;
        for (int i = m - 1; i > -1 ; i--) {
            sum += grid[i][n-1];
            dp[i][n-1] = sum;
        }

        for (int i = m-2; i > -1 ; i--) {
            for (int j = n-2; j > -1 ; j--) {
                int val = grid[i][j];
                dp[i][j] = val + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }

        return dp[0][0];
    }
}
