package easy.arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String firstWord = strs[0];
        String[] firstWordArray = firstWord.split("");
        String substr = "";
        int j = 0;
        while (j < firstWord.length()) {
            substr = substr + firstWordArray[j];
            for (String str : strs) {
                if (!str.startsWith(substr)) {
                    return substr.substring(0, substr.length() - 1);
                }
            }
            j++;
        }
        return substr;
    }
}
