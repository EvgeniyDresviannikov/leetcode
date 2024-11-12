package medium.divide.and.conquer;

import java.util.Arrays;

public class SortAnArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortAnArray().sortArray(new int[]{5,1,1,2,0,0})));
    }

    public int[] sortArray(int[] nums) {
        return helper(nums);
    }

    private int[] helper(int[] nums) {
        if (nums.length <= 1) return nums;

        int mid = nums.length / 2;
        int[] left = helper(Arrays.copyOfRange(nums, 0, mid));
        int[] right = helper(Arrays.copyOfRange(nums, mid, nums.length));

        int[] sorted = new int[left.length + right.length];
        int i = 0; int j = 0; int k = 0;
        while (k < sorted.length) {
            if (j >= right.length || (i < left.length && left[i] < right[j])) {
                sorted[k] = left[i];
                i++;
            } else {
                sorted[k] = right[j];
                j++;
            }
            k++;
        }
        return sorted;
    }
}
