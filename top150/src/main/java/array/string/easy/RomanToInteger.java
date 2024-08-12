package array.string.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("IV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> romanToInteger = new HashMap<>();

        romanToInteger.put('I',1);
        romanToInteger.put('V', 5);
        romanToInteger.put('X', 10);
        romanToInteger.put('L', 50);
        romanToInteger.put('C', 100);
        romanToInteger.put('D', 500);
        romanToInteger.put('M', 1000);


        int cur = romanToInteger.get(s.charAt(0));
        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            int next = romanToInteger.get(s.charAt(i));
            if (cur < next) {
                res -= cur;
            } else {
                res += cur;
            }

            cur = next;
        }

        res += cur;

        return res;
    }
}
