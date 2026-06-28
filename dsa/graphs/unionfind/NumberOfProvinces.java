package graphs.unionfind;

import java.util.Arrays;

public class NumberOfProvinces {
    class UnionFind{
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int count) {
            parent = new int[count];
            rank = new int[count];
            this.count = count;

            for(int i = 0; i < count; i++)
                parent[i] = i;
        }
        int find(int x){
            if (parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b){
            int parentA = find(a);
            int parentB = find(b);

            if (parentA == parentB)
                return;
            if (rank[parentA] < rank[parentB])
                parent[parentA] = parentB;
            else if(rank[parentA] > rank[parentB])
                parent[parentB] = parentA;
            else{
                parent[parentB] = parentA;
                rank[parentA]++;
            }
            count--;
        }
    }
    public int findCircleNum(int[][] isConected){
        UnionFind uf = new UnionFind(isConected.length);
        int citiesCount = isConected.length;
        for(int i = 0; i < citiesCount; i++){
            for (int j = 0; j < citiesCount; j++){
                if (isConected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}
