package array.string.medium;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1,2,3,4,5,6,7}, 5);
    }


    public void rotate(int[] nums, int k) {

        int mod = k % nums.length;

        if (mod == 0) return;

        // reverse
        int l = 0;
        int r = nums.length-1;
        int temp = 0;

        while (l < r) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        l = 0;
        r = mod-1;
        while (l < r) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        l = mod;
        r = nums.length-1;
        while (l < r) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

    }
}
