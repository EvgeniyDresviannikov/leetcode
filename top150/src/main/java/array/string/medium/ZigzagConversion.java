package array.string.medium;


public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int increment = 2*(numRows-1);
            for (int j = i; j < s.length(); j += increment) {
                res.append(s.charAt(j));
                if (i > 0 && i < numRows-1 && j + increment - 2*i < s.length()) {
                    res.append(s.charAt(j + increment - 2*i));
                }
            }
        }

        return res.toString();
    }
}
