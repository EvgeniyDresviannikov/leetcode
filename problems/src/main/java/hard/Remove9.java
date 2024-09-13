package hard;

public class Remove9 {

    public static void main(String[] args) {
        System.out.println(new Remove9().newInteger(300));
    }

    public int newInteger1(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }

    public int newInteger(int n) {
        int counter = 0;
        int ans = 0;

        while(counter < n) {
            counter++;
            ans++;

            while (contains9(ans)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean contains9(int num) {
        while(num > 0) {
            if (num % 10 == 9) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }
}
