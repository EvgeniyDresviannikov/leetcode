package array.string.medium;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{1,3,1}));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        if (citations[citations.length-1] == 0) return 0;

        int hindex = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            hindex++;

            if (hindex > citations[i]) {
                return hindex-1;
            } else if (hindex == citations[i]) {
                return hindex;
            }
        }

        return  hindex;
    }
}
