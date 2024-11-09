package medium.twoPointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = new int[]{0, 1, 2, 1, 0, 0, 1, 2, 0, 1};

        new SortColors().sortColors(colors);

        System.out.println(Arrays.toString(colors));
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int i = 0;
        int right = nums.length-1;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(left, i, nums);
                left++;
            } else if (nums[i] == 2) {
                swap(i, right, nums);
                right--;
                i--;
            }
            i++;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
