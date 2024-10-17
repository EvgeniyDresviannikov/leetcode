package hard.heap;

import java.util.*;

public class MinimumIntervalToIncludeEachQuery {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MinimumIntervalToIncludeEachQuery().minInterval(new int[][]{
                {1, 4}, {2, 4}, {3, 6}, {4, 4}
        }, new int[]{2,3,4,5})));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int numQuery = queries.length;

        //append index in query
        int[][] queriesWithIndex = new int[numQuery][2];
        for(int i = 0; i < numQuery; i++){
            queriesWithIndex[i] = new int[]{queries[i], i};
        }
 
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[0]));

        //sort interval in increasing order of size
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> (a[1] - a[0])));

        int[] result = new int[numQuery];

        int j = 0;
        for(int i = 0; i < queriesWithIndex.length; i++){
            int queryVal = queriesWithIndex[i][0];
            int queryIndex = queriesWithIndex[i][1];

            //add all the interval which start is less or equal than current query value
            while(j < intervals.length && intervals[j][0] <= queryVal){
                minHeap.add(intervals[j]);
                j++;
            }

            //remove all the smallest size interval which end val is less than current query value
            while(!minHeap.isEmpty() && minHeap.peek()[1] < queryVal){
                minHeap.remove();
            }
            //now if heap is empty it means there is no interval which satisfy query val
            result[queryIndex] = minHeap.isEmpty() ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] + 1);
        }

        return result;
    }
}