package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    /*
    (i, j)
    (i - 1, j)
    (i, j + 1)
    (i, j - 1)
    (i + 1, j )

     */
    public void bfs(int[][] grid, int r, int c, boolean[][] visited){
        visited[r][c] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int[] dr = {-1, 0, 0, 1 };
        int[] dc = {0, 1, -1, 0 };
        while (!queue.isEmpty()){
            for (int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = r + dc[i];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length &&
                        grid[nr][nc] == 1 && !visited[nr][nc])
                {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
    public int numIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int countIslands = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                // unvisited lands
                if (grid[i][j] == 1 && !visited[i][j]){
                    countIslands++;
                    bfs(grid, i, j, visited);
                }
            }
        }

        return countIslands;
    }
}
