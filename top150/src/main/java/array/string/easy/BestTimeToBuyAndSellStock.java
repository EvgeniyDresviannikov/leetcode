package array.string.easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int accumulator = 0;
        int maxDiff = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            accumulator = accumulator + diff;

            if (accumulator < 0) {
                accumulator = 0;
            }

            if (accumulator > maxDiff) {
                    maxDiff = accumulator;
            }
        }

        return maxDiff;
    }
}
