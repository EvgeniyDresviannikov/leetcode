package easy.arrays;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = new int[] {3,2,2,3};
        System.out.println(removeElement.removeElement(nums, 3));
    }

    public int removeElement(int[] nums, int val) {
        int size = 0;
        int lastElementIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                size++;
                nums[lastElementIndex] = nums[i];
                lastElementIndex++;
            }
        }
        return size;
    }
}
