package Graph.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsRecursive {

    void bfs(List<List<Integer>> adj, int start){
        int v = adj.size();
        boolean [] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start]= true;
        bfsRecursive(adj, visited, queue);
    }


    void bfsRecursive(List<List<Integer>> adj, boolean[] visited, Queue<Integer> queue){

        if(queue.isEmpty()) return;
        int node =queue.poll();
        System.out.print(node+" ");

        for(int neighbour : adj.get(node)){

            if(!visited[neighbour]){
                visited[neighbour]=true;
                queue.offer(neighbour);
            }
        }
        bfsRecursive(adj, visited, queue);
    }
}
