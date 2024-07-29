package intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrows {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfArrows().findMinArrowShots(new int[][]{ {1,2}, {2,3}, {3,4}, {4,5} }));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(item -> item[0]));

        int counter = 0;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = Math.min(points[i][1], end);
            } else {
                end = points[i][1];
                counter++;
            }
        }

        return counter+1;
    }
}
