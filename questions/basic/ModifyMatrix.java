package basic;

import java.util.Arrays;

public class ModifyMatrix {
    public static int [][] modifiedMatrix(int[][] matrix){
        int[][] res = new int[matrix.length][matrix[0].length];
        int[] maxValueForCol = new int[matrix[0].length];
        Arrays.fill(maxValueForCol, -1);
        // iterate over each column
        for (int j = 0; j < matrix[0].length; j++){
            for (int i = 0; i < matrix.length; i++){
                maxValueForCol[j] =  Math.max(maxValueForCol[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] != -1){
                    res[i][j] = matrix[i][j];
                } else{
                    res[i][j] = maxValueForCol[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[][] matrix = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}};
        int[][] matrix = {{3, -1}, {5, 2}};
        int[][] ans = modifiedMatrix(matrix);
        for (int i = 0; i < ans.length; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
