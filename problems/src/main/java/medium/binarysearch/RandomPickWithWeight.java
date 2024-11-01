package medium.binarysearch;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    double[] weightLine;
    Random random;

    public static void main(String[] args) {
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[]{1, 3, 4});

        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());

    }

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        long sum = Arrays.stream(w).sum();
        weightLine = new double[w.length];

        double cumulativeWeight = 0;
        for (int i = 0; i < w.length; i++) {
            cumulativeWeight += (double)w[i] / sum;
            weightLine[i] = cumulativeWeight;
        }

        System.out.println(Arrays.toString(weightLine));


    }

    public int pickIndex() {
        int left = 0;
        int right = weightLine.length-1;

        double val = random.nextDouble();

        while (left < right) {
            int mid = (left + right) / 2;
            if (weightLine[mid] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
