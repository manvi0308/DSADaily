package graphs.algos.traversals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] distances = new int[n][m];
        for (int[] row : distances){
            Arrays.fill(distances, -1);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                    distances[i][j] = 0;
                }
            }
        }

        int[] xdir = {-1, 1, 0, 0};
        int[] ydir = {0, 0, -1, 1};
        while (!queue.isEmpty()){
            int[] currentCell = queue.poll();
            int currentRow = currentCell[0];
            int currentCol = currentCell[1];
            for (int dir = 0; dir < 4; dir++){
                int nRow = currentRow + xdir[dir];
                int nCol = currentCol + ydir[dir];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                &&distances[nRow][nCol] == -1){
                    distances[nRow][nCol] = distances[currentRow][currentCol] + 1;
                    queue.offer(new int[] {nRow, nCol});
                }
            }
        }
        return distances;
    }
}
