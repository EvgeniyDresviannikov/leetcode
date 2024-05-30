package easy.recursion;

public class PowerOfTwo {

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();

        System.out.println(powerOfTwo.isPowerOfTwo(34));
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n%2 > 0) return false;
        return isPowerOfTwo(n/2);
    }
}
