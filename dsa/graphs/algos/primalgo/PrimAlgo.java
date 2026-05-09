package graphs.algos.primalgo;

import java.util.List;
import java.util.PriorityQueue;

public class PrimAlgo {
    public static int primMST( int n, List<int[]>[] adj){
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0});

        int totalWeight = 0;
        int edgesUsed = 0;
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int w = curr[0];
            int node = curr[1];

            if (visited[node])
                continue;
            visited[node] = true;
            totalWeight += w;
            edgesUsed++;

            if (edgesUsed == n)
                break; // MST completed
            for (int[] edge: adj[node]){
                int weight = edge[0];
                int neighbour = edge[1];
                if (!visited[neighbour])
                    pq.offer(new int[]{weight, neighbour});
            }
        }
        return edgesUsed == n ? totalWeight : -1;
    }

}
