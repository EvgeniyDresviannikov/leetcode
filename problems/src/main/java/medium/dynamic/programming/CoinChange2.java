package medium.dynamic.programming;

import java.util.*;

public class CoinChange2 {


    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(5, new int[]{1,2,5}));
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return backtrack(0, 0, coins, amount, dp);
    }

    private int backtrack(int cur, int idx, int[] coins, int amount, int[][] dp) {
        if (cur == amount) return 1;
        if (cur > amount) return 0;
        if (idx == coins.length) return 0;
        if (dp[cur][idx] != -1) {
            return dp[cur][idx];
        }

        int res = backtrack(cur + coins[idx], idx, coins, amount, dp) + backtrack(cur, idx+1, coins, amount, dp);

        dp[cur][idx] = res;

        return res;
    }
}
