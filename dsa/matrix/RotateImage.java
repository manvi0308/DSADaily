package matrix;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        /*
            Rotate = Reverse Transpose Each column ==> Row ==> Reverse Row
            In place operation

            1, 2, 3
            4, 5, 6
            7, 8, 9

            ==> 1, 4, 7
                2, 5, 8
                3, 6, 9

            mat[0][0] = mat[0][0]
            mat[0][1] = mat[1][0]
            mat[0][2] = mat[2][0]

            mat[1][0] = mat[0][1]
            -----
            mat[2][1] = mat[1][2]

            mat[i][j] = mat[j][i]
         */
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse operation
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - j - 1] = temp;
            }
        }
        for(int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage ri = new RotateImage();
        ri.rotate(matrix);
    }
}
