package Graph.traversal;

import java.util.List;

public class dfsRecursive {
    void dfs(List<List<Integer>> adj, int start){
        int v = adj.size();
        boolean [] visited = new boolean[v];
        visited[start]= true;
        dfsRecursive(adj, start,visited);
    }


    void dfsRecursive(List<List<Integer>> adj, int start, boolean [] visited){

        System.out.print(start+" ");

        for(int neigh : adj.get(start)){
            if(!visited[neigh]){
                visited[neigh]= true;
                dfsRecursive(adj, neigh, visited);
            }
        }


    }

}
