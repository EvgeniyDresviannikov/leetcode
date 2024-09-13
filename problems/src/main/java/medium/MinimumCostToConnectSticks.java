package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToConnectSticks {

    public static void main(String[] args) {
        System.out.println(new MinimumCostToConnectSticks().connectSticks(new int[]{2, 4, 3, 7}));
    }

    public int connectSticks(int[] sticks) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (int stick : sticks) {
            minHeap.add(stick);
        }

        int cost = 0;

        while (minHeap.size() > 1) {
            int stick1 = minHeap.poll();
            int stick2 = minHeap.poll();
            int newStick = stick1 + stick2;
            cost += newStick;
            minHeap.add(newStick);
        }

        return cost;
    }
}
