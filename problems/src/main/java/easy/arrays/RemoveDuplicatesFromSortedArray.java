package easy.arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] arr = new int[]{1, 2, 2, 3, 4, 4, 5};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int uniqueSize = 1;
        int lastUniqueElementIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            } else {
                uniqueSize++;
                lastUniqueElementIndex++;
                nums[lastUniqueElementIndex] = nums[i];
            }
        }
        return uniqueSize;
    }
}
