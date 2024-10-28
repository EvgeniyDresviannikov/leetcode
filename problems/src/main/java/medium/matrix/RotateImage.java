package medium.matrix;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        new RotateImage().rotate(matrix);

        System.out.println(matrix[0][0]);
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int left = 0; int top = 0;
        int right = len - 1; int bottom = len - 1;

        while (left < right) {
            int i = left;

            for (int shift = 0; shift < right - left; shift++) {
                int tmp = matrix[top][i+shift];
                matrix[top][i+shift] = matrix[bottom - shift][left];
                matrix[bottom - shift][left] = matrix[bottom][right - shift];
                matrix[bottom][right - shift] = matrix[top + shift][right];
                matrix[top + shift][right] = tmp;

            }

            left += 1;
            right -= 1;
            top += 1;
            bottom -= 1;

        }
    }
}
