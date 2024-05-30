package easy.binarysearch;

import java.util.PriorityQueue;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[] {0,1}));
    }
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length+1];
        for (int i = 0; i < length; i++) {
            arr[nums[i]] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) return i;
        }
        return -1;
    }
}


