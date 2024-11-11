package medium.monotonic.stack;

import java.util.Arrays;

public class CarFleet {

    public static void main(String[] args) {

        System.out.println(new CarFleet().carFleet(10, new int[]{8,3,7,4,6,5}, new int[]{4,4,4,4,4,4}));

    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pairs, (o1, o2) -> o2[0] - o1[0]);

        int fleets = 1;
        int[] fleetLeader = pairs[0];

        for (int i = 1; i < pairs.length; i++) {
            int[] pair = pairs[i];
            double hoursLeader = getHoursToTarget(fleetLeader[0], fleetLeader[1], target);
            double hours = getHoursToTarget(pair[0], pair[1], target);

            if (hours > hoursLeader) {
                fleets++;
                fleetLeader = pairs[i];
            }
        }


        return fleets;
    }

    private double getHoursToTarget(int start, int speed, int target) {

        return ((double) target - start) / speed;
    }
}


