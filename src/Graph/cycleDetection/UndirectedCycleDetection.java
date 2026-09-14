package Graph.cycleDetection;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedCycleDetection {


    boolean hasCycleUndirectedDfs(int[][] adj) {
        int v = adj.length;
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfsUndirected(adj, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfsUndirected(int[][] adj,int node, boolean[] visited,  int parent) {
        visited[node] = true;

        for (int i = 0; i < adj[node].length; i++) {
            if (adj[node][i] == 1) {
                if (!visited[i]) {
                    if (dfsUndirected(adj, i, visited, node)) { // this if check is important
                        return true; // cycle found deeper
                    }
                } else if (i != parent) { // isme basically you are checking if next Node (i) is not the parent caller of current node
                                         //  so you already checked if the node is visited, so total condition is if next visited already and
                                        //   wo current node(Caller ka ) ka prent nahi hai means cycle hai boss
                    return true;
                }
            }
        }
        return false; // no cycle found from this path
    }













    boolean hasCycleUndirectBfs(int [][] adj){
        int v=adj.length;
        boolean[] visited = new boolean[v];

        for(int i=0; i<v; i++){
            if(!visited[i]) {
                Queue<int []> queue = new LinkedList<>();
                queue.offer(new int[]{i, -1});
                visited[i]= true;
                if(bfsUndirected(adj, visited, queue)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean bfsUndirected(int[][] adj, boolean[] visited, Queue<int[]> queue) {
        if(queue.isEmpty()) return false; // means queue is empty and no cycle found
                                         // not required in iterative approach.
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int start= curr[0];
            int parent = curr[1];
            for(int i=0; i<adj[start].length; i++){
                if(adj[start][i]==1){
                    if(!visited[i]) {
                        visited[i]= true;
                        queue.offer(new int[]{i, start});
                    }
                    else if(i!=parent) return true;

                }
            }
        }
        return false;
    }

}
