package hard;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();

        System.out.println(regularExpressionMatching.isMatch("aaa", "aaaa"));
    }

    public boolean isMatch(String s, String p) {

        if (!p.contains(".") && !p.contains("*")) {
            return s.equals(p);
        }

        int j = 0;
        String prev = "";
        String[] pArr = p.split("");
        String[] sArr = s.split("");
        for (int i = 0; i < sArr.length; i++) {
            if (j >= pArr.length) return false;

            if (pArr[j].equals(".")) {
                j++;
                prev = ".";
                continue;
            }

            if (pArr[j].equals("*")) {
                if (sArr[i].equals(prev) || prev.equals(".")) {
                    continue;
                } else {
                    j++;
                    i--;
                    prev = "";
                    continue;
                }
            }

            if (pArr[j].equals(sArr[i])) {
                j++;
                prev = sArr[i];
                continue;
            } else {
                if (pArr[j+1].equals("*")) {
                    prev = pArr[j];
                    j++;
                    i--;
                    continue;
                }
                return false;
            }
        }

        if (j < pArr.length-1) return false;

        return true;

    }



}
