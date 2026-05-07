package graphs.algos;

public class FloydWarshallAlgo {
    public void shortestDistance(int[][] matrix){
        int n = matrix.length;

        // for every intermediate node k
        for (int k = 0; k < n; k++){

            // check for every node (i, j) pair of nodes
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (matrix[i][k] == -1 || matrix[k][j] == -1)
                        continue;
                    if (matrix[i][j] == -1)
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    else
                        matrix[i][j] = Math.min(matrix[i][j],
                                matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }
}
