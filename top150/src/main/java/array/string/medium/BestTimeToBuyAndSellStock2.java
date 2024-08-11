package array.string.medium;

public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }

        return profit;
    }
}
