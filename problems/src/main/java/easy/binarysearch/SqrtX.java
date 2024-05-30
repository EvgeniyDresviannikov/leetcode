package easy.binarysearch;

public class SqrtX {
    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(2147483647));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int left = 1;
        int right = x;

        while (right >= left) {
            int mid = left + (right - left) / 2;
            if ((long) mid*mid > (long) x) {
                right = mid-1;
            } else if ((long) mid*mid < (long) x) {
                left = mid+1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
