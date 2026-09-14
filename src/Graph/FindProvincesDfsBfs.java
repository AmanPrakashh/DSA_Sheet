package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FindProvincesDfsBfs {
// bfs
    int findProvincesBfs(int [][] adj){

        int v= adj.length;
        boolean [] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        int provinces=0;

        for(int i=0; i<v; i++){
            if(!visited[i]){
                provinces++;
                queue.offer(i);
                visited[i]= true;
                bfs(adj, visited, queue);
            }
        }
        return provinces;
    }

    void bfs(int [][] adj, boolean [] visited, Queue<Integer> queue){

        if(queue.isEmpty()) return;
        int city =queue.poll();

        for(int i=0; i<adj[city].length; i++){
            if(!visited[i] && adj[city][i]==1){
                queue.offer(i);
                visited[i]=true;
            }
        }
        bfs(adj, visited, queue);
    }


    // bfs
    int findProvincesDfs(int [][] adj){
        int v= adj.length;
        boolean [] visited = new boolean[v];
        int provinces=0;

        for(int i=0; i<v; i++){
            if(!visited[i]){
                provinces++;
                visited[i]= true;
                dfs(adj, visited, i);
            }
        }
        return provinces;
    }

    void dfs(int [][] adj, boolean [] visited, int start){
        for(int i=0; i<adj[start].length; i++){
            if(!visited[i] && adj[start][i]==1){
                visited[i]=true;
                dfs(adj, visited, i);
            }
        }
    }
}
