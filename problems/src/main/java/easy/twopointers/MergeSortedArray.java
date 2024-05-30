package easy.twopointers;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int i = 0;
        int j = 0;
        int counter = 0;

        while (counter < m && j < n) {
            if (nums1[i] > nums2[j]) {
                for(int k = 0; k < m-counter; k++) {
                    nums1[m+j-k] = nums1[m+j-k-1];
                }
                nums1[i] = nums2[j];
                j++;
            } else {
                counter++;
            }
            i++;
        }

        while (j < n) {
            nums1[i] = nums2[j];
            j++;
            i++;
        }

        System.out.println(Arrays.toString(nums1));

    }
}
