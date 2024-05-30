package easy.twopointers;

public class FindTheIndexOf1stOccurrenceInString {

    public static void main(String[] args) {
        FindTheIndexOf1stOccurrenceInString findTheIndexOf1stOccurrenceInString = new FindTheIndexOf1stOccurrenceInString();
        System.out.println(findTheIndexOf1stOccurrenceInString.strStr("sadbutsad", "sad"));
    }


    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        int m = haystack.length();
        int n = needle.length();


        for (int i = 0; i <= m-n; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (j == n-1)  return i;
            }
        }

        return -1;
    }
}
