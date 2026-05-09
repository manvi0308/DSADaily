package graphs.algos.traversals;

import java.util.List;

public class DFS {
    public void dfs(int V, List<Integer>[] adj, boolean[] visited,
                    List<Integer> result){
        visited[V] = true;
        result.add(V);
        for (int u : adj[V]){
            if (!visited[u]){
                dfs(u, adj, visited, result);
            }
        }
    }
}
