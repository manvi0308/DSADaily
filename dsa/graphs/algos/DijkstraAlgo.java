package graphs.algos;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    public int[] dijkstraAlgo(int V, List<List<int[]>> adj, int src){
        int[] dist = new int[V];
        // initialzing dist with infnity
        Arrays.fill(dist, (int)1e9);

        // Min heap storing <distance, node>
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        dist[src] = 0;
        
        while (!pq.isEmpty()){
            int[] curr = pq.poll();

            int d = curr[0];
            int node = curr[1];

            if (d > dist[node])
                continue;
            for(int[] edge : adj.get(node)){
                int next = edge[0];
                int wt = edge[1];

                if (dist[node] + wt < dist[next]){
                    dist[next] = dist[node] + wt;
                    pq.add(new int[]{dist[next], next});
                }
            }
        }
        return dist;
    }
}
