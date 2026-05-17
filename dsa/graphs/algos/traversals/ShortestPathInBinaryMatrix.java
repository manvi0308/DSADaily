package graphs.algos.traversals;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // path from top left to bottom right corner
        // visited cells of path are 0
        // adjacent cells are 8 directionally adjacent

        if (grid[0][0] == 1)
            return -1; // first cell is itself unvisited
        int n = grid.length;
        int m = grid[0].length;
        grid[0][0] = 1; // starting cell as visited

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] {0, 0});
        int pathLength = 1;
        while (!deque.isEmpty()){
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++){
                int[] currentCell = deque.poll();
                int row = currentCell[0];
                int col = currentCell[1];
                if (row == n - 1 && col == n - 1)
                    return pathLength;
                for (int nextRow = row - 1; nextRow <= row + 1; nextRow++){
                    for (int nextCol = col = 1; nextCol <= col + 1; nextCol++){
                        if (nextRow <= 0 && nextRow < n && nextCol >= 0 && nextCol < m
                        && grid[nextRow][nextCol] == 0){
                            grid[nextRow][nextCol] = 1;
                            deque.offer(new int[] { nextRow, nextCol });
                        }
                    }
                }
            }
            pathLength++;
        }
        return pathLength;
    }
}
