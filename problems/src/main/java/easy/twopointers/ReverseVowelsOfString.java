package easy.twopointers;

import java.util.Set;

public class ReverseVowelsOfString {

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int left = 0;
        int right = s.length()-1;
        char[] chars = s.toCharArray();

        while (left < right) {
            while (left < chars.length && !vowels.contains(chars[left])) left++;
            while (right > -1 && !vowels.contains(chars[right])) right--;

            if (left >= right) break;

            swap(left, right, chars);
            left++;
            right--;

        }

        return String.valueOf(chars);

    }

    private void swap(int i, int j, char[] chars) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
