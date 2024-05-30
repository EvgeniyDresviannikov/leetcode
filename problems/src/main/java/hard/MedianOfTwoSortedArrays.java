package hard;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3, 4};

        System.out.println(5/2);

        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] resultArray = new int[nums1.length + nums2.length];
        int counter = 0;
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                resultArray[counter] = nums2[j];
                j++;
            } else {
                resultArray[counter] = nums1[i];
                i++;
            }
            counter++;
        }

        while (i < nums1.length) {
            resultArray[counter] = nums1[i];
            i++;
            counter++;
        }

        while (j < nums2.length) {
            resultArray[counter] = nums2[j];
            j++;
            counter++;
        }

        if (resultArray.length % 2 == 0) {
            return ((double) resultArray[resultArray.length/2 - 1] + resultArray[resultArray.length/2])/2;
        } else {
            return resultArray[(resultArray.length-1)/2];
        }
    }
}

