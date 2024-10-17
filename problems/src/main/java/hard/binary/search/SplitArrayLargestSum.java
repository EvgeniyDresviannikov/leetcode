package hard.binary.search;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        System.out.println(new SplitArrayLargestSum().splitArray(new int[]{7,2,5,10,8}, 2));
    }

    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        int res = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(mid, k, nums)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return res;
    }

    private boolean canSplit(int threshold, int k, int[] nums) {
        int curSum = 0;
        int counter = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > threshold) {
                counter++;
                curSum = num;
            }
        }

        return counter+1 <= k;
    }
}
