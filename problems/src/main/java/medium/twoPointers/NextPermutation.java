package medium.twoPointers;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,3,3};
        new NextPermutation().nextPermutation(arr);

        Arrays.stream(arr).forEach(System.out::println);


    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;

        int l = nums.length - 2;


        while (nums[l] >= nums[l+1] && l > 0) {
            l--;
        }


        if (l > 0 || nums[0] < nums[1]) {
            int indexToSwap = l+1;
            int valueToSwap = nums[l+1];
            for (int i = l+2; i < nums.length; i++) {
                if (nums[i] > nums[l] && nums[i] <= valueToSwap) {
                    indexToSwap = i;
                    valueToSwap = nums[i];
                }
            }

            int temp = nums[l];
            nums[l] = nums[indexToSwap];
            nums[indexToSwap] = temp;

            l++;
        }

        int r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
