package array.string.hard;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0,3,0,0,1,0}));
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }

        return res;
    }
}
