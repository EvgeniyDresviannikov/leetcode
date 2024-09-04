package array.string.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonPrefix(strs[i], prefix);
            if (prefix.isEmpty()) return "";
        }

        return prefix;
    }

    private String getCommonPrefix(String word, String prefix) {
        int len = prefix.length();
        while (len > 0) {
            if (word.startsWith(prefix)) return prefix;
            len = len - 1;
            prefix = prefix.substring(0, len);
        }

        return "";
    }

}
