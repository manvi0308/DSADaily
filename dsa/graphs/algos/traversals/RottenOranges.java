package graphs.algos.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        /*
        0 -> empty cell
        1 -> fresh orange
        2 -> rotten orange
         */
        // BFS Queue + Visited/Rotten
       int countFresh = 0;
       int timeTaken = 0;
       Queue<int[]> queue = new LinkedList<>();
       for (int i = 0; i < grid.length; i++){
           for (int j = 0; j < grid[0].length; j++){
               if (grid[i][j] == 2)
                   queue.add(new int[]{i, j});
               if (grid[i][j] == 1)
                   countFresh++;
           }
       }
       if (countFresh == 0)
           return 0;
       int[] xdir = {-1, 1, 0, 0};
       int[] ydir = {0, 0, 1, -1};
       int count = 0;
       while (!queue.isEmpty()){
           int size = queue.size();
           count += size;
           for (int i = 0; i < size; i++) {
               int[] coords = queue.poll();
               for (int j = 0; j < 4; j++) {
                   int newX = coords[0] + xdir[i];
                   int newY = coords[1] + ydir[i];

                   // check if valid
                   if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length
                           || grid[newX][newY] == 2 || grid[newX][newY] == 0)
                       continue;

                   // make it rotten
                   grid[newX][newY] = 2;
                   queue.add(new int[]{newX, newY});
               }
           }
           if (queue.size() != 0)
               timeTaken++;
       }
       return (countFresh == count) ? timeTaken : -1 ;
    }
}
