package medium.TwoPointers;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1.13.2.0", "1.13.000201"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0, j = 0;
        int n = v1.length, m = v2.length;
        while (i < n || j < m) {
            int v1Int = i < n ? Integer.parseInt(v1[i]) : 0;
            int v2Int = j < m ? Integer.parseInt(v2[j]) : 0;

            if (v1Int != v2Int) return v2Int > v1Int ? -1 : 1;

            i++;
            j++;
        }

        return 0;
    }
}
