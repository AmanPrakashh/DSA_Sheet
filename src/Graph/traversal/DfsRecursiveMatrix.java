package Graph.traversal;

public class DfsRecursiveMatrix {

   void  dfs(int[][] adj, int start){

       int v= adj.length;
       boolean [] visited = new boolean[v];
       visited[start]= true;

       dfsRecursive(adj, start, visited);
    }

    void dfsRecursive(int [][] adj, int start, boolean[] visited){
        System.out.print(start+" ");

        for(int i=0; i<adj[start].length; i++){
            if(!visited[i] && adj[start][i]==1){
                visited[i]=true;
                dfsRecursive(adj, i, visited);
            }
        }
    }

}
