package easy.binarysearch;

public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(4));
    }

    public int arrangeCoins(int n) {
        long start = 1;
        long end = n;

        while (end >= start) {
            long mid = (end + start) / 2;
            long sum = mid * (mid + 1) / 2;  // Use long to prevent overflow

            if (sum == n) {
                return (int)mid;
            } else if (sum > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int)end;
    }
}
