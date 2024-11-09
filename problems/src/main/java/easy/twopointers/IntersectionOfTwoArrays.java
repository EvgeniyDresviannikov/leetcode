package easy.twopointers;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        List<Integer> result = new ArrayList<>();
        for(int t : nums1) count[t]++;
        for(int t : nums2){
            if (count[t] > 0) {
                result.add(t);count[t]=0;
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
