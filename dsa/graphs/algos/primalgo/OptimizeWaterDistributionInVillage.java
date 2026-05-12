package graphs.algos.primalgo;

import java.util.Arrays;

public class OptimizeWaterDistributionInVillage {
    private int[] parent;
    public int find(int node){
        if (parent[node] != node)
            parent[node] = find(parent[node]);
        return parent[node];
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes ){
        int[][] edges = Arrays.copyOf(pipes, pipes.length + n);
        for (int i = 0; i < n; i++){
            edges[pipes.length + 1] = new int[]{0, i + 1, wells[i]};
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }
        int totalCost = 0;
        int edgesUsed = 0;
        for (int[] edge : edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            int cost = edge[2];

            int rootA = find(nodeA);
            int rootB = find(nodeB);
            if (rootA != rootB){
                parent[rootA] = rootB;
                totalCost += cost;
                edgesUsed++;

                if (edgesUsed == n)
                    return totalCost;
            }
        }
        return totalCost;
    }
}
