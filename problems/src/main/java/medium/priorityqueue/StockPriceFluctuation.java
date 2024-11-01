package medium.priorityqueue;

import java.util.*;

public class StockPriceFluctuation {

    int latestTimestamp;
    Map<Integer, Integer> prices;
    TreeMap<Integer, Integer> map;

    public static void main(String[] args) {
        StockPriceFluctuation stockPrice = new StockPriceFluctuation();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.
    }

    public StockPriceFluctuation() {
        latestTimestamp = 0;
        prices = new HashMap<>();
        map = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (prices.containsKey(timestamp)) {
            int oldPrice = prices.get(timestamp);

            // change old price counter
            int cnt = map.get(oldPrice);
            if (cnt == 1) {
                map.remove(oldPrice);
            } else {
                map.put(oldPrice, cnt-1);
            }

        }

        // change new price counter
        int cnt = map.getOrDefault(price, 0);
        map.put(price, cnt+1);
        prices.put(timestamp, price);


        if (latestTimestamp < timestamp) {
            latestTimestamp = timestamp;
        }

    }

    public int current() {
        return prices.isEmpty() ? -1 : prices.get(latestTimestamp);
    }

    public int maximum() {
        return map.isEmpty() ? -1 : map.lastKey();
    }

    public int minimum() {
        return map.isEmpty() ? -1 : map.firstKey();
    }
}
