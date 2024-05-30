package easy.dynamic.programming;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

1 2 4 6 10
 */

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println(climbingStairs.climbStairs(5));
    }

    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return countAllCombinations(0, n, memo);
    }

    private int countAllCombinations(int curr, int n, int[] memo) {
        if (curr > n) return 0;

        if (curr == n) return 1;

        if (memo[curr] > 0) return memo[curr];

        memo[curr] = countAllCombinations(curr+1, n, memo) + countAllCombinations(curr+2, n, memo);
        return memo[curr];
    }
}
