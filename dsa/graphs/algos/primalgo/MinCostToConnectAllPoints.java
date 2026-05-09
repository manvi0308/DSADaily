package graphs.algos.primalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    public static int minCostConnectPoints(int[][] points){
        int n = points.length;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int dist = Math.abs(points[i][0] -  points[j][0] ) +
                        Math.abs(points[i][1] - points[j][1]);
                adj[i].add(new int[]{dist, j}); // {cost, neighbour}
                adj[j].add(new int[]{dist, i}); // undirected graph,so revered will hold true as well
            }
        }
        for(List<int[]> it : adj) {
            for (int[] iter : it )
                System.out.print(Arrays.toString(iter));
            System.out.println();
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] inMST = new boolean[n];
        pq.offer(new int[]{0, 0});
        int totalCost = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty() && edgesUsed < n){
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];

            if (inMST[node])
                continue;
            inMST[node] = true;
            totalCost += cost;
            edgesUsed++;

            for (int[] neighbour : adj[node]){
                int nCost = neighbour[0];
                int nNode = neighbour[1];
                if (!inMST[nNode])
                    pq.offer(new int[]{nCost, nNode});
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int res =  minCostConnectPoints(points);
        System.out.println(res);
    }
}
