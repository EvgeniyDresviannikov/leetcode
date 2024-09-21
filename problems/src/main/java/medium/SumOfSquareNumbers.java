package medium;

public class SumOfSquareNumbers {

    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(2147483600));
    }

    public boolean judgeSquareSum(int c) {

        long left = 0;
        long right = (long)Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right*right;
            if (sum == (long)c) return true;

            if (sum > (long)c) {
                right--;
            } else {
                left++;
            }
        }

        return false;

    }
}
