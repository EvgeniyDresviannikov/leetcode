package medium.greedy;

public class PatchingArray {

    public static void main(String[] args) {
        System.out.println(new PatchingArray().minPatches(new int[]{1,3}, 6));
    }

    public int minPatches(int[] nums, int n) {
        int patches = 0;
        int i = 0;
        long right = 0;

        while (right < n) {
            if (i < nums.length && nums[i] <= right+1) {
                right += nums[i];
                i++;
            } else {
                patches++;
                right += (right+1);
            }
        }

        return patches;
    }
}
