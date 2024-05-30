package easy.math;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(7));
    }

    public boolean isHappy(int n) {
        if (n == 1 || n == 7) return true;
        if (n < 10) return false;

        int sum = 0;
        while (n != 0) {
            sum = sum + (n % 10)*(n % 10);
            n = n / 10;
        }
        return isHappy(sum);
    }
}
