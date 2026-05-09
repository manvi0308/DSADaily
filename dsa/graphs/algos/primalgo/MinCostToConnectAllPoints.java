package graphs.algos.primalgo;

import java.util.Arrays;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points){
        /*
        *
        * BASIC PRIM ALGO, each vertex will be the x and y coordinate
        * weight will be the distance between them
        *
        * The cost of connecting two points [xi, yi] and [xj, yj] is the
        * manhattan distance between them: |xi - xj| + |yi - yj|,
        * where |val| denotes the absolute value of val.
        */
        final int INF = 1<<30;
        int n = points.length;

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x1 - x2)+ Math.abs(y1 - y2);
                graph[i][j] = distance;
                graph[j][i] = distance;
            }
        }

        int[] minDistance = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(minDistance, INF);
        minDistance[0] = 0;
        int totalCost = 0;

        for (int i = 0; i < n; i++){
            int minIndex = -1;
            for (int k = 0; k < n; k++){
                if (!visited[k] && (minIndex == -1 || minDistance[k] < minDistance[minIndex])){
                    minIndex = k;
                }
            }

            visited[minIndex] = true;
            totalCost += minDistance[minIndex];

            for (int k = 0; k < n; ++k){
                if (!visited[k]){
                    minDistance[k] = Math.min(minDistance[k], graph[minIndex][k]);
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    }
}
