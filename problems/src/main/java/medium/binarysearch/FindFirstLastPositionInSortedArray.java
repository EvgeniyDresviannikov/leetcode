package medium.binarysearch;

import java.util.Arrays;

public class FindFirstLastPositionInSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstLastPositionInSortedArray().searchRange(new int[]{1,2,5,5,5,5,5,5,5,5,20}, 5)));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        int low = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
                if (nums[mid] == target) low = mid;
            } else {
                l = mid + 1;
            }
        }

        if (low == -1) return new int[] {-1, -1};

        int high = low;
        l = low;
        r = nums.length-1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
                if (nums[mid] == target) high = mid;
            } else {
                r = mid - 1;
            }
        }

        return new int[]{low, high};

    }
}
