package hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostToCutStick {

    public static void main(String[] args) {
        System.out.println(new MinimumCostToCutStick().minCost(7, new int[]{1,3,4,5}));
    }

    public int minCost(int n, int[] cuts) {

        Map<Map.Entry<Integer, Integer>, Integer> dp = new HashMap<>();

        return dfs(0, n, cuts, dp);
    }

    private int dfs(int left, int right, int[] cuts, Map<Map.Entry<Integer, Integer>, Integer> dp) {
        if (right - left == 1) {
            dp.put(Map.entry(left, right), 0);
            return 0;
        }

        if (dp.containsKey(Map.entry(left, right))) return dp.get(Map.entry(left, right));

        int res = Integer.MAX_VALUE;

        for (int c : cuts) {
            if (c > left && c < right) {
                res = Math.min(res,
                        (right - left) + dfs(left, c, cuts, dp) + dfs(c, right, cuts, dp)
                );
            }
        }

        dp.put(Map.entry(left, right), res == Integer.MAX_VALUE ? 0 : res);
        return res == Integer.MAX_VALUE ? 0 : res;


    }
}
