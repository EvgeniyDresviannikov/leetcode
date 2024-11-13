package medium.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualLimit {

    public static void main(String[] args) {
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualLimit().longestSubarray(new int[]{2,2,2,4,4,2,5,5,5,5,5,2}, 2));
    }

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>(); // mono decreasing
        Deque<Integer> minQueue = new ArrayDeque<>(); // mono increasing

        int l = 0;
        int res = 0;

        for (int r = 0; r < nums.length; r++) {
            while (!minQueue.isEmpty() &&  nums[r] < minQueue.peekLast()) {
                minQueue.pollLast();
            }
            while (!maxQueue.isEmpty() && nums[r] > maxQueue.peekLast()) {
                maxQueue.pollLast();
            }

            minQueue.add(nums[r]);
            maxQueue.add(nums[r]);


            while (Math.abs(maxQueue.peekFirst() - minQueue.peekFirst()) > limit) {
                int leftVal = nums[l];
                if (leftVal == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }
                if (leftVal == minQueue.peekFirst()) {
                    minQueue.pollFirst();
                }
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;

    }
}
