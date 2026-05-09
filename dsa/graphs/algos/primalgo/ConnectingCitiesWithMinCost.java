package graphs.algos.primalgo;

import java.util.*;

public class ConnectingCitiesWithMinCost {
    class DisjointSet{
        List<Integer> rank, parent, size;
        public DisjointSet(int n ){
            rank = new ArrayList<>(n + 1);
            Collections.fill(rank, 0);
            parent = new ArrayList<>(n + 1);
            size = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++){
                parent.add(1);
                size.add(1);
            }
        }

        public int findUPar(int node){
            if (node == parent.get(node))
                return node;
            parent.set(node, findUPar(parent.get(node)));
            return parent.get(node);
        }

        public void unionByRank(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v)
                return;
            if (rank.get(ulp_u) < rank.get(ulp_v))
                parent.set(ulp_u, ulp_v);
            else if(rank.get(ulp_v)< rank.get(ulp_u))
                parent.set(ulp_v, ulp_u);
            else{
                parent.set(ulp_v, ulp_u);
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }

        }

        public void unionBySize(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v)
                return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            }
            else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }

        public int spanningTree(int V, List<List<List<Integer>>> adj){
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < V; i++){
                for (List<Integer> it : adj.get(i)){
                    int v = it.get(0);
                    int wt = it.get(1);
                    int u = i;
                    edges.add(new int[]{wt, u, v});
                }
            }
            DisjointSet ds = new DisjointSet(V);
            edges.sort(Comparator.comparingInt(o -> o[0]));
            int sum = 0;
            for (int[] it : edges){
                int wt = it[0]; // edge weight
                int u = it[1]; // first node
                int v = it[2]; // second node


                if (ds.findUPar(u) != ds.findUPar(v)){
                    sum += wt;
                    ds.unionBySize(u, v);
                }
            }
            return sum;
        }
    }
}
