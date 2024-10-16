package hard.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumPerformanceOfTeam {


    public static void main(String[] args) {
        System.out.println(new MaximumPerformanceOfTeam().maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 2));
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        Arrays.sort(engineers, (o1, o2) -> o2[1] - o1[1]);

        long totalSpeed = 0;
        long res = 0;

        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < engineers.length; i++) {
            int spd = engineers[i][0];
            int eff = engineers[i][1];

            if (minHeap.size() == k) {
                totalSpeed -= minHeap.poll();
            }
            minHeap.add(spd);
            totalSpeed += spd;

            res = Math.max(res, (long) eff * totalSpeed);
        }

        return (int) (res % ((int) Math.pow(10, 9) + 7));
    }


}
