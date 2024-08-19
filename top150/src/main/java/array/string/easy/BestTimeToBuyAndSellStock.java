package array.string.easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxDiff = 0;

        while (right < prices.length) {
            int profit = prices[right] - prices[left];

            if (profit > 0) {
                maxDiff = Math.max(maxDiff, profit);
            } else {
                left = right;
            }
            right++;
        }


        return maxDiff;
    }
}
