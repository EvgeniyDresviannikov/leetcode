package kadalans.algorithm;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int globalMin = nums[0];

        int currentMax = 0;
        int currentMin = 0;

        int total = 0;


        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            currentMax += nums[i];
            globalMax = Math.max(globalMax, currentMax);
            if (currentMax < 0) {
                currentMax = 0;
            }

            if (nums[i] + currentMin < nums[i]) {
                currentMin = nums[i] + currentMin;
            } else {
                currentMin = nums[i];
            }

            globalMin = Math.min(globalMin, currentMin);

        }

        if (globalMax < 0) return globalMax;

        return Math.max(total - globalMin, globalMax);
    }
}
