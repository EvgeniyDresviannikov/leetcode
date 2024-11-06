package medium.greedy;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{20,100,10,12,5,13}));
    }

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > mid) {
                return true;
            }

            if (n > min) {
                mid = Math.min(n, mid);
            }

            min = Math.min(min, n);
        }

        return false;
    }


}
