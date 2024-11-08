

package medium.priorityqueue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumber2 {

    public static void main(String[] args) {
        System.out.println(new UglyNumber2().nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        Queue<Long> minHeap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        int[] factors = new int[]{2, 3, 5};

        int i = 0;
        minHeap.add(1L);
        Long pop = 1L;

        while (i < n) {
            pop = minHeap.poll();

            for (int factor : factors) {
                long num = factor * pop;
                if (!visited.contains(num)) {
                    minHeap.add(num);
                    visited.add(num);
                }
            }

            i++;
        }

        return pop.intValue();

    }
}
