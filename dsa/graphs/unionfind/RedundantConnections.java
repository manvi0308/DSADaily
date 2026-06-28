package graphs.unionfind;

public class RedundantConnections {
    public int[] findRedundantConnection(int[][] edges) {
        /*
                1 -------------- 2
                 \             /
                   \         /
                     \     /
                        3

             1 -- 2
             1 -- 3, 1--2--3
         */

        int n = edges.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if (!union(u, v, parent, rank))
                // if they are already connected, it's a cycle
                return edge;
        }
        return new int[]{};
    }
    boolean union(int u, int v, int[] parent, int[] rank){
        int pu = parent[u];
        int pv = parent[v];

        if (pu == pv)
            return false;
        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        } else{
            parent[pv] = pu;
            rank[pu]++;
        }
        return true;
    }
}
