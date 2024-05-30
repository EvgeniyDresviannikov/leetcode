package easy.string;

public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
    }
    public int lengthOfLastWord(String s) {
        int counter = 0;
        int i = s.length()-1;

        while (i >= 0) {
            if (counter != 0 && s.charAt(i) == ' ') { return counter; }

            if (s.charAt(i) != ' ') {
                counter++;
            }

            i--;
        }
        return counter;
    }
}

