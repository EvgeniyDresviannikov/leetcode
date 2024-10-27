package medium.binarysearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{3,1}, 1));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            //left sorted part
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
