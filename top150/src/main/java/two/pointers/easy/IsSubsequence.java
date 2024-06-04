package two.pointers.easy;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("acb", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        int sp = 0;

        for (int i = 0; i < t.length(); i++) {
            char currLetter = t.charAt(i);
            if (s.charAt(sp) == currLetter) {
                sp++;
            }

            if (sp == s.length()) {
                return true;
            }
        }

        return false;
    }
}
