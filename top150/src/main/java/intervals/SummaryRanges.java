package intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0,1,2,4,5,7, 8}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i-1]+1) {
                if (start < i-1) {
                    res.add(nums[start] + "->" + nums[i-1]);
                } else {
                    res.add(""+ nums[start]);
                }
                start = i;
            }
        }
        return res;
    }
}
