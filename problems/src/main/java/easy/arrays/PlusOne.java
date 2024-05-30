package easy.arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9})));
    }

    public int[] plusOne(int[] digits) {
        if (digits[digits.length-1] != 9) {
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }

        for (int i = digits.length-1; i >= 0 ; i--) {
            if (i == digits.length-1) {
                digits[i] = 0;
                continue;
            }

            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i]+1;
                return digits;
            }
        }
        if (digits[0] == 0) {
            int[] arr = new int[digits.length+1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}
