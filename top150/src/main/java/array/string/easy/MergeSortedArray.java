package array.string.easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        new MergeSortedArray().merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num1Copy = Arrays.copyOf(nums1, m);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (num1Copy[i] < nums2[j]) {
                nums1[k] = num1Copy[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            nums1[k] = num1Copy[i];
            i++;
            k++;
        }

        while (j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }

    }

}
