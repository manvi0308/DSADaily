package graphs.algos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgo {
    static int[] bellmanFord(int V,ArrayList<ArrayList<Integer>> edges, int Source){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[Source] = 0;

        for (int i = 0; i < V - 1; i++){
            for (ArrayList<Integer> it : edges){
                int u = it.get(0); // starting point of egde
                int v = it.get(1); // ending point of edge
                int wt = it.get(2); // weight

                if( dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for (ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 6;
        int S = 0;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
        edges.add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
        edges.add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
        edges.add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
        edges.add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
        edges.add(new ArrayList<Integer>(Arrays.asList(2, 4,  3)));

        int[] ans = bellmanFord(V, edges, S);
        System.out.println(Arrays.toString(ans));
    }
}
