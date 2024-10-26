package easy.arrays;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{0,1}));
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1 || nums[i] == nums.length) continue;

            int curIdx = nums[i];

            while (curIdx != -1 && curIdx != nums.length) {

                int nextIdx = nums[curIdx];

                nums[curIdx] = -1;

                if (nextIdx == -1 || nextIdx == nums.length) break;

                curIdx = nextIdx;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) return i;
        }

        return nums.length;
    }
}
