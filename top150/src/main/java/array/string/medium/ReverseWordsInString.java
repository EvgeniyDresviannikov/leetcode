package array.string.medium;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("  hello   world  ")); // eulb si yks eht  //
    }

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder reversed = new StringBuilder();
        boolean isSpace = false;
        for (int i = s.length()-1; i > -1; i--) {
            if (s.charAt(i) == ' ' && isSpace) {
                continue;
            }

            reversed.append(s.charAt(i));
            isSpace = s.charAt(i) == ' ';

        }

        int start = 0;
        int end = 0;

        StringBuilder res = new StringBuilder();

        while (end < reversed.length()) {
            if (reversed.charAt(end) != ' ' && end != reversed.length()-1) {
                end++;
            } else {
                int idx = end == reversed.length()-1 ? end : end-1;
                while (idx >= start) {
                    res.append(reversed.charAt(idx));
                    idx--;
                }
                if (end != reversed.length()-1) {
                    res.append(" ");
                }

                end++;
                start = end;
            }
        }

        return res.toString();
    }
}
