package binarysearch;

public class MatrixMedian {
    static int countLessEqual(int[] row, int element){
        // count the number of elements that are less than or equal to this element
        int low = 0;
        int high = row.length;
        while (low < high){
            int m = (low + high)/2;
            if (row[m] <= element)
                low = m + 1;
            else high = m;
        }
        return low;
    }
    static int matrixMedian(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = matrix[0][0]; // first row, first col element
        int high = matrix[0][cols - 1]; // first row, last col element

        for (int i = 1; i < rows; i++){
            // lowest element will always be one of the 0th column element
            // amongst all the rows
            low = Math.min(low, matrix[i][0]);
            high = Math.min(high, matrix[i][cols - 1]);
        }
        while (low < high){
            int mid = ( low + high )/2;
            int count = 0;
            for (int i = 0; i < rows; i++){
                count += countLessEqual(matrix[i], mid);
            }
            if (count < (rows * cols + 1 )/2)
                low = mid + 1;
            else
                high = mid;
        }
        return low;

    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(matrixMedian(matrix));
    }
}
