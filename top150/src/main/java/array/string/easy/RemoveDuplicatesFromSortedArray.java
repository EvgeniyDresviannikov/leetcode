package array.string.easy;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{0}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;

        int index = 1;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
