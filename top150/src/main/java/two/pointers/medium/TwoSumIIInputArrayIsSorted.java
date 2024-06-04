package two.pointers.medium;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumIIInputArrayIsSorted().twoSum(new int[]{2,7,11,15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{left+1, right+1};
    }


}
