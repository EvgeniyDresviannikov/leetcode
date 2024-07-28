package array.string.easy;

public class FindTheIndexOfFirstOccurence {

    public static void main(String[] args) {
        System.out.println(new FindTheIndexOfFirstOccurence().strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.startsWith(needle, i)) return i;
        }

        return -1;
    }
}
