package hard;

public class CountOfRangeSum {

    public static void main(String[] args) {
        System.out.println(new CountOfRangeSum().countRangeSum(new int[]{0,0}, 0, 0));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] >= lower && nums[0] <= upper ? 1 : 0;

        long[] sumArr = new long[nums.length+1];
        sumArr[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sumArr[i] = sumArr[i-1] + nums[i];
        }

        int counter = sumArr[0] >= lower && sumArr[0] <= upper ? 1 : 0;
        int left = 0;
        int right = 1;

        while (left < sumArr.length && right < sumArr.length) {
            if (sumArr[right] - sumArr[left] >= lower && sumArr[right] - sumArr[left] <= upper) {
                counter++;
                if (right != sumArr.length-1) {
                    right++;
                } else {
                    left++;
                    if (left == right) {
                        break;
                    }
                }
            } else {
                left++;
                if (left == right) {
                    right++;
                }
            }
        }

        return counter;

    }
}
