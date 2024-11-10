package hard.sliding.window;

import java.util.*;

// TODO fix bugs
public class SlidingWindowMedian {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }

    public  double[] medianSlidingWindow(int[] nums, int k) {

        if (k == 1) return Arrays.stream(nums).asDoubleStream().toArray();

        double[] result = new double[nums.length-k+1];

        PriorityQueue<Integer> smallestHalfMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largestHalfMinHeap = new PriorityQueue<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            smallestHalfMaxHeap.add(nums[i]);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < k/2; i++) {
            largestHalfMinHeap.add(smallestHalfMaxHeap.poll());
        }


        for (int i = k; i < nums.length; i++) {

            double currentMiddle = findMedian(k ,smallestHalfMaxHeap, largestHalfMinHeap);
            result[i-k] = currentMiddle;

            if (currentMiddle > nums[i]) {
                smallestHalfMaxHeap.add(nums[i]);
            } else {
                largestHalfMinHeap.add(nums[i]);
            }
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            int removed = nums[i-k];

            if (smallestHalfMaxHeap.peek() == removed) {
                smallestHalfMaxHeap.poll();
                if(freq.get(removed) == 1) {
                    freq.remove(removed);
                } else {
                    freq.put(removed, freq.get(removed)-1);
                }

            } else if (largestHalfMinHeap.peek() == removed){
                largestHalfMinHeap.poll();
                if(freq.get(removed) <= 1) {
                    freq.remove(removed);
                } else {
                    freq.put(removed, freq.get(removed)-1);
                }
            }

            rebalanceHeaps(smallestHalfMaxHeap, largestHalfMinHeap);

        }

        double currentMiddle = findMedian(k ,smallestHalfMaxHeap, largestHalfMinHeap);
        result[result.length-1] = currentMiddle;


        return result;
    }

    private  double findMedian(int k, PriorityQueue<Integer> smallestHalfMaxHeap, PriorityQueue<Integer> largestHalfMinHeap) {

        int maxFromSmallHeap = smallestHalfMaxHeap.peek();
        int minFromLargeHeap = largestHalfMinHeap.peek();

        if (k % 2 == 0) {
            return (double) ((long)maxFromSmallHeap + minFromLargeHeap) / 2;
        } else {
            return maxFromSmallHeap;
        }
    }

    private  void rebalanceHeaps(PriorityQueue<Integer> smallestHalfMaxHeap, PriorityQueue<Integer> largestHalfMinHeap) {
        // re-balance
        if (largestHalfMinHeap.size() > smallestHalfMaxHeap.size()) {
            int top = largestHalfMinHeap.poll();
            smallestHalfMaxHeap.add(top);
        } else if (smallestHalfMaxHeap.size() > largestHalfMinHeap.size() + 1) {
            int top = smallestHalfMaxHeap.poll();
            largestHalfMinHeap.add(top);
        }
    }
}