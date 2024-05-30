package easy.arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,7}, 7));

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int currIndex = 0;
        while (left <= right) {
            currIndex = left + (right - left) / 2;

            if (nums[currIndex] == target) return currIndex;

            if (target < nums[currIndex]) {
                right = currIndex - 1;
            } else {
                left = currIndex + 1;
            }
        }

        return left;

    }
}
