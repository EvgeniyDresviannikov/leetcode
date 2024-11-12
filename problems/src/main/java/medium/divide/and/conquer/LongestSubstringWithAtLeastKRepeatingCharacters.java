package medium.divide.and.conquer;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("ababbc", 2));
    }

    public int longestSubstring(String s, int k) {
        return helper(0, s.length(), k, s.toCharArray());
    }

    private int helper(int start, int end, int k, char[] ch) {
        if (end - start < k) return 0;

        int[] arr = new int[26];
        for (int i = start; i < end; i++) {
            arr[ch[i] - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (arr[ch[i] - 'a'] < k) {
                int j = i + 1;
                while (j < end && arr[ch[j] - 'a'] < k) j++;

                return Math.max(helper(start, i, k, ch), helper(j, end, k, ch));
            }

        }

        return end - start;
    }
}
