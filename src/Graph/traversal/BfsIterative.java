package Graph.traversal;

import java.util.*;

public class BfsIterative {
    void bsIteative(List<List<Integer>> adj, int start){

        int v= adj.size();
        boolean [] visited= new boolean[v];
        visited[start]= true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){

            int node =queue.poll();
            System.out.print(node+" ");

            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    queue.offer(neigh);
                    visited[neigh]=true;
                }
            }
        }
    }
}
