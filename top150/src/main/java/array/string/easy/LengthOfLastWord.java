package array.string.easy;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("     "));
    }

    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        while (i > -1 && s.charAt(i) == ' ') {
            i--;
        }

        if (i == -1) return 0;

        int cnt = 0;
        while (i > -1 && s.charAt(i) != ' ') {
            cnt++;
            i--;
        }

        return cnt;
    }

}
